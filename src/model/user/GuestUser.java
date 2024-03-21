package model.user;

import service.impl.GuestUserServiceImpl;

public class GuestUser{
    private long userID;
    private static long counter = 0;

    public GuestUserServiceImpl service = new GuestUserServiceImpl();

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
