package com.chacachx.listaspersonalizadasrecyclerview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chacachx.listaspersonalizadasrecyclerview.R;
import com.chacachx.listaspersonalizadasrecyclerview.dto.listaUsuarios;

import java.util.ArrayList;

public class adaptador extends RecyclerView.Adapter<adaptador.ViewHolderListaUsuarios> {
    //LISTADO DE USUARIOS
    private ArrayList<listaUsuarios> listaDeUsuario;
    private Context context;
    //ENCARGADO DE ESCUCHAR A QUE ITEM SE LE HACE "CLIC"
    private OnItemClickListener listener;

    public adaptador(ArrayList<listaUsuarios> listaDeUsuario, Context context, OnItemClickListener listener) {
        this.listaDeUsuario = listaDeUsuario;
        this.context = context;
        this.listener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(int i);
    }

    @NonNull
    @Override
    public ViewHolderListaUsuarios onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //ASIGNAMOS LA VISTA QUE TENDRAN LOS ITEMS DEL RECYCLERVIEW
        return new ViewHolderListaUsuarios(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderListaUsuarios viewHolderListaUsuarios, int i) {
        //ENVIAMOS EL REGISTRO EN LA POSICION i (DEL ARRAYLIST) PARA SER AÑADIDO AL RECYCLERVIEW
        viewHolderListaUsuarios.bind(this.listaDeUsuario.get(i), i, this.listener);
    }

    @Override
    public int getItemCount() {
        //RETORNA LA CANTIDAD DE ITEMS
        return listaDeUsuario.size();
    }

    public class ViewHolderListaUsuarios extends RecyclerView.ViewHolder {
        TextView nombre, cuenta;
        ImageView imagen;

        public ViewHolderListaUsuarios(View inflate) {

            super(inflate);
            nombre = inflate.findViewById(R.id.nombre);
            cuenta = inflate.findViewById(R.id.cuenta);
            imagen = inflate.findViewById(R.id.imagen);
        }

        public void bind(listaUsuarios itemListaUsuarios, final int position, final OnItemClickListener listener) {
            //LLENAMOS CADA ITEM DEL RECYCLERVIEW CON EL CONTENIDO DE LA LISTA DE USUARIOS DE LA BASE DE DATOS
            //CONCATENAMOS NOMBRE Y APELLIDO PARA FINES DEMOSTRATIVOS
            nombre.setText(itemListaUsuarios.getNombre() + " " + itemListaUsuarios.getApellido());
            cuenta.setText(itemListaUsuarios.getCuenta() + itemListaUsuarios.getUsuario().toLowerCase());
            //USAMOS GLIDE PARA CARGAR LAS IMAGENES DESDE LA URL
            //https://github.com/bumptech/glide
            //AÑADIR LOS PERMISOS DE INTERNET PARA QUE CARGUEN LAS FOTOS
            Glide.with(context).load(itemListaUsuarios.getImagen()).centerInside()
                    .into(imagen);
            this.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(position);
                }
            });
        }
    }
}

