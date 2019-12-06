/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Alex
 */
public class Asistencia {
    private String actividad;
    private LocalDate date;
    private LocalTime ingreso;
    private LocalTime salida;
    private String estado;// normal  |  atrazo entrada   |   salida anticipada  |   Falta
    private int estadoNum;//  0      |      1            |          2           |      3
    private int mes;//
    private long minutosAtrazo;
    private long minutosSalida;

    public Asistencia(String actividad, LocalDate date, LocalTime ingreso, LocalTime salida, String estado, int estadoNum, int mes, long minutosAtrazo, long minutosSalida) {
        this.actividad = actividad;
        this.date = date;
        this.ingreso = ingreso;
        this.salida = salida;
        this.estado = estado;
        this.estadoNum = estadoNum;
        this.mes = mes;
        this.minutosAtrazo = minutosAtrazo;
        this.minutosSalida = minutosSalida;
    }
    
    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getIngreso() {
        return ingreso;
    }

    public void setIngreso(LocalTime ingreso) {
        this.ingreso = ingreso;
    }

    public LocalTime getSalida() {
        return salida;
    }

    public void setSalida(LocalTime salida) {
        this.salida = salida;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getEstadoNum() {
        return estadoNum;
    }

    public void setEstadoNum(int estadoNum) {
        this.estadoNum = estadoNum;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public long getMinutosAtrazo() {
        return minutosAtrazo;
    }

    public void setMinutosAtrazo(long minutosAtrazo) {
        this.minutosAtrazo = minutosAtrazo;
    }

    public long getMinutosSalida() {
        return minutosSalida;
    }

    public void setMinutosSalida(long minutosSalida) {
        this.minutosSalida = minutosSalida;
    }
    
    
    
}
