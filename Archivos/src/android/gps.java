package android;

import java.io.DataInputStream;
import java.io.DataOutputStream;

/**
 * Created by Eddy 01/10/2015.
 */
public class gps {

    int id, imei, x, y,Hash;

    public gps(int ID, int IMEI, int X, int Y ){

        this.id = ID;
        this.imei = IMEI;
        this.x = X;
        this.y = Y;
        this.Hash = (ID + "" + IMEI + "" + X + "" + Y ).hashCode();
    }

    public boolean Save(DataOutputStream F) {    //Guarda la tupla al flujo F. Si hay error, return false.
        try {
            F.writeInt(this.id);
            F.writeInt(this.imei);
            F.writeInt(this.x);
            F.writeInt(this.y);
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
            this.x = F.readInt();
            this.y = F.readInt();
            Hash = F.readInt();
            if (this.Hash == (id + "" + imei + "" + x + "" + y ).hashCode()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public String toString() {
        System.out.println("--------------------*GPS*----------------------");
       // return "HashCODE = " + Hash + "\n =>" + id + "" + imei + "" + x + "" + y + "\n";
        return  "HashCode="+Hash + "\n" + "ListaGPS[ ]=" + id + "" + imei + "" + x + "" + y + "\n";
    }

}
