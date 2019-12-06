/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores.clases;

import entidades.CargaHoraria;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author a
 */
public class Validaciones {

    public Boolean validarVacios(List<String> args) {

        Boolean repuesta = true;
        for (String arg : args) {

            if (" ".equals(arg) || arg == null || "".equals(arg)) {
                repuesta = false;
            }

        }
        return repuesta;
    }

    public boolean verificarCi(String ci) {
        if (ci != null) {
            int c = 0, numero, aux, suma = 0, digV, des = 0, V = 0;

            int[] coefi = {2, 1, 2, 1, 2, 1, 2, 1, 2, 1};
            int[] numeros;
            numeros = new int[10];
            int len = ci.length();
            String letra, digVc;

            if (len == 10) {

                //diguito verificador
                digVc = ci.substring(9, 9 + 1);
                digV = Integer.parseInt(digVc);

                //multiplicar por los coficientes
                while (c < len) {
                    letra = ci.substring(c, c + 1);
                    numero = Integer.parseInt(letra);
                    numeros[c] = numero * coefi[c];
                    System.out.println(letra);

                    c++;
                }
                //vrificar si uno es mayor o igual a 10 solo cocon los 9 primros
                System.out.println("-----------------");
                for (int i = 0; i < 9; i++) {
                    if (numeros[i] >= 10) {
                        aux = numeros[i] - 9;
                        numeros[i] = aux;

                    }
                    suma = suma + numeros[i];
                }

                System.out.println(digV);

                //dfinir dsena
                if (suma > 40) {
                    des = 50;
                } else {
                    if (suma > 30) {
                        des = 40;
                    } else {
                        if (suma > 20) {
                            des = 30;
                        } else {
                            if (suma > 10) {
                                des = 20;
                            } else {
                                des = 10;
                            }
                        }
                    }
                }
                V = des - suma;
                System.out.println("--->" + suma);
                System.out.println("--->" + des);
                System.out.println("--->" + V);

                if (V == digV) {
                    return true;
                }
            }

        }

        return false;
    }

    public String[] separarFrase(String s) {
        int cp = 0; // Cantidad de palabras

        // Recorremos en busca de espacios
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') { // Si es un espacio
                cp++; // Aumentamos en uno la cantidad de palabras
            }
        }

        // "Este blog es genial" tiene 3 espacios y 3 + 1 palabras
        String[] partes = new String[cp + 1];
        for (int i = 0; i < partes.length; i++) {
            partes[i] = ""; // Se inicializa en "" en lugar de null (defecto)
        }

        int ind = 0; // Creamos un índice para las palabras
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') { // Si hay un espacio
                ind++; // Pasamos a la siguiente palabra
                continue; // Próximo i
            }
            partes[ind] += s.charAt(i); // Sino, agregamos el carácter a la palabra actual
        }
        return partes; // Devolvemos las partes
    }

    public long[] calculardiferenciaDatesHM(List<CargaHoraria> cargas) {
        long[] hm = new long[2];
        long h, m, restohora, milisegundos, minutos, horas;
        horas = 0;
        minutos = 0;
        for (CargaHoraria carga : cargas) {
            milisegundos = carga.getHoraFin().getTime() - carga.getHoraInicial().getTime();
            h = milisegundos / 3600000;
            restohora = milisegundos % 3600000;
            m = restohora / 60000;
            horas = horas + h;
            minutos = minutos + m;
        }
        //ajustar tirmpo
        long aux;
        aux = minutos / 60;
        horas = horas + aux;
        minutos = minutos % 60;
        hm[0] = horas;
        hm[1] = minutos;
        return hm;
    }

    public Long carcularRestaFechas(String fecha) throws ParseException {
       
          //String fecha = "Martes 09:00:00-10:00:00 CA1-3";
        int[] pos = new int[5];
        int j=0,ban=0;
        int guion=0;
        for (int i = 0; i < fecha.length()&& ban == 0; i++) {
            
            if(fecha.charAt(i)== '-'){
               guion=i;
               ban=1;
            }
        }
        
        
        for (int i = 0; i < fecha.length() && j<2; i++) {
            System.out.println("..."+fecha.charAt(i));
            if(fecha.charAt(i)== ' '){
               pos[j]=i;  j++;
               pos[j]=i;
            }
        }
        pos[0]=pos[0]+2;
        
       
        String hora1 = fecha.substring(pos[0], guion);
        String hora2=  fecha.substring(guion+1, pos[1]);
        DateFormat format = new SimpleDateFormat("kk:mm:ss");
        Date date1 = format.parse(hora1);
        Date date2 = format.parse(hora2);
        
   
        Long res=date2.getTime()-date1.getTime();
        
        //String fecha = "Martes 09:00:00-10:00:00 CA1-3";
        Long respuesta = res/3600000;
        
        if( respuesta.intValue() > 2 ) {
            System.out.println("MAYOR A 2");
            respuesta=respuesta-10L;
        }
        
        System.out.println("Resultado ----------> "+respuesta); //
        
        return respuesta;
    }
    
    public Long sumarHoras(List<CargaHoraria> cargas) throws ParseException  {
        Long suma=0L;
        System.out.println("LLEGARON  "+cargas.size());
        for (CargaHoraria carga : cargas) {
               String h=carga.getHorario();
               if(h.equals("")) {
                   
               } else{
                   suma=suma+this.carcularRestaFechas(carga.getHorario());
               }
               
        }
        return suma;
    }

    public static void main(String[] args) throws ParseException {
        Validaciones v = new Validaciones();
        v.carcularRestaFechas("Miercoles 17:00:00-19:00:00 CA1-1");

    }

}
