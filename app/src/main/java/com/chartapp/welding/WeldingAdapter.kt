package com.chartapp.welding

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.chartapp.CommonData
import com.chartapp.R
import java.util.*

class WeldingAdapter(exampleList: MutableList<CommonData>?) :
    RecyclerView.Adapter<WeldingAdapter.ViewHolder>(), Filterable {

    private val exampleList: List<CommonData>
    private val exampleListFull: List<CommonData>

    init {
        this.exampleList = exampleList!!
        exampleListFull = ArrayList(exampleList)
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
            if (exampleList != null) {
                exampleList.clear()
            }
            if (exampleList != null) {
                exampleList.addAll(results.values as Collection<CommonData>)
            }
            notifyDataSetChanged()
        }
    }

    inner class ViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        var imageView: ImageView
        var textView1: TextView
        var textView2: TextView
        override fun onClick(v: View) {
            val pos = layoutPosition
            val intent = Intent(v.context, Welding_catalog::class.java)
            when (pos) {
                0 -> intent.putExtra("testNameData", "kedr")
                1 -> intent.putExtra("testNameData", "ptk")
                2 -> intent.putExtra("testNameData", "solaris")
                3 -> intent.putExtra("testNameData", "gladiator")
                4 -> intent.putExtra("testNameData", "kalibr")
                5 -> intent.putExtra("testNameData", "kontur")
                6 -> intent.putExtra("testNameData", "linkor")
                7 -> intent.putExtra("testNameData", "mangust")
                8 -> intent.putExtra("testNameData", "neon")
                9 -> intent.putExtra("testNameData", "pdg")
                10 -> intent.putExtra("testNameData", "piton")
                11 -> intent.putExtra("testNameData", "pulsar")
                12 -> intent.putExtra("testNameData", "resanta")
                13 -> intent.putExtra("testNameData", "rikon")
                14 -> intent.putExtra("testNameData", "svarog")
                15 -> intent.putExtra("testNameData", "sputnik")
                16 -> intent.putExtra("testNameData", "termit")
                17 -> intent.putExtra("testNameData", "technotron")
                18 -> intent.putExtra("testNameData", "torus")
                19 -> intent.putExtra("testNameData", "feb")
                20 -> intent.putExtra("testNameData", "forsazh")
                21 -> intent.putExtra("testNameData", "ciklon")
                22 -> intent.putExtra("testNameData", "aotai")
                23 -> intent.putExtra("testNameData", "aurora")
                24 -> intent.putExtra("testNameData", "blueweld")
                25 -> intent.putExtra("testNameData", "bestweld")
                26 -> intent.putExtra("testNameData", "brima")
                27 -> intent.putExtra("testNameData", "cebora")
                28 -> intent.putExtra("testNameData", "cemont")
                29 -> intent.putExtra("testNameData", "china")
                30 -> intent.putExtra("testNameData", "deca")
                31 -> intent.putExtra("testNameData", "edon")
                32 -> intent.putExtra("testNameData", "esab")
                33 -> intent.putExtra("testNameData", "ewm")
                34 -> intent.putExtra("testNameData", "foxweld")
                35 -> intent.putExtra("testNameData", "fronius")
                36 -> intent.putExtra("testNameData", "fubag")
                37 -> intent.putExtra("testNameData", "gys")
                38 -> intent.putExtra("testNameData", "hitachi")
                39 -> intent.putExtra("testNameData", "hyperterm")
                40 -> intent.putExtra("testNameData", "ine")
                41 -> intent.putExtra("testNameData", "kemppi")
                42 -> intent.putExtra("testNameData", "kende")
                43 -> intent.putExtra("testNameData", "lincoln")
                44 -> intent.putExtra("testNameData", "migatronic")
                45 -> intent.putExtra("testNameData", "murex")
                46 -> intent.putExtra("testNameData", "nebula")
                47 -> intent.putExtra("testNameData", "profhelper")
                48 -> intent.putExtra("testNameData", "quattro")
                49 -> intent.putExtra("testNameData", "redbo")
                50 -> intent.putExtra("testNameData", "russia")
                51 -> intent.putExtra("testNameData", "selma")
                52 -> intent.putExtra("testNameData", "sip")
                53 -> intent.putExtra("testNameData", "start")
                54 -> intent.putExtra("testNameData", "sturm")
                55 -> intent.putExtra("testNameData", "telwin")
                56 -> intent.putExtra("testNameData", "thermal")
                57 -> intent.putExtra("testNameData", "torros")
                58 -> intent.putExtra("testNameData", "wester")
            }
            v.context.startActivity(intent)
        }

        init {
            imageView = itemView.findViewById(R.id.piccatalog)
            textView1 = itemView.findViewById(R.id.namecatalog)
            textView2 = itemView.findViewById(R.id.countcatalog)
            imageView.setOnClickListener(this)
            textView1.setOnClickListener(this)
            textView2.setOnClickListener(this)
        }
    }


}