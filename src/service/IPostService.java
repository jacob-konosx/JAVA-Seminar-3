package service;

import model.post.PostType;

public interface IPostService {
    public abstract void publishPost(PostType type, String msg) throws Exception;
}
