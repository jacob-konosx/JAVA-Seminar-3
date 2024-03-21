package service;

import model.post.Post;
import model.user.Page;
import model.user.User;

import java.util.ArrayList;

public interface IGuestUserService {
    public abstract ArrayList<User> findUsers(String nameOrSurnameOrTitle) throws Exception;
    public abstract ArrayList<Page> findPages(String titleOrDescription) throws Exception;
    public abstract ArrayList<Post> findInfoInPublicPosts(String msg) throws Exception;
}
