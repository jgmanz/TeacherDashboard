package com.jgmanz.jogal.teacherdasboard;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.jgmanz.jogal.teacherdasboard.adapters.grupos_adapter;
import com.jgmanz.jogal.teacherdasboard.data.DataController;

public class a_grupos extends AppCompatActivity {

    RecyclerView recycler_grupos;
    FloatingActionButton fab;
    private LinearLayoutManager mLayoutManager;
    private grupos_adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_grupos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        fab = findViewById(R.id.fab);
        recycler_grupos = findViewById(R.id.recycler_grupos);
        recycler_grupos.setHasFixedSize(false);
        mLayoutManager = new LinearLayoutManager(this);
        recycler_grupos.setLayoutManager(mLayoutManager);
        mAdapter = new grupos_adapter(getApplicationContext(), DataController.getInstance().getLsGrupo());
        recycler_grupos.setAdapter(mAdapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int_nuevo = new Intent(getApplicationContext(), a_grupo_form.class);
                startActivity(int_nuevo);
            }
        });



    }

}
