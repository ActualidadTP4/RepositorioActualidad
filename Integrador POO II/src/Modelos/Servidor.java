/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelos;

import Excepciones.UsuarioException;
import Mapeos.Persistencia;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Fer
 */
public class Servidor {
    private List preguntas;
    private Map usuarios;
    private Map etiquetas;
    private int nro;
    private static Persistencia persistencia=new Persistencia();

    public Servidor() {
        this.preguntas= new ArrayList();
        this.usuarios= new HashMap();
        this.etiquetas= new HashMap();
    }

    public Servidor(int num) {
        this();
        this.nro=num;
        this.persistencia.insert(this);
    }

    public int getNro() {
        return nro;
    }

    public void setNro(int nro) {
        this.nro = nro;
    }

    public static Persistencia getPersistencia() {
        return persistencia;
    }

    public static void setPersistencia(Persistencia persistencia) {
        Servidor.persistencia = persistencia;
    }

    public List getPreguntas() {
        return preguntas;
    }

    public Map getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(Map etiquetas) {
        this.etiquetas = etiquetas;
    }

    public void setPreguntas(List preguntas) {
        this.preguntas = preguntas;
    }

    public Map getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Map usuarios) {
        this.usuarios = usuarios;
    }
    
    public void crearUsuarioSimple(String nombreUsuario, String contraseña, String correo)throws UsuarioException{
        if(!existeUsuario(nombreUsuario)){
            this.usuarios.put(nombreUsuario, new UsuarioSimple(nombreUsuario,correo, contraseña));
            this.persistencia.update(this)
            ;}
        else{
            throw new UsuarioException("Ya existe ese nombre de usuario en el sistema, escoja otro!");
        }
        
    }
    
    public void crearUsuarioModerador(String nombreUsuario, String contraseña, String correo)throws UsuarioException{
        if(!existeUsuario(nombreUsuario)){
            this.usuarios.put(nombreUsuario, new UsuarioModerador(nombreUsuario,correo, contraseña));
            this.persistencia.update(this);
        }else{
                    throw new UsuarioException("Ya existe ese nombre de usuario en el sistema, escoja otro!");
            }
    }
    
    public void publicarPregunta(String titulo, String cuerpo, List etiquetas, Usuario user){
        this.preguntas.add(new Pregunta(titulo, cuerpo, etiquetas, user));
        //this.persistencia.update(this);
    }
    
    public void responderPregunta(String cuerpo, Pregunta unaPregunta, Usuario user){
        unaPregunta.responderPregunta(cuerpo, user);
    }
    
    public void crearEtiqueta(String nombreEtiqueta){
        this.etiquetas.put(nombreEtiqueta, new Etiqueta(nombreEtiqueta));
    }
    
    public boolean existeEtiqueta(String nombre){
         boolean retorno=false;
         if(this.etiquetas.containsKey(nombre)){
            retorno=true; 
        }
        return retorno;
    }
    
    public boolean existeUsuario(String nombre){
        boolean retorno=false;
        if(this.usuarios.containsKey(nombre)){
            retorno=true; 
        }
        return retorno;
    }
    
    public Usuario buscarUsuario(String nombre){
        Usuario user=null;
        user = (Usuario) this.usuarios.get(nombre); 
        return user;
    }
    /**
     * Inicia sesion a un usuario
     * @param nombre nombre del usuario a iniciar sesion
     * @param contraseña contraseña del usuario a iniciar sesion
     * @throws java.lang.Exception Si el user o password es invalido
     * @return El usuario que inició sesión
     */
    public Usuario iniciarSesion(String nombre, String contraseña)throws UsuarioException{
        Usuario user=null; 
        user =(Usuario) buscarUsuario(nombre);
            
        if((user!=null) && (user.getContraseña().equals(contraseña))){
            return user;
        }else {
            throw new UsuarioException("Usuario o contraseña incorrectos");
           
        }
    }
    

    
}
