package models;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import models.converter.ListConverterForPost;
import models.converter.ListConverterForWine;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@DynamoDBTable(tableName = "user")
public class Users {

    @DynamoDBHashKey(attributeName = "user_id")
    @DynamoDBAutoGeneratedKey
    private String id;

    @DynamoDBAttribute
    private String username;
    @DynamoDBAttribute
    private String password;
    @DynamoDBAttribute
    private UserType type;
    @DynamoDBAttribute
    private String bio;
    @DynamoDBAttribute
    private List<Post> posts;
    @DynamoDBAttribute
    private List<Wine> favorites;

    public Users() {
    }

    public Users(String username, String password) {
        this.username = username;
        this.password = password;
        this.type = UserType.USER;
        this.bio = "";
        posts = new ArrayList<>();
        favorites = new ArrayList<>();
    }




    @DynamoDBHashKey
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    @DynamoDBAttribute
    @DynamoDBTypeConverted(converter = ListConverterForPost.class)
    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }

    @DynamoDBAttribute
    @DynamoDBTypeConverted(converter = ListConverterForWine.class)
    public List<Wine> getFavorites() {
        return favorites;
    }

    public void setFavorites(ArrayList<Wine> favorites) {
        this.favorites = favorites;
    }

    public boolean addToFavorites(Wine wine) {
      return favorites.add(wine);
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setType(UserType type) {
        this.type = type;
    }
    public void setBio(String bio) {
        this.bio = bio;
    }


    public String getUsername() {
        return this.username;
    }

    @DynamoDBAttribute
    public String getPassword() {
        return this.password;
    }
    public UserType getType() {
        return this.type;
    }
    public String getBio() {
        return this.bio;
    }

    @Override
    public String toString() {
        return "Users {" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", type=" + type +
                ", bio='" + bio + '\'' +
                ", posts=" + posts +
                ", favorites=" + favorites +
                '}';
    }
}
