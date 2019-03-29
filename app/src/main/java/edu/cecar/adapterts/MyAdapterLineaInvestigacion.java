package edu.cecar.adapterts;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import edu.cecar.controladores.LineaInvestigacion;
import edu.cecar.controladores.R;

public class MyAdapterLineaInvestigacion extends RecyclerView.Adapter<MyAdapterLineaInvestigacion.ViewHolder>{
    private List<LineaInvestigacion> lineaInvestigacions;
    private int layout;

    public MyAdapterLineaInvestigacion(List<LineaInvestigacion> lineaInvestigacions, int layout) {
        this.lineaInvestigacions = lineaInvestigacions;
        this.layout = layout;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(layout, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bind(lineaInvestigacions.get(i));
    }

    @Override
    public int getItemCount() {
        return lineaInvestigacions.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewName;
        private TextView textViewActivo;

        public ViewHolder(View itemView){
            super(itemView);
            this.textViewName = (TextView) itemView.findViewById(R.id.tvLineaInvestigacion);
            this.textViewActivo = (TextView) itemView.findViewById(R.id.tvActivo);
        }

        public void bind(final LineaInvestigacion lineaInvestigacion) {
            this.textViewName.setText(lineaInvestigacion.getNombre());
            this.textViewActivo.setText(lineaInvestigacion.isActiva()?"Activo":"No Activo");
        }
    }


}

