package com.jgmanz.jogal.teacherdasboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class a_dashboard extends AppCompatActivity {


    Button btn_dash_materias, btn_dash_grupos,btn_dash_alumnos,btn_dash_asistencia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_dashboard);
        btn_dash_materias = findViewById(R.id.btn_dash_materias);
        btn_dash_grupos = findViewById(R.id.btn_dash_grupos);
        btn_dash_alumnos = findViewById(R.id.btn_dash_alumnos);
        btn_dash_asistencia = findViewById(R.id.btn_dash_asistencia);


        btn_dash_grupos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int_s = new Intent(getApplicationContext(), a_grupos.class);
                startActivity(int_s);
            }
        });
    }
}
