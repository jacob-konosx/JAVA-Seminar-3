package service;

import model.post.PostType;
import model.user.*;

import java.util.ArrayList;
import java.util.Arrays;

public class MainService {
    public static ArrayList<GuestUser> allUsers = new ArrayList<GuestUser>();

    public static void main(String[] args){
        GuestUser u1 = new GuestUser();
        GuestUser u2 = new GuestUser();
        PrivateUser u3 = new PrivateUser();
        GuestUser u4 = new GuestUser();
        BusinessUser u5 = new BusinessUser();
        PrivateUser u6 = new PrivateUser("Jekabs", "Konosonoks", "STIPRAPAROLE");
        BusinessUser u7  = new BusinessUser("SIA Hesburger", "12345678He", "LV12345678909");
        allUsers.addAll(Arrays.asList(u1, u2, u3, u4, u5, u6, u7));

        for (GuestUser user: allUsers){
            System.out.println(user);
        }
        try {
            u6.publishPost(PostType.privatePost, "Man nekas nepatīk!");
            u6.publishPost(PostType.publicPost, "Man viss patīk!");
            u6.publishPost(PostType.publicPost, "Žēl, ka šodien nav piektdiena!");

            u6.followPrivateUser(u3);
            u6.followPrivateUser(u7);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        System.out.println("---------------------------------------");
        System.out.println(u6.getUsername() + ": private posts ->");
        System.out.println(u6.getPrivatePosts());
        System.out.println();

        System.out.println(u6.getUsername() + ": public posts ->");
        System.out.println(u6.getPublicPosts());
        System.out.println();

        System.out.println(u6.getUsername() + ": followers ->");
        System.out.println(u6.getFollowers());
        System.out.println();

        try{
            u7.createPage("Hesburger Ventspils", "Jaunumi par hesburger ventspils");
            u7.publishPostInPage("Hesburger Ventspils", "LIELA ATLAIDE PUIKAS");
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("---------------------------------------");
        System.out.println(u7.getUsername() + ": pages ->");
        for (Page tempP: u7.getListOfPages()){
            System.out.println(tempP + "-->");
            System.out.println(tempP.getPostsInPage());
            System.out.println();
        }

        System.out.println("Search->");
        try {
            System.out.println(u7.service.findUsers("Hesb"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
