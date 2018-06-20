package com.jgmanz.jogal.teacherdasboard.data;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jgmanz.jogal.teacherdasboard.models.Alumno;
import com.jgmanz.jogal.teacherdasboard.models.Grupo;
import com.jgmanz.jogal.teacherdasboard.models.Horario;
import com.jgmanz.jogal.teacherdasboard.models.Materia;
import com.jgmanz.jogal.teacherdasboard.models.Profesor;

import java.util.ArrayList;

public class DataController {


    private Profesor usuario;
    private String usuarioemail;
    private String usuariopassword;

    private ArrayList<Profesor> lsProfesor = new ArrayList<Profesor>();
    private ArrayList<Alumno> lsAlumno = new ArrayList<Alumno>();
    private ArrayList<Grupo> lsGrupo = new ArrayList<Grupo>();
    private ArrayList<Horario> lsHorario = new ArrayList<Horario>();
    private ArrayList<Materia> lsMateria = new ArrayList<Materia>();

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
        lsAlumno = gs.fromJson(LocalData.getPreference(con, LSALUMNO), tokenAlumno.getType());
        lsGrupo = gs.fromJson(LocalData.getPreference(con, LSGRUPO),tokenGrupo.getType());
        lsProfesor = gs.fromJson(LocalData.getPreference(con, LSPROFESOR), tokenProfesor.getType());
        this.usuarioemail = LocalData.getPreference(con, USEREMAIL);
        this.usuariopassword = LocalData.getPreference(con, USERPASSWORD);
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
}
