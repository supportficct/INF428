/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author eddye
 */
public class Archivos {

    /**
     * @param args the command line arguments
     */
    static void Save(String Filename) {
        try {
            FileOutputStream F = new FileOutputStream(Filename);    //Crear archivo (sobreescribiendo si existiese).
            DataOutputStream Out = new DataOutputStream(F);
            
            Tabla T = new Tabla();
            T.Save(Out);
            Out.close();
            
        } catch (IOException e) {
            System.err.println("Codigo3.Save: Error al guardar " + e.getMessage());
        }
        //DataOutputStream Out = OpenToWrite(FileName);
    }
        static String Open(String Filename) {
            String s = "";
        try {
            FileInputStream F = new FileInputStream(Filename);    //Crear archivo (sobreescribiendo si existiese).
            DataInputStream In = new DataInputStream(F);
            
            Tabla T = new Tabla();
            
            boolean sw2 = T.Open(In);
            In.close();
            s = T.toString();
           // System.out.println(T.toString());
            if (sw2) {
                return s;//true;
            } else {
                return s;//false;
            }
            
        } catch (IOException e) {
            System.err.println("Archivo Corrupto : " + e.getMessage());
            return s;//false;
        }
        //DataOutputStream Out = OpenToWrite(FileName);
    }

    public static void main(String[] args) {
        // TODO code application logic here
      ///  Save("D:\\Eddyyyy.txt");
        String datos = Open("Edd.txt");
      System.out.println(datos);
        
        ////////////hashCode/////////////
      //  String e = "Eddy";
     //   int nro = e.hashCode();
     //   System.out.println(e);
      //  System.out.println(""+nro);
        /////////////////////////////////
        
        
        ///hacer una cabezera antes de la cantidad del V[] ejemplo
        /// Es como un tipo de seguridad HASHCODE
        /*
        E
        D
        D
        3
        0x00
        1x34
        2x68
        */
    }
    

}
