package com.chacachx.listaspersonalizadasrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.chacachx.listaspersonalizadasrecyclerview.adapter.adaptador;
import com.chacachx.listaspersonalizadasrecyclerview.dto.listaUsuarios;
import com.chacachx.listaspersonalizadasrecyclerview.query.query;

import java.util.ArrayList;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {
    RecyclerView listaPersonalizada;
    ArrayList<listaUsuarios> listaDeUsuarios = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaPersonalizada = findViewById(R.id.listaPersonalizada);
        //PARA LA "ORIENTACION" DEL LISTADI
        listaPersonalizada.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        query consulta = new query();
        listaDeUsuarios = consulta.ListadoUsuarios(getApplicationContext());

        adaptador adaptadorLista = new adaptador(listaDeUsuarios, getApplicationContext(), new adaptador.OnItemClickListener() {
            @Override
            public void onItemClick(int i) {
                Toast.makeText(getApplicationContext(), "Se seleccionó: " + listaDeUsuarios.get(i).getCuenta(), Toast.LENGTH_LONG).show();
            }
        });
        listaPersonalizada.setAdapter(adaptadorLista);
    }
}
