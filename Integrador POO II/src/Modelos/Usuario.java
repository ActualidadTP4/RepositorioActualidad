/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

/**
 *
 * @author Fer
 */
public class Usuario {
   private String nombre;
   private String correo;
   private String contraseña;
   private Calendar fechaHora;
   private Collection respuestas;
   private Collection preguntas;

    public Usuario() {
        this.respuestas=new ArrayList();
        this.preguntas=new ArrayList();
    }

    public Usuario(String nombre, String correo, String contraseña) {
        this();
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
        Servidor.getPersistencia().insert(this);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Collection getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(Collection respuestas) {
        this.respuestas = respuestas;
    }

    public Collection getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(Collection preguntas) {
        this.preguntas = preguntas;
    }

    public Calendar getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Calendar fechaHora) {
        this.fechaHora = fechaHora;
    }
    
    public void agregarRespuesta(Respuesta unaRespuesta){
        this.respuestas.add(unaRespuesta);
    }
    
    public void agregarPregunta(Pregunta unaPregunta){
        this.preguntas.add(unaPregunta);
        
    }

    @Override
    public String toString() {
        return nombre;
    }
 
    
   
}
