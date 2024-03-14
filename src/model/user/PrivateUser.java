package model.user;

import model.post.Post;
import model.post.PostType;

import java.util.ArrayList;

public class PrivateUser extends User {
    private ArrayList<Post> privatePosts = new ArrayList<Post>();
    private ArrayList<Post> publicPosts = new ArrayList<Post>();
    private ArrayList<User> followers = new ArrayList<User>();

    public PrivateUser() {
        super();
        setNameAndSurnameOrTitle("Jēkabs Konošnoks");
        setUsername();
    }
    public PrivateUser(String name, String surname, String password) {
        super(password);
        setNameAndSurnameOrTitle(name + " " + surname);
        setUsername();
    }


    public ArrayList<Post> getPrivatePosts() {
        return privatePosts;
    }

    public ArrayList<Post> getPublicPosts() {
        return publicPosts;
    }

    public ArrayList<User> getFollowers() {
        return followers;
    }

    @Override
    public void setNameAndSurnameOrTitle(String nameAndSurnameOrTitle) {
        if (nameAndSurnameOrTitle != null && nameAndSurnameOrTitle.matches("^([a-zA-Z]{2,}\\s[a-zA-Z]{1,}'?-?[a-zA-Z]{2,}\\s?([a-zA-Z]{1,})?)")){
            super.nameAndSurnameOrTitle = nameAndSurnameOrTitle;
        }else {
            super.nameAndSurnameOrTitle = "---";
        }
    }

    @Override
    public void publishPost(PostType type, String msg) throws Exception {
        if (type == null || msg == null){
            throw new Exception("Invalid post type or msg");
        }

        Post post = new Post(msg);
        if (type.equals(PostType.privatePost)){
            privatePosts.add(post);
        } else if (type.equals(PostType.publicPost)){
            publicPosts.add(post);
        }
    }

    public void followPrivateUser(User user) throws Exception{
        if (user == null) throw new Exception("Invalid user");
//        if (!followers.contains(user)){
//            followers.add(user);
//        }
        for(User tempUsr: followers){
            if (tempUsr.getUsername().equals(user.getUsername()))
                throw new Exception("User already following");
        }
        followers.add(user);
    }

    @Override
    public String toString() {
        return super.toString() + super.getNameAndSurnameOrTitle() + "(" + getUsername() + ")";
    }
}
