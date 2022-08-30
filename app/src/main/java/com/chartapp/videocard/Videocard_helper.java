package com.chartapp.videocard;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.widget.Toast;

import com.chartapp.Data;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;

public class Videocard_helper extends SQLiteAssetHelper {
    static String tab_name;
    private static final String DATABASE_NAME = "videocard.db";
    private static final int DATABASE_VERSION = 1;
    Context context;



    public Videocard_helper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
        setForcedUpgrade(1);

    }
    public ArrayList<Data> getAllData(){
        try {
            ArrayList<Data> list = new ArrayList<>();
            SQLiteDatabase sqLiteDatabase = getWritableDatabase();
            if(sqLiteDatabase != null){
                Cursor cursor = sqLiteDatabase.rawQuery("select * from "+tab_name,null);
                if(cursor.getCount() != 0){
                    while (cursor.moveToNext()){
                        String name = cursor.getString(0);
                        String ref = cursor.getString(1);
                        String other = cursor.getString(2);
                        list.add(new Data(name,ref,other));
                    }
                    return list;
                }
                else {
                    Toast.makeText(context, "No data retired", Toast.LENGTH_SHORT).show();
                    return null;
                }
            }
            else {
                Toast.makeText(context, "Motherboard_data is null", Toast.LENGTH_SHORT).show();
                return null;
            }


        } catch (Exception e) {
            Toast.makeText(context, "getalldata" + e.getMessage(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
            return null;
        }
    }
    public int getUpgradeVersion() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String [] sqlSelect = {"MAX (version)"};
        String sqlTables = "upgrades";

        qb.setTables(sqlTables);
        Cursor c = qb.query(db, sqlSelect, null, null,
                null, null, null);

        int v = 0;
        c.moveToFirst();
        if (!c.isAfterLast()) {
            v = c.getInt(0);
        }
        c.close();
        return v;
    }

}
