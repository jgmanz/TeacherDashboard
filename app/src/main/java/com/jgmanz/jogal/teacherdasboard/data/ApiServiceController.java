package com.jgmanz.jogal.teacherdasboard.data;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ApiServiceController {
    private String URL = "http://187.217.205.58:7000";
    private String LOGINMETHOD = "auth/login";

    private String email = "ekoepp@gmail.com";
    private String clave = "12345";


    public interface ApiWebListener
    {
        void onSuccess(String s);
        void onError(VolleyError error);

    }

    private static final ApiServiceController ourInstance = new ApiServiceController();
    public static ApiServiceController getInstance() {
        return ourInstance;
    }

    private ApiServiceController() {

    }

    public void authApi(String user, String psw, Context con, final ApiWebListener listener)
    {
        RequestQueue queue = Volley.newRequestQueue(con);
        ApiService stringRequest = new ApiService(Request.Method.POST, URL+LOGINMETHOD,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        listener.onSuccess(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                String err = error.getMessage();
                listener.onError(error);
            }
        });
        Map<String, String> mParams = new HashMap<String, String>() ;
        mParams.put("email", user);
        mParams.put("password", psw);
        stringRequest.setParams(mParams);
        queue.add(stringRequest);
    }

    public String convertInputStreamToString(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
        String line = "";
        String result = "";
        while((line = bufferedReader.readLine()) != null)
            result += line;

        inputStream.close();
        return result;

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
