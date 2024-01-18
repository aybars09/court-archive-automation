
package model;


public class MahkemeTuru extends BaseEntity implements EntityInterface{
    private String mahkemeTuru;

    public MahkemeTuru() {
    }

    public MahkemeTuru(String mahkemeTuru) {
        this.mahkemeTuru = mahkemeTuru;
    }

    public String getMahkemeTuru() {
        return mahkemeTuru;
    }

    public void setMahkemeTuru(String mahkemeTuru) {
        this.mahkemeTuru = mahkemeTuru;
    }

    @Override
    public String toString() {
        return mahkemeTuru;
    }

    
}
