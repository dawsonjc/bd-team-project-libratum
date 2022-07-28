package daos;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class PostDAO {
    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    // Create
    public Post savePost(Post post) {
        dynamoDBMapper.save(post);
        return post;
    }

    // Read

    public Post findById(String id) {
        return dynamoDBMapper.load(Post.class, id);
    }

    public List<Post> findAll() {
        return dynamoDBMapper.scan(Post.class, new DynamoDBScanExpression());
    }

    // Update
    public String updatePost(String id, Post post) {
        dynamoDBMapper.save(post, new DynamoDBSaveExpression()
                .withExpectedEntry("id",
                        new ExpectedAttributeValue(
                                new AttributeValue().withS(id)
                        )));
        return "Post was updated";
    }

    // Delete

    public String delete(String id) {
        Post post = this.dynamoDBMapper.load(Post.class, id);
        dynamoDBMapper.delete(post);

        return "Deleted post: " + id;
    }


}
