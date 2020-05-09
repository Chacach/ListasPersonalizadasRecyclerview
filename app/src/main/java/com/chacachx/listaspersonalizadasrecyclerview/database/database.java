package com.chacachx.listaspersonalizadasrecyclerview.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class database extends SQLiteOpenHelper {
    public database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE LISTADO(USUARIO TEXT, NOMBRE TEXT, APELLIDO TEXT, CUENTA TEXT, IMAGEN TEXT)");
        db.execSQL("INSERT INTO LISTADO (USUARIO, NOMBRE, APELLIDO, CUENTA, IMAGEN) VALUES ('CHACACH', 'ALEXANDER', 'CHACACH', 'https://github.com/', 'https://www.siliconweek.com/wp-content/uploads/2018/06/GitHub.png')");
        db.execSQL("INSERT INTO LISTADO (USUARIO, NOMBRE, APELLIDO, CUENTA, IMAGEN) VALUES ('CHACACH', 'ALEXANDER', 'CHACACH', 'https://gitlab.com/', 'https://upload.wikimedia.org/wikipedia/commons/thumb/1/18/GitLab_Logo.svg/1200px-GitLab_Logo.svg.png')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
