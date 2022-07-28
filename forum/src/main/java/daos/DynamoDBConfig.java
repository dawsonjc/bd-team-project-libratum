package daos;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

@Configuration
public class DynamoDBConfig {

    @Bean
    public AmazonDynamoDB amazonDynamoDB() {
        AmazonDynamoDB amazonDynamoDB = AmazonDynamoDBClient.builder()
                .withCredentials(
                        new AWSStaticCredentialsProvider(
                                amazonAWSCredentials()
                        )
                )
                .withEndpointConfiguration(
                        new AwsClientBuilder.EndpointConfiguration(
                                "http://localhost:8080/",
                                Regions.US_WEST_2.toString()
                        )
                )
                .build();

        return amazonDynamoDB;
    }
    @Bean
    public AWSCredentials amazonAWSCredentials() {
        return new BasicAWSCredentials("AKIAYTX36AEUVYU65M72", "0Iu2j2t7wlV/xQyqWyiCcPu0IpsACR9PYymUxGPU");
    }

}
