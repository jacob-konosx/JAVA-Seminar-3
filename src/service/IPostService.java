package service;

import model.post.Post;
import model.post.PostType;

public interface IPostService {
    public abstract Post publishPost(PostType type, String msg) throws Exception;
}
