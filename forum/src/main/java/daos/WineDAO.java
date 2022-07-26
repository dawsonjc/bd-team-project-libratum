package daos;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import models.Users;
import models.Wine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WineDAO {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;


    // Create
    public Wine saveWine(Wine wine) {
        dynamoDBMapper.save(wine);
        return wine;
    }

    // Read

    public Wine findById(String id) {
        return dynamoDBMapper.load(Wine.class, id);
    }

    public List<Wine> findALL() {
        return dynamoDBMapper.scan(Wine.class, new DynamoDBScanExpression());
    }

    // Update
    public String update(String id, Wine wine) {
        dynamoDBMapper.save(wine, new DynamoDBSaveExpression()
                .withExpectedEntry("id",
                        new ExpectedAttributeValue(
                                new AttributeValue().withS(id)
                        )));
        return "User was updated";
    }


    // Delete

    public String delete(String id) {
        Wine wine = dynamoDBMapper.load(Wine.class, id);
        dynamoDBMapper.delete(wine);

        return "Deleted wine: " + id;
    }

}

