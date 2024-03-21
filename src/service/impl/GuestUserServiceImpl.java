package service.impl;

import com.sun.tools.javac.Main;
import model.post.Post;
import model.user.*;
import service.IGuestUserService;
import service.MainService;

import java.util.ArrayList;

public class GuestUserServiceImpl implements IGuestUserService {

    @Override
    public ArrayList<User> findUsers(String nameOrSurnameOrTitle) throws Exception{
        if (nameOrSurnameOrTitle == null || nameOrSurnameOrTitle.length() < 2){
            throw new Exception("Invalid input arguments");
        }
        ArrayList<User> foundUsers = new ArrayList<User>();
        for (GuestUser tempU: MainService.allUsers){
            if (tempU instanceof PrivateUser || tempU instanceof BusinessUser){
                User user = (User) tempU;
                if (user.getNameAndSurnameOrTitle().toLowerCase().contains(nameOrSurnameOrTitle.toLowerCase())){
                    foundUsers.add(user);
                }
            }
        }
        return foundUsers;
    }

    @Override
    public ArrayList<Page> findPages(String titleOrDescription) throws Exception{
        if (titleOrDescription == null || titleOrDescription.length() < 2){
            throw new Exception("Invalid input arguments");
        }

        ArrayList<Page> foundPages = new ArrayList<Page>();
        for (GuestUser tempU: MainService.allUsers){
            if (tempU instanceof BusinessUser businessUser){
                for (Page tempP: businessUser.getListOfPages()){
                    if (tempP.getTitle().toLowerCase().contains(titleOrDescription.toLowerCase()) || tempP.getDescription().toLowerCase().contains(titleOrDescription.toLowerCase())){
                        foundPages.add(tempP);
                    }
                }
            }
        }
        return foundPages;
    }

    @Override
    public ArrayList<Post> findInfoInPublicPosts(String msg) throws Exception{
        if (msg == null || msg.length() < 2){
            throw new Exception("Invalid input arguments");
        }
        ArrayList<Post> foundPosts = new ArrayList<Post>();
        for (GuestUser tempU: MainService.allUsers){
            if (tempU instanceof PrivateUser privateUser){
                for (Post tempP: privateUser.getPublicPosts()){
                    if (tempP.getMsg().toLowerCase().contains(msg.toLowerCase())){
                        foundPosts.add(tempP);
                    }
                }
            } else if (tempU instanceof BusinessUser businessUser) {
                for (Page tempPage: businessUser.getListOfPages()){
                    for (Post tempP: tempPage.getPostsInPage()){
                        if (tempP.getMsg().toLowerCase().contains(msg.toLowerCase())){
                            foundPosts.add(tempP);
                        }
                    }
                }
            }
        }
        return foundPosts;
    }
}
