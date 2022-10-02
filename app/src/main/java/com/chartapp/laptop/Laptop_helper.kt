package com.chartapp.laptop

import android.content.Context
import android.database.sqlite.SQLiteQueryBuilder
import android.widget.Toast
import com.chartapp.Data
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper

class Laptop_helper(var context: Context) : SQLiteAssetHelper(
    context, DATABASE_NAME, null, DATABASE_VERSION
) {
    companion object {
        var tab_name: String? = null
        private const val DATABASE_NAME = "laptop.db"
        private const val DATABASE_VERSION = 1
    }

    init {
        setForcedUpgrade(1)
    }

    val allData: ArrayList<Data>?
        get() = try {
            val list = ArrayList<Data>()
            val sqLiteDatabase = writableDatabase
            if (sqLiteDatabase != null) {
                val cursor = sqLiteDatabase.rawQuery("select * from " + tab_name, null)

                if (cursor.count != 0) {
                    while (cursor.moveToNext()) {
                        val name = cursor.getString(0)
                        val ref = cursor.getString(1)
                        var other = cursor.getString(2)
                        if(other == null) other = ""
                        list.add(Data(name, ref, other))
                    }
                    list
                } else {
                    Toast.makeText(context, "No data retired", Toast.LENGTH_SHORT).show()
                    null
                }
            } else {
                Toast.makeText(context, "Motherboard_data is null", Toast.LENGTH_SHORT).show()
                null
            }
        } catch (e: Exception) {
            Toast.makeText(context, "getalldata" + e.message, Toast.LENGTH_SHORT).show()
            e.printStackTrace()
            null
        }
    val upgradeVersion: Int
        get() {
            val db = readableDatabase
            val qb = SQLiteQueryBuilder()
            val sqlSelect = arrayOf("MAX (version)")
            val sqlTables = "upgrades"
            qb.tables = sqlTables
            val c = qb.query(
                db, sqlSelect, null, null,
                null, null, null
            )
            var v = 0
            c.moveToFirst()
            if (!c.isAfterLast) {
                v = c.getInt(0)
            }
            c.close()
            return v
        }


}