package com.jgmanz.jogal.teacherdasboard;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jgmanz.jogal.teacherdasboard.data.DataController;
import com.jgmanz.jogal.teacherdasboard.data.LocalData;
import com.jgmanz.jogal.teacherdasboard.models.Profesor;
import com.jgmanz.jogal.teacherdasboard.models.TipoProfesor;

import java.io.IOException;
import java.util.ArrayList;

public class a_login extends AppCompatActivity {


    EditText txt_login_email;
    EditText txt_login_password;
    Button btn_login_entrar;
    Button btn_login_registro;
    CheckBox chk_login_recordar ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_login);

        txt_login_email = findViewById(R.id.txt_login_email);
        txt_login_password = findViewById(R.id.txt_login_password);
        chk_login_recordar = findViewById(R.id.chk_login_recordar);
        btn_login_entrar = findViewById(R.id.btn_login_entrar);
        btn_login_registro = findViewById(R.id.btn_login_registro);

        if(DataController.getInstance().getUsuarioemail() != null)
        {
            txt_login_email.setText(DataController.getInstance().getUsuarioemail());
            txt_login_password.setText(DataController.getInstance().getUsuariopassword());
        }

        btn_login_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean datoscorrectos = false;

                if(DataController.getInstance().getLsProfesor() != null) {
                    for (Profesor profesor : DataController.getInstance().getLsProfesor()) {
                        if (profesor.getClaveacceso().equals(txt_login_password.getText().toString())
                                && profesor.getEmail().equals(txt_login_email.getText().toString())) {
                            if (chk_login_recordar.isChecked()) {
                                LocalData.savePreferences(getApplicationContext(), "usremail",
                                        txt_login_email.getText().toString());

                                LocalData.savePreferences(getApplicationContext(), "userpass",
                                        txt_login_password.getText().toString());
                            }
                            DataController.getInstance().setUsuario(profesor);
                            datoscorrectos = true;
                            break;
                        }
                    }
                }
                if(!datoscorrectos)
                {
                    Toast.makeText(getApplicationContext(), "Datos incorrectos", Toast.LENGTH_SHORT).show();
                }
            }
        });








        /*ArrayList<Profesor> lsPr = new ArrayList<Profesor>();
        lsPr.add(new Profesor("Jose", "Manzanero", "5555", "4440",
                "jogal.manz@gmaial.com","11", TipoProfesor.PARCIAL));
        lsPr.add(new Profesor("Galdino", "Manzanero", "6666", "4440",
                "jogal.manz@gmaial.com","11", TipoProfesor.PARCIAL));

        lsPr.add(new Profesor("Roman", "Manzanero", "77777", "4440",
                "jogal.manz@gmaial.com","11", TipoProfesor.PARCIAL));

        Gson gs = new Gson();
        String res = gs.toJson(lsPr);
        String s = res + "";


        try {
            localfiledata.saveFile("lsprof.dat",res, this);

            String datos = localfiledata.readFile("lsprof.dat", this);
            Toast.makeText(this, "File data" + datos, Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        localdata.savePreferences(this, "lsprofes", res);

        String lsp = localdata.getPreference(this, "lsprofes");

        TypeToken<ArrayList<Profesor>> token = new TypeToken<ArrayList<Profesor>>() {};
        ArrayList<Profesor> lsArray = gs.fromJson(lsp, token.getType());
        Toast.makeText(this, lsp, Toast.LENGTH_SHORT).show();
       // lsPr = gs.fromJson(lsp, lsPr.getT);

       */
    }
}
