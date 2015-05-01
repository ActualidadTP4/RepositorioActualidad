/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Presentacion;

import Modelos.Servidor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author Fer
 */
public class IntegradorPOOII {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       Servidor unControl =  null;
       unControl=(Servidor) Servidor.getPersistencia().load("Modelos.Servidor", 1);
       if(unControl==null){
            unControl= new Servidor(1);
       }
       
        Properties prop = new Properties();
        InputStream is = null;
 
        try {
            is = new FileInputStream("configuracion.properties");
            prop.load(is);
        } catch(IOException e) {
            System.out.println(e.toString());
        }
        if(prop.getProperty("rol").equals("usuarioRegistrado")){
                   Principal ventana= new Principal(unControl);
                   ventana.setVisible(true); 
        }
        if(prop.getProperty("rol").equals("admin")){
                Administrador ventanaAdmin= new Administrador(unControl);
                ventanaAdmin.setVisible(true);
        }
    }
    
}
