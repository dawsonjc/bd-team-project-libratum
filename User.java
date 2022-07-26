public class User {
    private String userName;
    private String password;
    private int id = 1;
    private String bio;
    private ArrayList<> posts;

    public User(String userName, String password, String bio) {
        this.userName = userName;
        this.password = password;
        this.id = count;
        this.bio = bio;

        count++;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public ArrayList<> getPosts() {
        return posts;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                ", bio='" + bio + '\'' +
                ", posts=" + posts +
                '}';
    }
}
