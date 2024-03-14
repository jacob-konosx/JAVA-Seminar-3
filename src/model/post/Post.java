package model.post;

import java.time.LocalDateTime;

public class Post {
    private String msg;
    private LocalDateTime dateTime;
    private int countOfLikes = 0;

    public Post() {
        setMsg("Test MSG");
        setDateTime();
    }

    public Post(String msg) {
        setMsg(msg);
        setDateTime();
        setCountOfLikes();
    }



    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        if (msg!=null || (msg.length() > 5 && msg.length() < 300))
            this.msg = msg;
        else
            this.msg = "---------";
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime() {
        this.dateTime = LocalDateTime.now();
    }

    public int getCountOfLikes() {
        return countOfLikes;
    }

    public void setCountOfLikes() {
        this.countOfLikes++;
    }

    @Override
    public String toString() {
        return
                "msg= " + msg +
                ", date= " + dateTime +
                ", countOfLikes= " + countOfLikes;
    }
}
