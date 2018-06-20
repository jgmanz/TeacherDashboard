package com.jgmanz.jogal.teacherdasboard;

import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.jgmanz.jogal.teacherdasboard.data.DataController;
import com.jgmanz.jogal.teacherdasboard.models.Edificio;
import com.jgmanz.jogal.teacherdasboard.models.Grupo;

public class a_grupo_form extends AppCompatActivity {

    EditText txt_grupo_form_clave;
    EditText txt_grupo_form_grupo;
    Button txt_grupo_form_btn;
    Spinner sp_grupo_form_edificio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_grupo_form);

        txt_grupo_form_clave = findViewById(R.id.txt_grupo_form_clave);
        txt_grupo_form_grupo = findViewById(R.id.txt_grupo_form_grupo);
        txt_grupo_form_btn = findViewById(R.id.txt_grupo_form_btn);
        sp_grupo_form_edificio = findViewById(R.id.sp_grupo_form_edificio);


        txt_grupo_form_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Grupo gruponuevo = new Grupo(txt_grupo_form_grupo.getText().toString(),
                        txt_grupo_form_clave.getText().toString(),
                        ((Edificio)sp_grupo_form_edificio.getSelectedItem()),
                        null
                        );
                DataController.getInstance().addGrupo(gruponuevo, getApplicationContext());
                finish();
            }
        });
    }
}
