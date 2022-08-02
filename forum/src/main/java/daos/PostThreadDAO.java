package daos;


import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import models.PostThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostThreadDAO {

    private final DynamoDBMapper dynamoDbMapper;

    public PostThreadDAO(AmazonDynamoDB client) {
        this.dynamoDbMapper = new DynamoDBMapper(client);
    }

    // Create
    public PostThread savePostThread(PostThread postThread) {
        dynamoDbMapper.save(postThread);
        return postThread;
    }


    public PostThread findById(String id) {
        PostThread thread = null;
        try {
            thread = dynamoDbMapper.load(PostThread.class, id);
        } catch(Exception e) {
            return null;
        }
        return thread;
    }

    public List<PostThread> findAll() {
        return dynamoDbMapper.scan(PostThread.class, new DynamoDBScanExpression());
    }

    // Update
    public String update(String id, PostThread postThread) {
        dynamoDbMapper.save(postThread, new DynamoDBSaveExpression()
                .withExpectedEntry("id," ,
                        new ExpectedAttributeValue(
                                new AttributeValue().withS(id)
                        )));
        return "PostThread was updated";
    }

    // Delete

    public String deletePostThread(String id) {
        PostThread postThread = dynamoDbMapper.load(PostThread.class, id);
        dynamoDbMapper.delete(postThread);

        return "Deleted post-thread: " + id;
    }
}
