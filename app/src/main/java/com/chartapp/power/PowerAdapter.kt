package com.chartapp.power

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
import com.chartapp.power.Power_catalog
import android.widget.Filter.FilterResults
import android.widget.Filterable
import android.widget.ImageView
import java.util.*

class PowerAdapter(exampleList: MutableList<CommonData>) :
    RecyclerView.Adapter<PowerAdapter.ViewHolder>(), Filterable {
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
            val intent = Intent(v.context, Power_catalog::class.java)
            when (position) {
                0 -> intent.putExtra("testNameData", "atx")
                1 -> intent.putExtra("testNameData", "cheftec")
                2 -> intent.putExtra("testNameData", "colorsit")
                3 -> intent.putExtra("testNameData", "coolermaster")
                4 -> intent.putExtra("testNameData", "corsair")
                5 -> intent.putExtra("testNameData", "cwt")
                6 -> intent.putExtra("testNameData", "dell")
                7 -> intent.putExtra("testNameData", "delta")
                8 -> intent.putExtra("testNameData", "dtk")
                9 -> intent.putExtra("testNameData", "fsp")
                10 -> intent.putExtra("testNameData", "green")
                11 -> intent.putExtra("testNameData", "jnc")
                12 -> intent.putExtra("testNameData", "laptop")
                13 -> intent.putExtra("testNameData", "liteon")
                14 -> intent.putExtra("testNameData", "maxpower")
                15 -> intent.putExtra("testNameData", "microlab")
                16 -> intent.putExtra("testNameData", "powerman")
                17 -> intent.putExtra("testNameData", "powermaster")
                18 -> intent.putExtra("testNameData", "seventeam")
                19 -> intent.putExtra("testNameData", "thermaltake")
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
            exampleList.clear()
            exampleList.addAll(results.values as Collection<CommonData>)
            notifyDataSetChanged()
        }
    }


}