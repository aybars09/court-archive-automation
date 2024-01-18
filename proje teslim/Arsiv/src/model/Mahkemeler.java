
package model;


public class Mahkemeler extends BaseEntity implements EntityInterface{
    private String adi;
    private MahkemeTuru mahkemeTuru;

    public Mahkemeler() {
    }

    public Mahkemeler(String adi, MahkemeTuru mahkemeTuru) {
        this.adi = adi;
        this.mahkemeTuru = mahkemeTuru;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public MahkemeTuru getMahkemeTuru() {
        if (mahkemeTuru==null) {
            mahkemeTuru=new MahkemeTuru();
        }
        return mahkemeTuru;
    }

    public void setMahkemeTuru(MahkemeTuru mahkemeTuru) {
        this.mahkemeTuru = mahkemeTuru;
    }

    @Override
    public String toString() {
        return  adi;
    }
    
}
