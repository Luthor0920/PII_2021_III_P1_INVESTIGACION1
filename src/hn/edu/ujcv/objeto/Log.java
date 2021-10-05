package hn.edu.ujcv.objeto;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Log {
        private BufferedWriter buffered;
        private String ruta;

        public Log(String ruta) throws IOException {
            this.ruta = ruta;
            this.open(true);
        }

        public Log(String ruta, boolean reset) throws IOException {
            this.ruta = ruta;
            this.open(!reset);
        }

        private void open(boolean apertura) throws IOException {
            this.buffered = new BufferedWriter(new FileWriter(this.ruta, apertura));
        }

        public void addLine(String linea) throws IOException {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");
            String formatoFecha = sdf.format(new Date());
            this.open(true);
            this.buffered.write(this.getClass()+" [" + formatoFecha + "]" + linea + "\n");
            this.close();
        }

        public String[] getLineas() throws IOException {
            ArrayList<String> lineaArchivo = new ArrayList<>();
            BufferedReader lector = new BufferedReader(new FileReader(this.ruta));
            String linea;
            while ((linea = lector.readLine()) != null) {
                lineaArchivo.add(linea);
            }
            lector.close();
            String[] lineas = new String[lineaArchivo.size()];

            for (int i = 0; i < lineaArchivo.size(); i++) {
                lineas[i] = lineaArchivo.get(i);
            }
            return lineas;
        }
        public void resetLog() throws IOException {
            this.open(false);
            this.close();
        }

        private void close() throws IOException {
            this.buffered.close();
        }
    }
