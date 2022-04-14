package com.chartapp.welding;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chartapp.R;
import com.chartapp.laptop.acer.Acer_laptop_catalog;
import com.chartapp.laptop.apple.Apple_laptop_catalog;
import com.chartapp.laptop.aristo.Aristo_laptop_catalog;
import com.chartapp.laptop.asus.Asus_laptop_catalog;
import com.chartapp.laptop.benq.Benq_laptop_catalog;
import com.chartapp.laptop.clevo.Clevo_laptop_catalog;
import com.chartapp.laptop.compal.Compal_laptop_catalog;
import com.chartapp.laptop.compaq.Compaq_laptop_catalog;
import com.chartapp.laptop.dell.Dell_laptop_catalog;
import com.chartapp.laptop.dns.Dns_laptop_catalog;
import com.chartapp.laptop.fujitsu.Fujitsu_laptop_catalog;
import com.chartapp.laptop.gateway.Gateway_laptop_catalog;
import com.chartapp.laptop.gericom.Gericom_laptop_catalog;
import com.chartapp.laptop.hp.Hp_laptop_catalog;
import com.chartapp.laptop.lenovo.Lenovo_laptop_catalog;
import com.chartapp.laptop.lg.Lg_laptop_catalog;
import com.chartapp.laptop.packardbell.Packard_catalog_laptop;
import com.chartapp.laptop.roverbook.Roverbook_laptop_catalog;
import com.chartapp.laptop.samsung.Samsung_laptop_catalog;
import com.chartapp.laptop.sony.Sony_laptop_catalog;
import com.chartapp.welding.aotai.AotaiActivity;
import com.chartapp.welding.aurora.AuroraActivity;
import com.chartapp.welding.bestweld.BestweldActivity;
import com.chartapp.welding.blueweld.BlueweldActivity;
import com.chartapp.welding.brima.BrimaActivity;
import com.chartapp.welding.cebora.CeboraActivity;
import com.chartapp.welding.cemont.CemontActivity;
import com.chartapp.welding.china.ChinaActivity;
import com.chartapp.welding.ciklon.CiklonActivity;
import com.chartapp.welding.deca.DecaActivity;
import com.chartapp.welding.edon.EdonActivity;
import com.chartapp.welding.esab.EsabActivity;
import com.chartapp.welding.ewm.EwmActivity;
import com.chartapp.welding.feb.FebActivity;
import com.chartapp.welding.forsazh.ForsazhActivity;
import com.chartapp.welding.foxweld.FoxweldActivity;
import com.chartapp.welding.fronius.FroniusActivity;
import com.chartapp.welding.fubag.FubagActivity;
import com.chartapp.welding.gladiator.GladiatorActivity;
import com.chartapp.welding.gys.GysActivity;
import com.chartapp.welding.hitachi.HitachiActivity;
import com.chartapp.welding.hyperterm.HypertermActivity;
import com.chartapp.welding.ine.IneActivity;
import com.chartapp.welding.kalibr.KalibrActivity;
import com.chartapp.welding.kedr.KedrActivity;
import com.chartapp.welding.kemppi.KemppiActivity;
import com.chartapp.welding.kende.KendeActivity;
import com.chartapp.welding.kontur.KonturActivity;
import com.chartapp.welding.lincoln.LincolnActivity;
import com.chartapp.welding.linkor.LinkorActivity;
import com.chartapp.welding.mangust.MangustActivity;
import com.chartapp.welding.migatronic.MigatronicActivity;
import com.chartapp.welding.murex.MurexActivity;
import com.chartapp.welding.nebula.NebulaActivity;
import com.chartapp.welding.neon.NeonActivity;
import com.chartapp.welding.pdg.PdgActivity;
import com.chartapp.welding.piton.PitonActivity;
import com.chartapp.welding.profhelpet.ProfhelperActivity;
import com.chartapp.welding.ptk.PtkActivity;
import com.chartapp.welding.pulsar.PulsarActivity;
import com.chartapp.welding.quattro.QuattroActivity;
import com.chartapp.welding.redbo.RedboActivity;
import com.chartapp.welding.resanta.ResantaActivity;
import com.chartapp.welding.rikon.RikonActivity;
import com.chartapp.welding.russia.RussiaActivity;
import com.chartapp.welding.selma.SelmaActivity;
import com.chartapp.welding.sip.SipActivity;
import com.chartapp.welding.solaris.SolarisActivity;
import com.chartapp.welding.sputnik.SputnikActivity;
import com.chartapp.welding.start.StartActivity;
import com.chartapp.welding.sturm.SturmActivity;
import com.chartapp.welding.svarog.SvarogActivity;
import com.chartapp.welding.technotron.TechnotronActivity;
import com.chartapp.welding.telwin.TelwinActivity;
import com.chartapp.welding.termit.TermitActivity;
import com.chartapp.welding.thermal.ThermalActivity;
import com.chartapp.welding.torros.TorrosActivity;
import com.chartapp.welding.torus.TorusActivity;
import com.chartapp.welding.wester.WesterActivity;

import java.util.ArrayList;
import java.util.List;


public class WeldingAdapter extends RecyclerView.Adapter<WeldingAdapter.ViewHolder> implements Filterable {
    private List<WeldingData> exampleList;
    private List<WeldingData> exampleListFull;
    Intent intent;








    public WeldingAdapter(List<WeldingData> exampleList) throws ClassNotFoundException {
        this.exampleList = exampleList;
        exampleListFull = new ArrayList<>(exampleList);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.catalog,
                parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        WeldingData currentItem = exampleList.get(position);
        holder.imageView.setImageResource(currentItem.getImageView());
        holder.textView1.setText(currentItem.getName());
        holder.textView2.setText(currentItem.getCount());


    }




    @Override
    public int getItemCount() {
        return exampleList.size();
    }

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<WeldingData> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(exampleListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (WeldingData item : exampleListFull) {
                    if (item.getName().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            exampleList.clear();
            exampleList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };


    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {
        ImageView imageView;
        TextView textView1;
        TextView textView2;

        ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.piccatalog);
            textView1 = itemView.findViewById(R.id.namecatalog);
            textView2 = itemView.findViewById(R.id.countcatalog);
            imageView.setOnClickListener(this);
            textView1.setOnClickListener(this);
            textView2.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            int pos = getLayoutPosition();
            switch (pos){
                case 0:
                    intent = new Intent(v.getContext(), KedrActivity.class);
                    break;
                case 1:
                    intent = new Intent(v.getContext(), PtkActivity.class);
                    break;
                case 2:
                    intent = new Intent(v.getContext(), SolarisActivity.class);
                    break;
                case 3:
                    intent = new Intent(v.getContext(), GladiatorActivity.class);
                    break;
                case 4:
                    intent = new Intent(v.getContext(), KalibrActivity.class);
                    break;
                case 5:
                    intent = new Intent(v.getContext(), KonturActivity.class);
                    break;
                case 6:
                    intent = new Intent(v.getContext(), LinkorActivity.class);
                    break;
                case 7:
                    intent = new Intent(v.getContext(), MangustActivity.class);
                    break;
                case 8:
                    intent = new Intent(v.getContext(), NeonActivity.class);
                    break;
                case 9:
                    intent = new Intent(v.getContext(), PdgActivity.class);
                    break;
                case 10:
                    intent = new Intent(v.getContext(), PitonActivity.class);
                    break;
                case 11:
                    intent = new Intent(v.getContext(), PulsarActivity.class);
                    break;
                case 12:
                    intent = new Intent(v.getContext(), ResantaActivity.class);
                    break;
                case 13:
                    intent = new Intent(v.getContext(), RikonActivity.class);
                    break;
                case 14:
                    intent = new Intent(v.getContext(), SvarogActivity.class);
                    break;
                case 15:
                    intent = new Intent(v.getContext(), SputnikActivity.class);
                    break;
                case 16:
                    intent = new Intent(v.getContext(), TermitActivity.class);
                    break;
                case 17:
                    intent = new Intent(v.getContext(), TechnotronActivity.class);
                    break;
                case 18:
                    intent = new Intent(v.getContext(), TorusActivity.class);
                    break;
                case 19:
                    intent = new Intent(v.getContext(), FebActivity.class);
                    break;
                case 20:
                    intent = new Intent(v.getContext(), ForsazhActivity.class);
                    break;
                case 21:
                    intent = new Intent(v.getContext(), CiklonActivity.class);
                    break;
                case 22:
                    intent = new Intent(v.getContext(), AotaiActivity.class);
                    break;
                case 23:
                    intent = new Intent(v.getContext(), AuroraActivity.class);
                    break;
                case 24:
                    intent = new Intent(v.getContext(), BlueweldActivity.class);
                    break;
                case 25:
                    intent = new Intent(v.getContext(), BestweldActivity.class);
                    break;
                case 26:
                    intent = new Intent(v.getContext(), BrimaActivity.class);
                    break;
                case 27:
                    intent = new Intent(v.getContext(), CeboraActivity.class);
                    break;
                case 29:
                    intent = new Intent(v.getContext(), CemontActivity.class);
                    break;
                case 30:
                    intent = new Intent(v.getContext(), ChinaActivity.class);
                    break;
                case 31:
                    intent = new Intent(v.getContext(), DecaActivity.class);
                    break;
                case 32:
                    intent = new Intent(v.getContext(), EdonActivity.class);
                    break;
                case 33:
                    intent = new Intent(v.getContext(), EsabActivity.class);
                    break;
                case 34:
                    intent = new Intent(v.getContext(), EwmActivity.class);
                    break;
                case 35:
                    intent = new Intent(v.getContext(), FoxweldActivity.class);
                    break;
                case 36:
                    intent = new Intent(v.getContext(), FroniusActivity.class);
                    break;
                case 37:
                    intent = new Intent(v.getContext(), FubagActivity.class);
                    break;
                case 38:
                    intent = new Intent(v.getContext(), GysActivity.class);
                    break;
                case 39:
                    intent = new Intent(v.getContext(), HitachiActivity.class);
                    break;
                case 40:
                    intent = new Intent(v.getContext(), HypertermActivity.class);
                    break;
                case 41:
                    intent = new Intent(v.getContext(), IneActivity.class);
                    break;
                case 42:
                    intent = new Intent(v.getContext(), KemppiActivity.class);
                    break;
                case 43:
                    intent = new Intent(v.getContext(), KendeActivity.class);
                    break;
                case 44:
                    intent = new Intent(v.getContext(), LincolnActivity.class);
                    break;
                case 45:
                    intent = new Intent(v.getContext(), MigatronicActivity.class);
                    break;
                case 46:
                    intent = new Intent(v.getContext(), MurexActivity.class);
                    break;
                case 47:
                    intent = new Intent(v.getContext(), NebulaActivity.class);
                    break;
                case 48:
                    intent = new Intent(v.getContext(), ProfhelperActivity.class);
                    break;
                case 49:
                    intent = new Intent(v.getContext(), QuattroActivity.class);
                    break;
                case 50:
                    intent = new Intent(v.getContext(), RedboActivity.class);
                    break;
                case 51:
                    intent = new Intent(v.getContext(), RussiaActivity.class);
                    break;
                case 52:
                    intent = new Intent(v.getContext(), SelmaActivity.class);
                    break;
                case 53:
                    intent = new Intent(v.getContext(), SipActivity.class);
                    break;
                case 54:
                    intent = new Intent(v.getContext(), StartActivity.class);
                    break;
                case 55:
                    intent = new Intent(v.getContext(), SturmActivity.class);
                    break;
                case 56:
                    intent = new Intent(v.getContext(), TelwinActivity.class);
                    break;
                case 57:
                    intent = new Intent(v.getContext(), ThermalActivity.class);
                    break;
                case 58:
                    intent = new Intent(v.getContext(), TorrosActivity.class);
                    break;
                case 59:
                    intent = new Intent(v.getContext(), WesterActivity.class);
                    break;

            }
            v.getContext().startActivity(intent);
        }
    }

}