package com.jgmanz.jogal.teacherdasboard.data;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.Map;

public class ApiService extends StringRequest {


    Response.Listener<String> listener;
    Response.ErrorListener errorListener;
    Map<String, String> params;
    Map<String, String> headers;

    public ApiService(int method, String url, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(method, url, listener, errorListener);
    }
    @Override
    public int getMethod() {
        return super.getMethod();
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        if(headers != null)
        {
            return headers;
        }else {
            return super.getHeaders();
        }
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        if(params != null)
        {
            return params;
        }else {
            return super.getParams();
        }
    }

    @Override
    public String getBodyContentType() {
        return super.getBodyContentType();
    }

    @Override
    public byte[] getBody() throws AuthFailureError {
        return super.getBody();
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }
}
