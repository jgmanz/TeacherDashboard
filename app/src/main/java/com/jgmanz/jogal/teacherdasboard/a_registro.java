package com.jgmanz.jogal.teacherdasboard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class a_registro extends AppCompatActivity {

    EditText txt_registro_id_profesor,txt_registro_nombre,txt_registro_email,txt_registro_telefono, txt_registro_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_registro);


    }
}
