package model.user;

import model.post.PostType;

import java.util.ArrayList;

public class BusinessUser extends User{
    private String PVN;
    private ArrayList<Page> listOfPages = new ArrayList<Page>();

    public String getPVN() {
        return PVN;
    }

    public void setPVN(String PVN) {
        if (PVN!= null && PVN.matches(""))
            this.PVN = PVN;
    }

    public ArrayList<Page> getListOfPages() {
        return listOfPages;
    }

    public void setListOfPages(ArrayList<Page> listOfPages) {
        this.listOfPages = listOfPages;
    }

    @Override
    public void setNameAndSurnameOrTitle(String nameAndSurnameOrTitle) {

    }

    @Override
    public void publishPost(PostType type, String msg) throws Exception {

    }
}
