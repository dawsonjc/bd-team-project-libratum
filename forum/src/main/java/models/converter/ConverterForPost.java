package models.converter;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import models.Post;
import models.Users;

import java.util.ArrayList;


public class ConverterForPost implements DynamoDBTypeConverter<String, Post> {
    private static final Gson GSON = new Gson();

    @Override
    public String convert(Post object) {
        return GSON.toJson(object);
    }

    @Override
    public Post unconvert(String object) {
        return GSON.fromJson(object, new TypeToken<ArrayList<Users>>() { } .getType());
    }
}

