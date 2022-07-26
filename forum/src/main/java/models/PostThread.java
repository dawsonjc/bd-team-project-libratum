package models;

import java.util.ArrayList;

public class PostThread {
    private String id;
    private String title;
    private ArrayList<Post> posts;

    public PostThread(String id, String title, ArrayList<Post> posts) {
        this.id = id;
        this.title = title;
        this.posts = posts;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }

    public void addPost(Post post) {
        posts.add(post);
    }

    public Post getPost(int index) {
       return posts.get(index);
    }

    @Override
    public String toString() {
        return "PostThread{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", posts=" + posts +
                '}';
    }
}
