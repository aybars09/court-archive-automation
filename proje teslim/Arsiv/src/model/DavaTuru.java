
package model;


public class DavaTuru extends BaseEntity implements EntityInterface{
    private int imhaSuresi;
    private Mahkemeler mahkeme;
    private String davaninTuru;

    
    
    public DavaTuru() {
    }

    
    
    public DavaTuru(int imhaSuresi, Mahkemeler mahkeme, String davaninTuru) {
        this.imhaSuresi = imhaSuresi;
        this.mahkeme = mahkeme;
        this.davaninTuru = davaninTuru;
    }

    public int getImhaSuresi() {
        return imhaSuresi;
    }

    public void setImhaSuresi(int imhaSuresi) {
        this.imhaSuresi = imhaSuresi;
    }

    public Mahkemeler getMahkeme() {
        if(mahkeme==null)
            mahkeme=new Mahkemeler();
        return mahkeme;
    }

    public void setMahkeme(Mahkemeler mahkeme) {
        this.mahkeme = mahkeme;
    }

    public String getDavaninTuru() {
        return davaninTuru;
    }

    public void setDavaninTuru(String davaninTuru) {
        this.davaninTuru = davaninTuru;
    }

    @Override
    public String toString() {
        return davaninTuru+" ( İmha Yılı: "+ imhaSuresi+ ")";
    }
    
    
    
}

