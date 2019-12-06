/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores.clases;

import entidades.Horario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author a
 */
public class Transformar {
    
    
    public String Transformartipo(int tipo){
    
        String tipoProfesor="xxx";
        
        switch(tipo){
            case 1:
               tipoProfesor= "Tiempo completo";
            break;
            case 2:
                tipoProfesor= "Medio Tiempo";
            break;
        }
        return tipoProfesor;
    }
    public String[][] extraerHorario(List<Horario> horarios){
        String horario[][] = new String[14][13];
        int i=0,j=0;
        for (Horario horario1 : horarios) {
            horario[i][0]=horario1.getHoraHorario();
            horario[i][1]=horario1.getActLunHorario();
            horario[i][2]=horario1.getCurLunHorario();
            horario[i][3]=horario1.getActMarHorario();
            horario[i][4]=horario1.getCurMarHorario();
            horario[i][5]=horario1.getActMieHorario();
            horario[i][6]=horario1.getCurMieHorario();
            horario[i][7]=horario1.getActJueHorario();
            horario[i][8]=horario1.getCurJueHorario();
            horario[i][9]=horario1.getActVieHorario();
            horario[i][10]=horario1.getCurVieHorario();
            horario[i][11]=horario1.getActSabHorario();
            horario[i][12]=horario1.getCurSabHorario();
            
            i=i+1;
        }
        System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk990909"+horarios.size());
        System.out.println("##########################################################");
        for (int k = 0; k < 14; k++) {
            for (int l = 0; l < 13; l++) {
                
                if(horario[k][l]==null || horario[k][l]==""){
                    horario[k][l]="0";
                }
                System.out.print("--->"+horario[k][l]);
            }
            System.out.println("");
        }
//        this.identificarDias(horario, "IMPARTICIÓN DE CLASES");
        System.out.println("##########################################################");
//        System.out.println("LLAMADA A IDENTIFICAR DIAS"+this.identificarDias(horario,"IMPARTICIÓN DE CLASES"));
        return horario;
    }
    
    public List<HorarioPos> identificarDias(String[][] horarios,String tipo_carga){
        int bandera=0;
        HorarioPos pos1=new HorarioPos();
        List<HorarioPos> pos=new ArrayList<>();
       
        for (int j = 1; j < 13; j=j+2) {
            for (int i = 0; i < 14; i++) {
                if(tipo_carga.equals(horarios[i][j])){
                    System.out.println("NUMERO"+i);
                    if (bandera == 0) {
                        pos1 = new HorarioPos();
                        pos1.setHora_ini(horarios[i][0]);
                        pos1.setX(i);
                        pos1.setY(j);   
                        
                        bandera=1;
                        

                    } 
                   
                }
                else {
                    if (bandera == 1) {
                        bandera = 0;
                        pos1.setHora_fin(horarios[i][0]);
                        pos1.setAula(horarios[i][j+1]);
                        switch(j){
                            case 1:
                                pos1.setDia("LUNES");
                            break;
                            case 3:
                                pos1.setDia("MARTES");
                            break;
                            case 5:
                                pos1.setDia("MIERCOLES");
                            break;
                            case 7:
                                pos1.setDia("JUEVES");
                            break;
                            case 9:
                                pos1.setDia("VIERNES");
                            break;
                            case 11:
                                pos1.setDia("SABADO");
                            break;
                           
                        }
                        pos.add(pos1);
                           
                    }     
                    
                 }
            }
        }
        for (HorarioPos po : pos) {
            System.out.println("%"+po.getX()+" "+po.getY()+" "+po.getHora_ini()+" "+po.getHora_fin());
        }
        System.out.println("uuuuuuuuuuuuuuuuuuuuuuuuuuuu"+pos);
        return pos;
    }
    
    public Boolean [] getCamposReporte(int tipo){
        Boolean []vec=new Boolean[17];
        switch (tipo) {
            case 1:
                  vec[0]=false;
                  vec[1]=false;
                  vec[2]=false;
                  vec[3]=false;
                  vec[4]=false;
                  vec[5]=false;
                  vec[6]=false;
                  vec[7]=false;
                  vec[8]=false;
                  vec[9]=false;
                  vec[10]=false;
                  vec[11]=false;
                  vec[12]=false;
                  vec[13]=false;
                  vec[14]=false;
                  vec[15]=false;
                  vec[16]=false;
                break;
            case 2:
                  vec[0]=true;
                  vec[1]=false;
                  vec[2]=false;
                  vec[3]=false;
                  vec[4]=false;
                  vec[5]=false;
                  vec[6]=true;
                  vec[7]=false;
                  vec[8]=false;
                  vec[9]=false;
                  vec[10]=true;
                  vec[11]=true;
                  vec[12]=false;
                  vec[13]=false;
                  vec[14]=true;
                  vec[15]=true;
                  vec[16]=false;
              
                break;
            case 3:
                  vec[0]=true;
                  vec[1]=false;
                  vec[2]=false;
                  vec[3]=false;
                  vec[4]=false;
                  vec[5]=true;
                  vec[6]=true;
                  vec[7]=false;
                  vec[8]=false;
                  vec[9]=false;
                  vec[10]=false;
                  vec[11]=false;
                  vec[12]=true;
                  vec[13]=false;
                  vec[14]=false;
                  vec[15]=false;
                  vec[16]=true;  
                break;
            case 4:
                  vec[0]=true;
                  vec[1]=false;
                  vec[2]=false;
                  vec[3]=false;
                  vec[4]=false;
                  vec[5]=false;
                  vec[6]=true;
                  vec[7]=true;
                  vec[8]=false;
                  vec[9]=false;
                  vec[10]=true;
                  vec[11]=false;
                  vec[12]=true;
                  vec[13]=false;
                  vec[14]=false;
                  vec[15]=false;
                  vec[16]=false;
                break;
            case 5:
                 vec[0]=true;
                  vec[1]=false;
                  vec[2]=false;
                  vec[3]=false;
                  vec[4]=false;
                  vec[5]=false;
                  vec[6]=true;
                  vec[7]=true;
                  vec[8]=false;
                  vec[9]=false;
                  vec[10]=true;
                  vec[11]=false;
                  vec[12]=true;
                  vec[13]=false;
                  vec[14]=false;
                  vec[15]=false;
                  vec[16]=false;
                break;
            case 6:
                  vec[0]=true;
                  vec[1]=false;
                  vec[2]=false;
                  vec[3]=false;
                  vec[4]=false;
                  vec[5]=true;
                  vec[6]=true;
                  vec[7]=true;
                  vec[8]=false;
                  vec[9]=true;
                  vec[10]=false;
                  vec[11]=false;
                  vec[12]=true;
                  vec[13]=false;
                  vec[14]=false;
                  vec[15]=false;
                  vec[16]=false;
                break;
            case 7:
                  vec[0]=true;
                  vec[1]=false;
                  vec[2]=false;
                  vec[3]=false;
                  vec[4]=false;
                  vec[5]=true;
                  vec[6]=true;
                  vec[7]=false;
                  vec[8]=false;
                  vec[9]=false;
                  vec[10]=false;
                  vec[11]=false;
                  vec[12]=true;
                  vec[13]=false;
                  vec[14]=false;
                  vec[15]=false;
                  vec[16]=true;
                break;
            case 8:
                  vec[0]=true;
                  vec[1]=false;
                  vec[2]=false;
                  vec[3]=false;
                  vec[4]=false;
                  vec[5]=true;
                  vec[6]=true;
                  vec[7]=false;
                  vec[8]=false;
                  vec[9]=true;
                  vec[10]=false;
                  vec[11]=false;
                  vec[12]=true;
                  vec[13]=false;
                  vec[14]=false;
                  vec[15]=false;
                  vec[16]=true;
                
                break;
            case 9:
                  vec[0]=true;
                  vec[1]=false;
                  vec[2]=false;
                  vec[3]=false;
                  vec[4]=false;
                  vec[5]=true;
                  vec[6]=true;
                  vec[7]=false;
                  vec[8]=false;
                  vec[9]=false;
                  vec[10]=false;
                  vec[11]=false;
                  vec[12]=true;
                  vec[13]=false;
                  vec[14]=false;
                  vec[15]=false;
                  vec[16]=true;
             break;     
               
                
                
        }
        return vec;
    }
    public String numeroADia(int numdia){
        String dia="Lunes";
        switch(numdia){
            case 2:
                dia="Martes";
             break;  
             case 3:
                 dia="Miercoles";
             break;
             case 4:
                 dia="Jueves";
             break;
             case 5:
                 dia="Viernes";
             break;
              case 6:
                  dia="Sabado";
             break;
             case 7:
                 dia="Domingo";
             break;
        }
        return dia;
    }
    
    
}
