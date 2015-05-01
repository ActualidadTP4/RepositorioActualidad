/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelos;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Fer
 */
public class Respuesta {
   private String texto;
   private Usuario autor;
   private Pregunta pregunta;
   private String fechaHora;

    public Respuesta() {
    }

    public Respuesta(String texto, Usuario autor, Pregunta pregunta) {
        this.texto = texto;
        this.autor = (Usuario) autor;
        this.pregunta = (Pregunta) pregunta;
        this.autor.agregarRespuesta(this);
        
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
        this.fechaHora=day+"/"+mes+"/"+year+" - "+hora+":"+min;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    public String getFecha() {
        return fechaHora;
    }

    public void setFecha(String fecha) {
        this.fechaHora = fecha;
    }


    @Override
    public String toString() {
        return texto;
    }
   
   
}
