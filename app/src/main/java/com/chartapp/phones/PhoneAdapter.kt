package com.chartapp.phones

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
import com.chartapp.phones.Phone_catalog
import android.widget.Filter.FilterResults
import android.widget.Filterable
import android.widget.ImageView
import java.util.*

class PhoneAdapter(exampleList: MutableList<CommonData>) :
    RecyclerView.Adapter<PhoneAdapter.ViewHolder>(), Filterable {
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
            val intent = Intent(v.context, Phone_catalog::class.java)
            when (position) {
                0 -> intent.putExtra("testNameData", "xiaomi")
                1 -> intent.putExtra("testNameData", "apple")
                2 -> intent.putExtra("testNameData", "asus")
                3 -> intent.putExtra("testNameData", "samsung")
                4 -> intent.putExtra("testNameData", "huawei")
                5 -> intent.putExtra("testNameData", "blackberry")
                6 -> intent.putExtra("testNameData", "meizu")
                7 -> intent.putExtra("testNameData", "oppo")
                8 -> intent.putExtra("testNameData", "nokia")
                9 -> intent.putExtra("testNameData", "lg")
                10 -> intent.putExtra("testNameData", "lenovo")
                11 -> intent.putExtra("testNameData", "fly")
                12 -> intent.putExtra("testNameData", "motorola")
                13 -> intent.putExtra("testNameData", "panasonic")
                14 -> intent.putExtra("testNameData", "pantech")
                15 -> intent.putExtra("testNameData", "sharp")
                16 -> intent.putExtra("testNameData", "siemens")
                17 -> intent.putExtra("testNameData", "eric")
                18 -> intent.putExtra("testNameData", "sony")
                19 -> intent.putExtra("testNameData", "voxtel")
                20 -> intent.putExtra("testNameData", "wexler")
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