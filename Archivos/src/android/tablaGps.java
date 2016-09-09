package android;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.util.List;

/**
 * Created by Eddy 01/10/2015.
 */
public class tablaGps {
    public gps ListGPS[];
    public int n;
    public int Dim;
    int MAX;
    public tablaGps(){
     //  ListGPS = new List<gps>();
      //  this.MAX = Integer.MAX_VALUE;
        this.n = -1;
        this.ListGPS = new gps[100];
        this.Dim = -1;
    }

    public void Add(int a,int b,int c,int d){
        this.n++;
        ListGPS[this.n] = new gps(a,b,c,d);
    }

    public boolean Save(DataOutputStream F) {    //Guarda la tupla al flujo F. Si hay error, return false.
        try {
            F.writeUTF("Manager GPS");
            F.writeInt(this.n);
            for (int i = 0; i <= this.n; i++) {
                ListGPS[i].Save(F);
                System.out.println(ListGPS[i].toString());
            }
            return true;
        } catch (Exception e) {
        }

        return false;
    }

    public boolean Open(DataInputStream F) {    //Guarda la tupla al flujo F. Si hay error, return false.
        Boolean sw = true;
        try {
            String s = F.readUTF();
            System.out.println("Nombre de la Class= " + s);
            Dim = F.readInt();
        //    System.out.println("otro error = " + Dim);
            for (int i = 0; i <= Dim; i++) {
                ListGPS[i] = new gps(0, 0, 0, 0);
                sw = ListGPS[i].Open(F);
                if (!sw) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
        }

        return false;
    }

    public String toString() {
        String S = "";
       /// System.out.println("ListGPS.length =" + Dim );
      //  System.out.println("--------=====");
        for (int i = 0; i <= Dim ;i++) {
         ///   System.out.println("Aqui esa mierda uno" + S);
            S += ListGPS[i].toString();
         ///   System.out.println("Aqui esa mierda dos" + S);
        }
        return S;
    }


}
