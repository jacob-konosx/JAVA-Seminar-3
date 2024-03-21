package model.user;

import model.post.Post;

import java.util.ArrayList;

public class Page {
    private String title;
    private String description;
    private ArrayList<User> followers = new ArrayList<User>();
    private ArrayList<Post> postsInPage = new ArrayList<Post>();

    public Page() {
        setTitle("Mākas");
        setDescription("MASDFASFDGAFDSGASFG asdfjasfdjg asfdgal;kdsfjg;alksjfglajsflgja;/lfdskgjmadsfglkajdsflkgja;lkdsfjgalkjsfd;lgkajnsfdkjgasnfdgkjnawskjdgfakjsnfdgkjabns.lfkjdgb.akbfsg.kjajresga;jfdsbn/g;aner/gna/erng/anergoabnsfjgbajksbnrgjn");
    }

    public Page(String title, String description ) {
        setTitle(title);
        setDescription(description);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title != null && title.length() > 5 && title.length() < 20)
            this.title = title;
        else
            this.title = "title";
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description != null && description.length() > 50 && description.length() < 300)
            this.description = description;
        else
            this.description = "description";    }

    public ArrayList<User> getFollowers() {
        return followers;
    }

    public ArrayList<Post> getPostsInPage() {
        return postsInPage;
    }
    public String toString(){
        return title + "(" + description + ")" + "followers: " + followers.size();
    }
}
