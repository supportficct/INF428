package archivos;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class Tupla {

    String Nombre;
    int Edad, Altura, Hash;

    public Tupla(String Nombre, int Edad, int Altura) {
        this.Nombre = Nombre;
        this.Edad = Edad;
        this.Altura = Altura;
        this.Hash = (Edad + "" + Altura + "" + Nombre).hashCode();
    }

    public boolean Save(DataOutputStream F) {    //Guarda la tupla al flujo F. Si hay error, return false.
        try {
            F.writeInt(Edad);
            F.writeInt(Altura);
            F.writeUTF(Nombre);
            F.writeInt(Hash);
            return true;
        } catch (Exception e) {
        }

        return false;
    }

    public boolean Open(DataInputStream F) { //Lee del flujo F, una tupla.
        try {
            Edad = F.readInt();
            Altura = F.readInt();
            Nombre = F.readUTF();
            Hash = F.readInt();
            if (Hash == (Edad + "" + Altura + "" + Nombre).hashCode()) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
        }

        return false;
    }

    public String toString() {
        return "HashCODE = " + Hash + "\n =>" + Nombre + "" + Edad + "" + Altura + "\n";
    }

}
