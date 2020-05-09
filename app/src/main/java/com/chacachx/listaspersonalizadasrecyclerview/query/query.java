package com.chacachx.listaspersonalizadasrecyclerview.query;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.chacachx.listaspersonalizadasrecyclerview.database.database;
import com.chacachx.listaspersonalizadasrecyclerview.dto.listaUsuarios;

import java.util.ArrayList;

public class query {

    public ArrayList<listaUsuarios> ListadoUsuarios(Context context) {
        ArrayList<listaUsuarios> listaDeUsuarios;
        String consulta = "SELECT * FROM LISTADO";
        listaDeUsuarios = llenadoGenerico(context, consulta);
        return listaDeUsuarios;

    }

    public ArrayList<listaUsuarios> llenadoGenerico(Context context, String consulta) {
        listaUsuarios itemUsuario;
        ArrayList<listaUsuarios> listaDeUsuarios = new ArrayList<>();
        database baseDeDatos = new database(context, null, null, 1);
        SQLiteDatabase db = baseDeDatos.getReadableDatabase();
        Cursor fila = db.rawQuery(consulta, null);
        while (fila.moveToNext()) {
            itemUsuario = new listaUsuarios(fila.getString(0), fila.getString(1), fila.getString(2), fila.getString(3), fila.getString(4));
            listaDeUsuarios.add(itemUsuario);
        }
        db.close();
        return listaDeUsuarios;
    }
}
