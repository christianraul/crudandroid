package com.example.ejemplobd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BDCurso extends SQLiteOpenHelper {
    private static final String NOMBRE_BD="curso.bd";
    private static final int VERSION_BD=1;
    private static final String TABLA_CURSO="CREATE TABLE CURSO(CODIGO INT PRIMARY KEY, NOMBRE TEXT,TURNO TEXT)";

    public BDCurso(Context context) {
        super(context, NOMBRE_BD, null, VERSION_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABLA_CURSO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLA_CURSO);
        sqLiteDatabase.execSQL(TABLA_CURSO);
    }
    public void agregar(String codigo, String curso, String turno){
        SQLiteDatabase bd = getWritableDatabase();
        if(bd!=null){
            bd.execSQL("INSERT INTO CURSO VALUES('"+codigo+"','"+curso+"','"+turno+")");
            bd.close();
        }
    }
}
