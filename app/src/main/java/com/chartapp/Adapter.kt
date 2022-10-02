package com.chartapp

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.chartapp.Adapter.MyViewHolder
import java.util.*

class Adapter(objData: ArrayList<Data>) : RecyclerView.Adapter<MyViewHolder>(), Filterable {
    var objData: ArrayList<Data>?
    var intent: Intent? = null
    private val exampleListFull: List<Data>

    init {
        this.objData = objData
        exampleListFull = ArrayList(objData)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val singleRow = LayoutInflater.from(parent.context).inflate(R.layout.list, parent, false)
        return MyViewHolder(singleRow)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val objData = objData!![position]
        holder.name.text = objData.name
        holder.other.text = objData.other
        holder.name.setOnClickListener { v ->
            intent = Intent(Intent.ACTION_VIEW, Uri.parse(objData.ref))
            v.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return if (objData == null) 0 else objData!!.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView
        var other: TextView

        init {
            name = itemView.findViewById(R.id.name)
            other = itemView.findViewById(R.id.other)
        }
    }

    override fun getFilter(): Filter {
        return exampleFilter
    }

    private val exampleFilter: Filter = object : Filter() {
        override fun performFiltering(constraint: CharSequence): FilterResults {
            val filteredList: MutableList<Data> = ArrayList()
            if (constraint == null || constraint.length == 0) {
                filteredList.addAll(exampleListFull)
            } else {
                val filterPattern =
                    constraint.toString().lowercase(Locale.getDefault()).trim { it <= ' ' }
                for (item in exampleListFull) {
                    if (item.name.lowercase(Locale.getDefault()).contains(filterPattern)) {
                        filteredList.add(item)
                    }
                }
            }
            val results = FilterResults()
            results.values = filteredList
            return results
        }

        override fun publishResults(constraint: CharSequence, results: FilterResults) {
            objData.clear()
            objData.addAll(results.values as Collection<Data>)
            notifyDataSetChanged()
        }
    }


}