package com.jgmanz.jogal.teacherdasboard;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.jgmanz.jogal.teacherdasboard.data.ApiServiceController;
import com.jgmanz.jogal.teacherdasboard.data.DataController;

import org.json.JSONObject;

import java.io.ByteArrayInputStream;
import java.io.IOException;


public class inicioapp extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicioapp);
        ApiServiceController.getInstance().authApi("mail@gmail.com", "12345", getApplicationContext(),
                new ApiServiceController.ApiWebListener() {
            @Override
            public void onSuccess(String s) {
                Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
                String resultad = s;
            }

            @Override
            public void onError(VolleyError error) {
                try {
                    //Obtener el mensaje de error del servidor
                    //convertir el byte[] a un String
                    String res  = ApiServiceController.getInstance().convertInputStreamToString(new ByteArrayInputStream(error.networkResponse.data));
                    Toast.makeText(getApplicationContext(), res, Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        DataloadAsync dataloadAsync = new DataloadAsync();
        dataloadAsync.execute();
    }

    /*
    1.Params, the type of the parameters sent to the task upon execution.
    2.Progress, the type of the progress units published during the background computation.
    3.Result, the type of the result of the background computation.
     */
    private class DataloadAsync extends AsyncTask<Void, Void, Void>
    {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected Void doInBackground(Void... voids) {

            DataController.getInstance().loadAuthApi();

            DataController.getInstance().loadLocalData(getApplicationContext());

            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);

        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Intent intent_login = new Intent(getApplicationContext(), a_dashboard.class);
            startActivity(intent_login);
            finish();
        }
    }
}
