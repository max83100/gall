package com.chartapp.monitors

import com.chartapp.CommonData
import androidx.recyclerview.widget.RecyclerView
import android.widget.TextView
import com.chartapp.R
import android.view.ViewGroup
import android.view.LayoutInflater
import android.annotation.SuppressLint
import android.content.Intent
import android.view.View
import android.widget.Filter
import com.chartapp.mainboard.Mainboard_catalog
import android.widget.Filterable
import android.widget.ImageView
import java.util.*

class Monitor_adapter(exampleList: ArrayList<CommonData>) :
    RecyclerView.Adapter<Monitor_adapter.ViewHolder>(), Filterable {

    private val exampleList: List<CommonData>
    private val exampleListFull: List<CommonData>

    init {
        this.exampleList = exampleList
        exampleListFull = ArrayList(exampleList)
    }

    inner class ViewHolder internal constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var imageView: ImageView
        var textView1: TextView
        var textView2: TextView

        init {
            imageView = itemView.findViewById(R.id.piccatalog)
            textView1 = itemView.findViewById(R.id.namecatalog)
            textView2 = itemView.findViewById(R.id.countcatalog)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(
            R.layout.catalog,
            parent, false
        )
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        val currentItem = exampleList[position]
        holder.imageView.setImageResource(currentItem.imageView)
        holder.textView1.text = currentItem.name
        holder.textView2.text = currentItem.count
        holder.itemView.setOnClickListener { v ->
            val intent = Intent(v.context, Monitor_catalog::class.java)
            when (position) {
                0 -> intent.putExtra("testNameData", "acer")
                1 -> intent.putExtra("testNameData", "aoc")
                2 -> intent.putExtra("testNameData", "belinea")
                3 -> intent.putExtra("testNameData", "benq")
                4 -> intent.putExtra("testNameData", "compaq")
                5 -> intent.putExtra("testNameData", "ctx")
                6 -> intent.putExtra("testNameData", "daewoo")
                7 -> intent.putExtra("testNameData", "dell")
                8 -> intent.putExtra("testNameData", "hansol")
                9 -> intent.putExtra("testNameData", "hyndai")
                10 -> intent.putExtra("testNameData", "iiyama")
                11 -> intent.putExtra("testNameData", "lg")
                12 -> intent.putExtra("testNameData", "mag")
                13 -> intent.putExtra("testNameData", "philips")
                14 -> intent.putExtra("testNameData", "samsung")
            }
            v.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return exampleList.size
    }

    override fun getFilter(): Filter {
        return exampleFilter
    }

    private val exampleFilter: Filter = object : Filter() {
        override fun performFiltering(constraint: CharSequence): FilterResults {
            val filteredList: MutableList<CommonData> = ArrayList()
            if (constraint.length == 0) {
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
            exampleList.clear()
            exampleList.addAll(results.values as Collection<CommonData> )
            notifyDataSetChanged()
        }
    }


}