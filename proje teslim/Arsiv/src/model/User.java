package model;
public class User extends BaseEntity implements EntityInterface {

    private String userName;
    private String password;
    private Group groups;
    private Personel pers;

    
    //contructure
    public User() {
    }

    
    //constructure
    public User(String userName, String password, Group groups, Personel pers) {
        this.userName = userName;
        this.password = password;
        this.groups = groups;
        this.pers = pers;
    }

    
    
    
    //getters
    public Personel getPers() {
        if (pers==null) {
            pers=new Personel();
        }
        return pers;
    }

        public Group getGroups() {
        if(groups==null)
            groups=new Group();
        return groups;
    }
   
    public String getUserName() { return userName; }    
    public String getPassword() { return password; }

    
    
    //setters
    public void setUserName(String userName) { this.userName = userName; }
    public void setPers(Personel pers) { this.pers = pers; }
    public void setPassword(String password) { this.password = password; }
    public void setGroups(Group groups) { this.groups = groups; }
    
    

    @Override
    public String toString() {
        return "Users{" + "userName=" + userName + ", password=" + password + ", groups=" + groups + ", pers=" + pers + '}';
    }
    
}
