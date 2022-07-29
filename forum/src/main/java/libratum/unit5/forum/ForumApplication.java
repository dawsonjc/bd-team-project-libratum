package libratum.unit5.forum;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import config.DynamoDBConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ForumApplication {

	private static AmazonDynamoDB db;


	public static void main(String[] args) {
		db = new DynamoDBConfig().amazonDynamoDB();
		SpringApplication.run(ForumApplication.class, args);
	}

	public static AmazonDynamoDB getDB() {
		return db;
	}
}
