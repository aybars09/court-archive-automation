 
package model;

 
public class Imha extends BaseEntity implements EntityInterface{
    private Arsiv  arsiv;
    private Personel pers;
    private String date; 

    public Imha() {
    }

    public Imha(Arsiv arsiv, Personel pers, String date) {
        this.arsiv = arsiv;
        this.pers = pers;
        this.date = date;
    }

    public Arsiv getArsiv() {
        if(arsiv==null)
            arsiv=new Arsiv();
        return arsiv;
    }

    public void setArsiv(Arsiv arsiv) {
        this.arsiv = arsiv;
    }

    public Personel getPers() {
        if(pers==null)
           pers =new Personel();
        return pers;
    }

    public void setPers(Personel pers) {
        this.pers = pers;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Imha{" + "arsiv=" + arsiv + ", pers=" + pers + ", date=" + date + '}';
    }
    
}
