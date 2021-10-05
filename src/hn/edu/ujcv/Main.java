package hn.edu.ujcv;

import hn.edu.ujcv.objeto.Log;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        try {
            Log miLog = new Log("./log.log");
            miLog.addLine(" Evento 1");
            miLog.addLine(" Evento 2");
            miLog.addLine(" Evento 3");

            String[] lineas = miLog.getLineas();

            for (int i = 0; i < lineas.length; i++) {
                System.out.println(lineas[i]);
            }

        }catch(Exception e){
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
