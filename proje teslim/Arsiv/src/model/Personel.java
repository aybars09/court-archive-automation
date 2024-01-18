
package model;


public class Personel extends BaseEntity implements EntityInterface{
    private String tcNo;
    private String adSoyad;
    private String dTArihi;
    private String calistigiBirim;

    public Personel() {
    }

    public Personel(String tcNo, String adSoyad, String dTArihi, String calistigiBirim) {
        this.tcNo = tcNo;
        this.adSoyad = adSoyad;
        this.dTArihi = dTArihi;
        this.calistigiBirim = calistigiBirim;
    }

    public String getTcNo() {
        return tcNo;
    }

    public void setTcNo(String tcNo) {
        this.tcNo = tcNo;
    }

    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public String getdTArihi() {
        return dTArihi;
    }

    public void setdTArihi(String dTArihi) {
        this.dTArihi = dTArihi;
    }

    public String getCalistigiBirim() {
        return calistigiBirim;
    }

    public void setCalistigiBirim(String calistigiBirim) {
        this.calistigiBirim = calistigiBirim;
    }

    @Override
    public String toString() {
        return  adSoyad+ " (TC:"+tcNo+")";
    }
    
    
}
