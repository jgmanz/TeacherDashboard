package com.jgmanz.jogal.teacherdasboard.adapters;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jgmanz.jogal.teacherdasboard.R;
import com.jgmanz.jogal.teacherdasboard.models.Grupo;

import junit.framework.TestCase;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class grupos_adapter extends RecyclerView.Adapter<grupos_adapter.ViewHolder>{


    //Mas información en
    //https://developer.android.com/guide/topics/ui/layout/recyclerview#java
    private ArrayList<Grupo> lsGrupos = new ArrayList<Grupo>();
    private Context con;
    public grupos_adapter(Context con, ArrayList<Grupo> lsGrupos)
    {
        this.lsGrupos = lsGrupos;
        this.con = con;
    }

    @Override
    public grupos_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Llena la vista
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.grupo_row, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull grupos_adapter.ViewHolder holder, int position) {

        Grupo g = lsGrupos.get(position);
        if(g.getEdificio().getLetra() == 'A')
        {
            holder.grupo_row_img.setVisibility(View.GONE);
        }
        holder.grupo_row_nombre.setText(g.getNombregrupo());
        holder.grupo_row_edificio.setText(g.getEdificio().getNombre());
    }

    @Override
    public int getItemCount() {
        if(lsGrupos == null)
        {
            return 0;
        }else {
            return lsGrupos.size();
        }
    }
    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView grupo_row_img;
        TextView grupo_row_edificio;
        TextView grupo_row_nombre;
        public ViewHolder(View itemView) {
            super(itemView);
            grupo_row_edificio = itemView.findViewById(R.id.grupo_row_edificio);
            grupo_row_nombre = itemView.findViewById(R.id.grupo_row_nombre);
            grupo_row_img = itemView.findViewById(R.id.grupo_row_img);

        }
    }
}
