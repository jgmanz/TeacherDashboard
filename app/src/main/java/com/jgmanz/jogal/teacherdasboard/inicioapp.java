package com.jgmanz.jogal.teacherdasboard;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jgmanz.jogal.teacherdasboard.data.DataController;


public class inicioapp extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicioapp);


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
            DataController.getInstance().loadLocalData(getApplicationContext());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);

        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Intent intent_login = new Intent(getApplicationContext(), a_login.class);
            startActivity(intent_login);
            finish();
        }
    }
}
