package model.user;

public class GuestUser{
    private long userID;
    private static long counter = 0;

    public GuestUser() {
        setUserID();
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID() {
        this.userID = counter;
        counter++;
    }

    public String toString(){
        return ""+userID;
    }
}
