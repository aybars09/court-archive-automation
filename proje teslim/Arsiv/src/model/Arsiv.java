
package model;


public class Arsiv extends BaseEntity implements EntityInterface{

    private int yil;
    private Mahkemeler geldigiYer;
    private String  dosyaEsasNo;
    private String kararNo;
    private String  karartarihi;
    private String kesinlesmeTarihi;
    private DavaTuru davaTuru;
    private String durumu;

    public Arsiv() {
    }

    public Arsiv(int yil, Mahkemeler geldigiYer, String dosyaEsasNo, String kararNo, String karartarihi, String kesinlesmeTarihi, DavaTuru davaTuru) {
        this.yil = yil;
        this.geldigiYer = geldigiYer;
        this.dosyaEsasNo = dosyaEsasNo;
        this.kararNo = kararNo;
        this.karartarihi = karartarihi;
        this.kesinlesmeTarihi = kesinlesmeTarihi;
        this.davaTuru = davaTuru;
    }

    public String getDurumu() {
        return durumu;
    }

    public void setDurumu(String durumu) {
        this.durumu = durumu;
    }
    public int getYil() {
        return yil;
    }

    public void setYil(int yil) {
        this.yil = yil;
    }

    public Mahkemeler getGeldigiYer() {
        if(geldigiYer==null)
            geldigiYer=new Mahkemeler();
        return geldigiYer;
    }

    public void setGeldigiYer(Mahkemeler geldigiYer) {
        this.geldigiYer = geldigiYer;
    }

    public String getDosyaEsasNo() {
        return dosyaEsasNo;
    }

    public void setDosyaEsasNo(String dosyaEsasNo) {
        this.dosyaEsasNo = dosyaEsasNo;
    }

    public String getKararNo() {
        return kararNo;
    }

    public void setKararNo(String kararNo) {
        this.kararNo = kararNo;
    }

    public String getKarartarihi() {
        return karartarihi;
    }

    public void setKarartarihi(String karartarihi) {
        this.karartarihi = karartarihi;
    }

    public String getKesinlesmeTarihi() {
        return kesinlesmeTarihi;
    }

    public void setKesinlesmeTarihi(String kesinlesmeTarihi) {
        this.kesinlesmeTarihi = kesinlesmeTarihi;
    }


    public DavaTuru getDavaTuru() {
        if(davaTuru==null)
            davaTuru=new DavaTuru();
        return davaTuru;
    }

    public void setDavaTuru(DavaTuru davaTuru) {
        this.davaTuru = davaTuru;
    }

    @Override
    public String toString() {
        return "EsasNo: "+dosyaEsasNo +", Karar No:" + kararNo + ", Kesinleşme Tar: " + kesinlesmeTarihi ;
    }
    
}
