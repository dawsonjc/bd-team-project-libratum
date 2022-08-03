package models.converter;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import models.PostThread;
import models.Users;

import java.util.ArrayList;


public class ConverterForPostThread implements DynamoDBTypeConverter<String, PostThread> {
    private static final Gson GSON = new Gson();

    @Override
    public String convert(PostThread object) {
        return GSON.toJson(object);
    }

    @Override
    public PostThread unconvert(String object) {
        return GSON.fromJson(object, new TypeToken<ArrayList<PostThread>>() { } .getType());
    }
}
