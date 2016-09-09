package android;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity {

    public static String NameFile;

    public static tablaGps Tgps;
    public static tablaSms Tsms;
    public static tablaCalls Tcalls;

    public static String OpenFile(String Filename) {
        String s = "";
//        FileInputStream F;
        try {
            FileInputStream F = new FileInputStream(Filename);    //Crear archivo (sobreescribiendo si existiese).
            DataInputStream In = new DataInputStream(F);
//            F = openFileInput(Filename);
//            DataInputStream In = new DataInputStream(F);
            System.out.println("Archivo paso por OpenFile (" + Filename + ");");
            tablaGps T = new tablaGps();
            T.Open(In);
            tablaSms TT = new tablaSms();
            TT.Open(In);
            tablaCalls TTT = new tablaCalls();
            TTT.Open(In);
            //   boolean sw2 = T.Open(In);
            In.close();
            //System.out.println(T);
            s = T.toString() + "\n" + TT.toString() + "\n" + TTT.toString();
            System.out.println(s);
            return s;

        } catch (IOException e) {
            System.err.println("Archivo Corrupto : " + e.getMessage());
//            Toast t = Toast.makeText(this, "Archivo Corrupto",
//                    Toast.LENGTH_SHORT);
//            t.show();
            return s;//false;
        }
    }

    public static void Save() {
        try {

            FileOutputStream F = new FileOutputStream(NameFile);    //Crear archivo (sobreescribiendo si existiese).
            DataOutputStream Out = new DataOutputStream(F);
            Tgps.Save(Out);
            Tsms.Save(Out);
            Tcalls.Save(Out);
            Out.close();
//            Log.d("HolaMundo","Termino el Save();");
        } catch (IOException e) {
            System.err.println("Save: Error al guardar aqui en (Save) " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        NameFile = "D:\\file.txt";

        Tgps = new tablaGps();
        Tsms = new tablaSms();
        Tcalls = new tablaCalls();

        Tgps.Add(1, 1, 91, 91);
        Tgps.Add(9, 9, 9, 9);

        Tsms.Add(1, 646135, "mensaje ONE");

        Tcalls.Add(10, 9999, "llamada uno");
        Tcalls.Add(10, 8888, "llamada dos");
//                        String dato = tres.getText().toString();
//                int datos = Integer.valueOf(dato);
//                Tgps.Add(datos,datos,datos,datos);
        Save();
        System.out.println(OpenFile(NameFile));
        //     uno.setText(Open());
    }
}
