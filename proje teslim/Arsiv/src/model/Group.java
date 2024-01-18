package model;




public class Group extends BaseEntity implements EntityInterface {

    private String grupName;

    //constructure
    public Group() {
    }

    //constructure
    public Group(String grupName) {
        this.grupName = grupName;
    }

    
    //get set
    public String getGrupName() { return grupName; }
    public void setGrupName(String grupName) { this.grupName = grupName; }

    
    @Override
    public String toString() {
        return  grupName ;
    }
}
