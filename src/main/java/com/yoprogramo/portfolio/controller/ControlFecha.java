package com.yoprogramo.portfolio.controller;

import java.time.LocalDate;

/**
 * Clase con método para validar fecha
 * @author Hector
 */
public class ControlFecha {

    public ControlFecha() {
    }

    // Recibe una cadena de fecha y devuelve un tipo LocalDate válido [error: devuelve 1900,01,01]
    public LocalDate validaFecha(String fecha){
        String f = fecha.trim();
        /* para éste caso es más eficiente el método aFecha(...)
        Pattern pat1 = Pattern.compile("^\\d{4}([\\-/.])(0?[1-9]|1[1-2])\\1(3[01]|[12][0-9]|0?[1-9])$"); // yyyy/MM/dd
        Pattern pat2 = Pattern.compile("^(?:3[01]|[12][0-9]|0?[1-9])([\\-/.])(0?[1-9]|1[1-2])\\1\\d{4}$"); // dd/MM/yyyy
        Matcher mat1 = pat1.matcher(f);
        Matcher mat2 = pat2.matcher(f);
        */
        int d=1, m=1, a=1900;
        LocalDate ld = LocalDate.of(a, m, d);
        int[] aD = aFecha(f);
        if(aD[2] > 1900 && aD[1] > 0 && aD[0] > 0)
            ld = LocalDate.of(aD[2], aD[1], aD[0]);
        return ld;
    }
    /**
     * Array de 3 valores enteros : [0]=0->error / [0]=dia - [1]=mes - [2]=año
     * @param fecha Una fecha de cadena a validar. Ej: 1/1/2022 - 2021/12/25 , etc.
     * @return índex 0= número dia / 1=mes / 2=año
     */
    private int[] aFecha(String fecha){
        String f = fecha.trim();
        String c = "";
        char ch;
        int asc=0, g=0, d=0, m=0, a=0, seq=1;
        int[] aF = new int[3];
        for(int i=0; i < f.length(); i++){
            ch = f.charAt(i);
            asc = (int) ch;
            try {
                if(asc >= 48 && asc <= 57){
                    c += ch;
                }else{
                   switch (seq){
                       case 1:
                           d = Integer.parseInt(c);
                           c = "";
                           seq++;
                           break;
                       case 2:
                           m = Integer.parseInt(c);
                           c = "";
                           seq++;
                   }
                }
            } catch (Exception e) {
                aF[0] = 0;
                aF[1] = 0;
                aF[2] = 0;
                return aF;
            }
        }
        if(seq == 3)
            a = Integer.parseInt(c);
        if(d > 31){ //Se asume que se ingresó formato 'yyyy/MM/dd'
            g = d; d = a; a = g;
        }
        if(d > 0 && d <= 31 && m > 0 && m <= 12 && a >= 1900 && a <= 2100 ){
            aF[0] = d; aF[1] = m; aF[2] = a;
        }else{
            aF[0] = 0; aF[1] = 0; aF[2] = 0; //Verifica cierta lógica en la entrada de datos
        }
        
        return aF;
    }
}
