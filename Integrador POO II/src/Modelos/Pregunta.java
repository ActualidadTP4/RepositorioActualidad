/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author Fer
 */
public class Pregunta {
    private String titulo;
    private String cuerpo;
    private List etiquetas;
    private List respuestas;
    private Usuario autor;
    private String fechaHora;
    private int idPregunta;
    
    
    public Pregunta(){
        this.etiquetas= new ArrayList();
        this.respuestas= new ArrayList();
    }

    public Pregunta(String titulo, String cuerpo, List etiquetas, Usuario autor) {
        this();
        this.titulo = titulo;
        this.cuerpo = cuerpo;
        this.etiquetas = etiquetas;
        this.autor= (Usuario) autor;
        
        Calendar fecha= new GregorianCalendar();
        int year=fecha.get(Calendar.YEAR);
        int mes=fecha.get(Calendar.MONTH);
        int day=fecha.get(Calendar.DAY_OF_MONTH);
        int hora=fecha.get(Calendar.HOUR_OF_DAY);
        int min=fecha.get(Calendar.MINUTE);
        String minuto=""+min;
        if(min<10){
            minuto="0"+min;
        }
        this.fechaHora=day+"/"+mes+"/"+year+" - "+hora+":"+minuto;
        this.autor.agregarPregunta(this);
        //Servidor.getPersistencia().insert(this);
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public List getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(List etiquetas) {
        this.etiquetas = etiquetas;
    }

    public List getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List respuestas) {
        this.respuestas = respuestas;
    }

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public String getFecha() {
        return fechaHora;
    }

    public void setFecha(String fecha) {
        this.fechaHora = fecha;
    }

    public void responderPregunta(String cuerpo, Usuario user){
        this.respuestas.add(new Respuesta(cuerpo, user, this));
    }
    @Override
    public String toString() {
        return titulo;
    }
    
    
    
}
