
package model;

/**
 * Bu sinif sisteme basarili bir sekilde login olan kullanicinin USER bilgilerini tutar
 * static bir metodtur. her yerden erisilebilinir
 */
public class ActiveUser {
    //static USER and get set 
    private static User user;
    public static User getActiveUser() { return user; }
    public static void setActiveUser(User onlineUser) { ActiveUser.user = onlineUser; }
}
