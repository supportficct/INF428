package archivos;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class Tabla {

    Tupla V[];

    public Tabla() {
        this.V = new Tupla[5];
        for (int i = 0; i < V.length; i++) {
            V[i] = new Tupla("" + i + "x", i * 3, i * 4);
        }

    }

    public boolean Save(DataOutputStream F) {    //Guarda la tupla al flujo F. Si hay error, return false.
        try {
            F.writeInt(V.length);
            for (int i = 0; i < V.length; i++) {
                V[i].Save(F);
            }
            return true;
        } catch (Exception e) {
        }

        return false;
    }

    public boolean Open(DataInputStream F) {    //Guarda la tupla al flujo F. Si hay error, return false.
        try {
            int n = F.readInt();
            for (int i = 0; i < n; i++) {
                V[i] = new Tupla("", 0, 0);
                boolean sw =  V[i].Open(F);
                if (sw) {
                    return true;
                }else{
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
        for (int i = 0; i < V.length; i++) {
            S += V[i].toString();
        }
        return S;
    }
}
