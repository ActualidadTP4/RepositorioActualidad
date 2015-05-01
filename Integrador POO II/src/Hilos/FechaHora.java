/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Hilos;

import java.awt.Color;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import javax.swing.JLabel;

/**
 *
 * @author Fer
 */
public class FechaHora extends Thread {
    private boolean seguir=true;
    private String hora, minuto, fecha, mes, anio, dia;
    private JLabel unLabel;

    public FechaHora() {
    }

    public boolean isSeguir() {
        return seguir;
    }

    public void setSeguir(boolean seguir) {
        this.seguir = seguir;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getMinuto() {
        return minuto;
    }

    public void setMinuto(String minuto) {
        this.minuto = minuto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String año) {
        this.anio = año;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }
    

    public JLabel getUnLabel() {
        return unLabel;
    }

    public void setUnLabel(JLabel unLabel) {
        this.unLabel = unLabel;
    }

    
    @Override
    public void run() {
        while(this.seguir){
            Calendar fecha = new GregorianCalendar();
            
        int hour= fecha.get(Calendar.HOUR_OF_DAY);
        int min= fecha.get(Calendar.MINUTE);
        int weekDay=fecha.get(Calendar.DAY_OF_WEEK);
        int dateDay=fecha.get(Calendar.DAY_OF_MONTH);
        int month=fecha.get(Calendar.MONTH);
        int year=fecha.get(Calendar.YEAR);
        
        this.hora= Integer.toString(hour);
        this.minuto= Integer.toString(min);
        
        this.dia=this.diaDeLaSemana(weekDay);
        this.fecha=Integer.toString(dateDay);
        this.mes=Integer.toString(month);
        this.anio=Integer.toString(year);
       
        this.unLabel.setText(hora+":"+minuto+" "+dia+", "+this.fecha+"/"+mes+"/"+anio);
        //this.unLabel.setText("hoa");
        try {
            Thread.sleep(1000);
        }           
        catch (InterruptedException ex) {
        }
      } 
    }
    
    public void finalizar(){
        this.seguir=false;
    }
    
    public String diaDeLaSemana(int numDay){
        String dia=null;
        if(numDay==1){
            dia="Domingo";
        }
        if(numDay==2){
            dia="Lunes";
        }
        if(numDay==3){
            dia="Martes";
        }
        if(numDay==4){
            dia="Miércoles";
        }
        if(numDay==5){
            dia="Jueves";
        }
        if(numDay==6){
            dia="Viernes";
        }
        if(numDay==7){
            dia="Sábado";
        }
        return dia;
    }
}
