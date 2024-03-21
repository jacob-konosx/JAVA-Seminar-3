package model.user;

import model.post.Post;
import model.post.PostType;

import javax.crypto.interfaces.PBEKey;
import java.util.ArrayList;

public class BusinessUser extends User{
    private String PVNNo;
    private ArrayList<Page> listOfPages = new ArrayList<Page>();

    public BusinessUser() {
        super();
        setNameAndSurnameOrTitle("AutoServiss");
        setUsername();
        setPVN("LV40003245752");
    }


    public BusinessUser(String title, String password, String PVN) {
        super(password);
        setNameAndSurnameOrTitle(title);
        setUsername();
        setPVN(PVN);
    }

    public String getPVNNo() {
        return PVNNo;
    }

    public void setPVN(String pVNNo) {
        if(pVNNo != null && pVNNo.matches("[A-Z]{2}[0-9]{11}"))
            this.PVNNo = pVNNo;
        else
            this.PVNNo = "----------";
    }

    public ArrayList<Page> getListOfPages() {
        return listOfPages;
    }

    public void setListOfPages(ArrayList<Page> listOfPages) {
        this.listOfPages = listOfPages;
    }

    @Override
    public void setNameAndSurnameOrTitle(String nameAndSurnameOrTitle) {
        if (nameAndSurnameOrTitle != null && nameAndSurnameOrTitle.matches("^([a-zA-Z]{2,}\\s[a-zA-Z]{1,}'?-?[a-zA-Z]{2,}\\s?([a-zA-Z]{1,})?)")){
            super.nameAndSurnameOrTitle = nameAndSurnameOrTitle;
        }else {
            super.nameAndSurnameOrTitle = "---";
        }
    }

    public String toString(){
        return super.toString() + " " + PVNNo;
    }

    public void createPage(String title, String description) throws Exception{
        for (Page tempP: listOfPages){
            if (tempP.getTitle().equals(title)){
                throw new Exception("Page with this title already exists!");
            }
        }
        Page newPage = new Page(title, description);
        listOfPages.add(newPage);
    }
    public void publishPostInPage(String pageTitle, String msg) throws Exception {
        for (Page tempP: listOfPages){
            if (tempP.getTitle().equals(pageTitle)){
                Post newPost = publishPost(PostType.publicPost, msg);
                tempP.getPostsInPage().add(newPost);
                return;
            }
        }
        throw new Exception("Page not found");
    }

    @Override
    public Post publishPost(PostType type, String msg) throws Exception {
        Post newPost = new Post(msg);
        return newPost;
    }
}
