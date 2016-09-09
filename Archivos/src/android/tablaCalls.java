package android;

import java.io.DataInputStream;
import java.io.DataOutputStream;

/**
 * Created by eddye on 06/10/2015.
 */
public class tablaCalls {
    calls ListCALLS[];
    int n;
    int Dim;
    public tablaCalls(){
        this.ListCALLS = new calls[10000];
        this.n = -1;
    }

    public void Add(int idd, int imeii, String Contenido){
        n++;
        ListCALLS[n] = new calls(idd,imeii,Contenido);
    }
    public boolean Save(DataOutputStream F) {    //Guarda la tupla al flujo F. Si hay error, return false.
        try {
            F.writeUTF("Manager CALLS");
            F.writeInt(this.n);
            for (int i = 0; i <= this.n; i++) {
                ListCALLS[i].Save(F);
                System.out.println(ListCALLS[i].toString());
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
            for (int i = 0; i <= Dim; i++) {
                ListCALLS[i] = new calls(0, 0, "");
                sw = ListCALLS[i].Open(F);
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
        for (int i = 0; i <= Dim ;i++) {
            System.out.println(i);
            System.out.println(Dim);
            S += ListCALLS[i].toString();
        }
        return S;
    }


}
