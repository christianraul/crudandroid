package com.example.ejemplobd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et_codigo, et_curso, et_turno;
    Button btn_guardar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_codigo=(EditText)findViewById(R.id.txt_codigo);
        et_curso=(EditText)findViewById(R.id.txt_curso);
        et_turno=(EditText)findViewById(R.id.txt_turno);
        btn_guardar=(Button)findViewById(R.id.btnsaveregistro);

        final BDCurso curso=new BDCurso(getApplicationContext());
        btn_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curso.agregar(et_codigo.getText().toString(),et_curso.getText().toString(),et_turno.getText().toString());
                Toast.makeText(getApplicationContext(), "SE AGREGO CORRECTAMENTE", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
