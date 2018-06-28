package com.jgmanz.jogal.teacherdasboard.data;

import android.content.Context;
import android.provider.ContactsContract;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jgmanz.jogal.teacherdasboard.models.Alumno;
import com.jgmanz.jogal.teacherdasboard.models.Edificio;
import com.jgmanz.jogal.teacherdasboard.models.Grupo;
import com.jgmanz.jogal.teacherdasboard.models.Horario;
import com.jgmanz.jogal.teacherdasboard.models.Materia;
import com.jgmanz.jogal.teacherdasboard.models.Profesor;
import com.jgmanz.jogal.teacherdasboard.models.TipoProfesor;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataController {


    private Profesor usuario;
    private String usuarioemail;
    private String usuariopassword;

    private ArrayList<Profesor> lsProfesor = new ArrayList<Profesor>();
    private ArrayList<Alumno> lsAlumno = new ArrayList<Alumno>();
    private ArrayList<Grupo> lsGrupo = new ArrayList<Grupo>();
    private ArrayList<Horario> lsHorario = new ArrayList<Horario>();
    private ArrayList<Materia> lsMateria = new ArrayList<Materia>();
    private ArrayList<Edificio> lsEdificio = new ArrayList<Edificio>();


    private Context con;
    private String USEREMAIL = "useremail";
    private String USERPASSWORD = "userpass";
    private String LSPROFESOR = "lsprofesor";
    private String LSALUMNO = "lsalumno";
    private String LSGRUPO = "lsgrupo";
    private String LSHORARIO = "lshorario";

    private Gson gs = new Gson();

    private static final DataController instance = new DataController();

    public static DataController getInstance() {
        return instance;
    }

    private DataController() {

    }


    public void rememberuser(Context con )
    {
        Gson gs = new Gson();
        this.usuarioemail = usuario.getEmail().toString();
        this.usuariopassword = usuario.getClaveacceso().toString();
        LocalData.savePreferences(con, USEREMAIL, usuario.getEmail().toString());
        LocalData.savePreferences(con, USERPASSWORD, usuario.getClaveacceso().toString());
    }
    public void loadLocalData(Context con)
    {
        TypeToken<ArrayList<Profesor>> tokenProfesor = new TypeToken<ArrayList<Profesor>>() {};
        TypeToken<ArrayList<Alumno>> tokenAlumno = new TypeToken<ArrayList<Alumno>>() {};
        TypeToken<ArrayList<Grupo>> tokenGrupo = new TypeToken<ArrayList<Grupo>>() {};
        Gson gs = new Gson();
        lsAlumno = gs.fromJson(
                LocalData.getPreference(con, LSALUMNO),
                tokenAlumno.getType());
        lsGrupo = gs.fromJson(LocalData.getPreference(con, LSGRUPO),tokenGrupo.getType());
        lsProfesor = gs.fromJson(LocalData.getPreference(con, LSPROFESOR), tokenProfesor.getType());
        this.usuarioemail = LocalData.getPreference(con, USEREMAIL);
        this.usuariopassword = LocalData.getPreference(con, USERPASSWORD);
        //prevenir arrays nulos
        lsGrupo = lsGrupo==null ?  new ArrayList<Grupo>():lsGrupo;
        lsProfesor = lsProfesor == null?new ArrayList<Profesor>(): lsProfesor;
        lsEdificio = lsEdificio == null?new ArrayList<Edificio>(): lsEdificio;
        lsAlumno = lsAlumno == null?new ArrayList<Alumno>(): lsAlumno;


        this.lsProfesor.add(new Profesor("jose", "","","","gmanzanero@utrm.com",
                "", TipoProfesor.PARCIAL,"123"));
        this.lsEdificio.add(new Edificio("Eidificio A", 'a', 0,0));
        this.lsEdificio.add(new Edificio("Eidificio B", 'b', 0,0));
        this.lsEdificio.add(new Edificio("Eidificio C", 'c', 0,0));
        this.lsEdificio.add(new Edificio("Eidificio D", 'd', 0,0));


    }


    public void loadAuthApi()
    {
        String urlString = "http://187.217.205.58:7000/auth/login"; // URL to call

        String email = "ekoepp@gmail.com"; //data to post
        String clave = "12345";

        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost(urlString);
        String result ="";
        try {
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
            nameValuePairs.add(new BasicNameValuePair("email", email));
            nameValuePairs.add(new BasicNameValuePair("password", clave));
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            HttpResponse response = httpclient.execute(httppost);
            String response1 = response.toString();
            InputStream inputStream = response.getEntity().getContent();
            if(inputStream != null)
                result = convertInputStreamToString(inputStream);
            String ver = result;
        } catch (ClientProtocolException e) {
            String err = e.getMessage();
        } catch (IOException e) {
            String err = e.getMessage();
        }

    }
    public String convertInputStreamToString(InputStream inputStream) throws IOException{
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
        String line = "";
        String result = "";
        while((line = bufferedReader.readLine()) != null)
            result += line;

        inputStream.close();
        return result;

    }

    public void addGrupo(Grupo g, Context con)
    {
        this.lsGrupo.add(g);
        LocalData.savePreferences(con,LSGRUPO, gs.toJson(lsGrupo));
    }

    public Profesor getUsuario() {
        return usuario;
    }

    public void setUsuario(Profesor usuario) {
        this.usuario = usuario;
    }

    public String getUsuarioemail() {
        return usuarioemail;
    }

    public void setUsuarioemail(String usuarioemail) {
        this.usuarioemail = usuarioemail;
    }

    public String getUsuariopassword() {
        return usuariopassword;
    }

    public ArrayList<Edificio> getLsEdificio() {
        return lsEdificio;
    }

    public void setLsEdificio(ArrayList<Edificio> lsEdificio) {
        this.lsEdificio = lsEdificio;
    }

    public void setUsuariopassword(String usuariopassword) {
        this.usuariopassword = usuariopassword;
    }

    public ArrayList<Profesor> getLsProfesor() {
        return lsProfesor;
    }

    public void setLsProfesor(ArrayList<Profesor> lsProfesor) {
        this.lsProfesor = lsProfesor;
    }

    public ArrayList<Alumno> getLsAlumno() {
        return lsAlumno;
    }

    public void setLsAlumno(ArrayList<Alumno> lsAlumno) {
        this.lsAlumno = lsAlumno;
    }

    public ArrayList<Grupo> getLsGrupo() {
        return lsGrupo;
    }

    public void setLsGrupo(ArrayList<Grupo> lsGrupo) {
        this.lsGrupo = lsGrupo;
    }

    public ArrayList<Horario> getLsHorario() {
        return lsHorario;
    }

    public void setLsHorario(ArrayList<Horario> lsHorario) {
        this.lsHorario = lsHorario;
    }

    public ArrayList<Materia> getLsMateria() {
        return lsMateria;
    }

    public void setLsMateria(ArrayList<Materia> lsMateria) {
        this.lsMateria = lsMateria;
    }

    public void saveUseremailpassword(String s, String s1, Context con) {
        LocalData.savePreferences(con, USEREMAIL,s);
        LocalData.savePreferences(con, USERPASSWORD,s1);
    }
}
