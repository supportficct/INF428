package android;

import java.io.DataInputStream;
import java.io.DataOutputStream;

/**
 * Created by eddye on 05/10/2015.
 */
public class tablaSms {
    sms ListSMS[];
    int n;
    int Dim;
    public tablaSms(){
        this.ListSMS = new sms[10000];
        this.n = -1;
    }
    public void Add(int id, int imei,String contenido){
        this.n++;
        ListSMS[this.n] = new sms(id,imei,contenido);
    }
    public boolean Save(DataOutputStream F) {    //Guarda la tupla al flujo F. Si hay error, return false.
        try {
            F.writeUTF("Manager SMS");
            F.writeInt(this.n);
         //   System.out.println(this.n);
            for (int i = 0; i <= this.n; i++) {
                ListSMS[i].Save(F);
                System.out.println(ListSMS[i].toString());
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
                ListSMS[i] = new sms(0, 0, "");
                sw = ListSMS[i].Open(F);
                //System.out.println("088780298--**************");
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
            S += ListSMS[i].toString();
        }
        return S;
    }


}
