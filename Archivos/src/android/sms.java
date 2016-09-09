package android;

import java.io.DataInputStream;
import java.io.DataOutputStream;

/**
 * Created by eddye on 05/10/2015.
 */
public class sms {
    int id, imei,Hash;
    String contenido;

    public sms(int Id, int Imei, String Contenido){
        this.id = Id;
        this.imei =Imei;
        this.contenido = Contenido;
        this.Hash =  (Id + "" + Imei + "" + Contenido ).hashCode();
    }



    public boolean Save(DataOutputStream F) {    //Guarda la tupla al flujo F. Si hay error, return false.
        try {
            F.writeInt(this.id);
            F.writeInt(this.imei);
            F.write(this.contenido.getBytes());
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
      //      byte b[] = F.readUTF().getBytes();
      //      String newStr = new String (b);
            this.contenido = F.readUTF();//newStr;
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
        System.out.println("--------------------*SMS*----------------------");
        // return "HashCODE = " + Hash + "\n =>" + id + "" + imei + "" + x + "" + y + "\n";
        return  "HashCode="+Hash + "\n" + "ListaSMS[ ]=" + id + "" + imei + "" +  contenido + "\n";
    }



}
