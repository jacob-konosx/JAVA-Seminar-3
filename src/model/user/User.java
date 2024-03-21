package model.user;

import model.user.GuestUser;
import service.IPostService;

import java.security.MessageDigest;

public abstract class User extends GuestUser implements IPostService {
    private String username;
    private String password;
    protected String nameAndSurnameOrTitle;

    public User() {
        super();
        setPassword("1234556789");
    }

    public User(String password) {
        super();
        setPassword(password);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername() {
        this.username = nameAndSurnameOrTitle.toLowerCase().replace(" ", "")+"_"+getUserID();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password){
        if (password!=null && password.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$"))
            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                md.update(password.getBytes());
                this.password = new String(md.digest());
            } catch (Exception e) {
                this.password = "--------";
            }
        else
            this.password = "shit pass";
    }

    public String getNameAndSurnameOrTitle() {
        return nameAndSurnameOrTitle;
    }

    public abstract void setNameAndSurnameOrTitle(String nameAndSurnameOrTitle);

    public void login(){

    }
    public void followPage(){

    }

    @Override
    public String toString() {
        return super.toString() + ":" + nameAndSurnameOrTitle + " (" + username +") ";
    }
}
