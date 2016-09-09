package android;

import java.io.DataInputStream;
import java.io.DataOutputStream;

/**
 * Created by eddye on 06/10/2015.
 */
public class calls {
    int id, imei,Hash;
    String contenido;

    public calls(int Id, int Imei, String Contenido){
        this.id = Id;
        this.imei =Imei;
        this.contenido = Contenido;
        this.Hash = (Id + "" + Imei + "" + Contenido ).hashCode();
    }



    public boolean Save(DataOutputStream F) {    //Guarda la tupla al flujo F. Si hay error, return false.
        try {
       //     String x = 20+"";
     //      x.getBytes();
         ///   id.getBytes();
            F.writeInt(this.id);
         //   F.writeInt(this.id);
            F.writeInt(this.imei);
            F.writeUTF(this.contenido);
            F.writeInt(this.Hash);
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    public boolean Open(DataInputStream F) { //Lee del flujo F, una tupla.
        try {
            this.id = F.readInt();
            this.imei = F.readInt();
            this.contenido = F.readUTF();
            Hash = F.readInt();
            if (this.Hash == (id + "" + imei + "" + contenido ).hashCode()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
        }
        return false;
    }


    public String toString() {
        System.out.println("--------------------*CALLS*----------------------");

        // return "HashCODE = " + Hash + "\n =>" + id + "" + imei + "" + x + "" + y + "\n";
        return  "HashCode="+Hash + "\n" + "ListaCALLS[ ]=" + id + "" + imei + "" +  contenido + "\n";
    }



}
