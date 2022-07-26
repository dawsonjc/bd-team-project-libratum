package daos;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UsersDAO {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;


    // Create
    public Users saveUser(Users user) {
        dynamoDBMapper.save(user);
        return user;
    }

    // Read

    public Users findById(String id) {
        return dynamoDBMapper.load(Users.class, id);
    }

    public List<Users> findALL() {
        return dynamoDBMapper.scan(Users.class, new DynamoDBScanExpression());
    }

    // Update
    public String update(String id, Users user) {
        dynamoDBMapper.save(user, new DynamoDBSaveExpression()
                .withExpectedEntry("id",
                        new ExpectedAttributeValue(
                                new AttributeValue().withS(id)
                        )));
        return "User was updated";
    }


    // Delete

    public String delete(String id) {
        Users user = dynamoDBMapper.load(Users.class, id);
        dynamoDBMapper.delete(user);

        return "Deleted user: " + id;
    }

}

