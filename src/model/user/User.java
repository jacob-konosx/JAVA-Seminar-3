package model.user;

public abstract class User extends GuestUser{
    private String username;
    private String password;
    private String nameAndSurnameOrTitle;

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

    public void setUsername(String username) {
        this.username = nameAndSurnameOrTitle+"_"+getUserID();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password){
        if (password!=null && password.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$"))
            this.password = username;
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
        return super.toString();
    }
}
