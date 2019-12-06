/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.sql.Time;

/**
 *
 * @author Alex
 */
public class HorarioVisual {

    private Integer id;
    private Time hora;
    private Periodo periodo;
    private Usuarios usuarios;

    private TipoCh actividad1;
    private CursoAula curso1;
    private Integer id1;

    private TipoCh actividad2;
    private CursoAula curso2;
    private Integer id2;

    private TipoCh actividad3;
    private CursoAula curso3;
    private Integer id3;

    private TipoCh actividad4;
    private CursoAula curso4;
    private Integer id4;

    private TipoCh actividad5;
    private CursoAula curso5;
    private Integer id5;

    private TipoCh actividad6;
    private CursoAula curso6;
    private Integer id6;

    public HorarioVisual() {
    }

    public HorarioVisual(Integer id, Time hora, Periodo periodo, Usuarios usuarios, TipoCh actividad1, CursoAula curso1, Integer id1, TipoCh actividad2, CursoAula curso2, Integer id2, TipoCh actividad3, CursoAula curso3, Integer id3, TipoCh actividad4, CursoAula curso4, Integer id4, TipoCh actividad5, CursoAula curso5, Integer id5, TipoCh actividad6, CursoAula curso6, Integer id6) {
        this.id = id;
        this.hora = hora;
        this.periodo = periodo;
        this.usuarios = usuarios;
        this.actividad1 = actividad1;
        this.curso1 = curso1;
        this.id1 = id1;
        this.actividad2 = actividad2;
        this.curso2 = curso2;
        this.id2 = id2;
        this.actividad3 = actividad3;
        this.curso3 = curso3;
        this.id3 = id3;
        this.actividad4 = actividad4;
        this.curso4 = curso4;
        this.id4 = id4;
        this.actividad5 = actividad5;
        this.curso5 = curso5;
        this.id5 = id5;
        this.actividad6 = actividad6;
        this.curso6 = curso6;
        this.id6 = id6;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    public TipoCh getActividad1() {
        return actividad1;
    }

    public void setActividad1(TipoCh actividad1) {
        this.actividad1 = actividad1;
    }

    public CursoAula getCurso1() {
        return curso1;
    }

    public void setCurso1(CursoAula curso1) {
        this.curso1 = curso1;
    }

    public Integer getId1() {
        return id1;
    }

    public void setId1(Integer id1) {
        this.id1 = id1;
    }

    public TipoCh getActividad2() {
        return actividad2;
    }

    public void setActividad2(TipoCh actividad2) {
        this.actividad2 = actividad2;
    }

    public CursoAula getCurso2() {
        return curso2;
    }

    public void setCurso2(CursoAula curso2) {
        this.curso2 = curso2;
    }

    public Integer getId2() {
        return id2;
    }

    public void setId2(Integer id2) {
        this.id2 = id2;
    }

    public TipoCh getActividad3() {
        return actividad3;
    }

    public void setActividad3(TipoCh actividad3) {
        this.actividad3 = actividad3;
    }

    public CursoAula getCurso3() {
        return curso3;
    }

    public void setCurso3(CursoAula curso3) {
        this.curso3 = curso3;
    }

    public Integer getId3() {
        return id3;
    }

    public void setId3(Integer id3) {
        this.id3 = id3;
    }

    public TipoCh getActividad4() {
        return actividad4;
    }

    public void setActividad4(TipoCh actividad4) {
        this.actividad4 = actividad4;
    }

    public CursoAula getCurso4() {
        return curso4;
    }

    public void setCurso4(CursoAula curso4) {
        this.curso4 = curso4;
    }

    public Integer getId4() {
        return id4;
    }

    public void setId4(Integer id4) {
        this.id4 = id4;
    }

    public TipoCh getActividad5() {
        return actividad5;
    }

    public void setActividad5(TipoCh actividad5) {
        this.actividad5 = actividad5;
    }

    public CursoAula getCurso5() {
        return curso5;
    }

    public void setCurso5(CursoAula curso5) {
        this.curso5 = curso5;
    }

    public Integer getId5() {
        return id5;
    }

    public void setId5(Integer id5) {
        this.id5 = id5;
    }

    public TipoCh getActividad6() {
        return actividad6;
    }

    public void setActividad6(TipoCh actividad6) {
        this.actividad6 = actividad6;
    }

    public CursoAula getCurso6() {
        return curso6;
    }

    public void setCurso6(CursoAula curso6) {
        this.curso6 = curso6;
    }

    public Integer getId6() {
        return id6;
    }

    public void setId6(Integer id6) {
        this.id6 = id6;
    }

}
