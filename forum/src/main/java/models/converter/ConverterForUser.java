package models.converter;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import models.Users;

import java.util.ArrayList;


public class ConverterForUser implements DynamoDBTypeConverter<String, Users> {
    private static final Gson GSON = new Gson();

    @Override
    public String convert(Users object) {
        return GSON.toJson(object);
    }

    @Override
    public Users unconvert(String object) {
        return GSON.fromJson(object, new TypeToken<ArrayList<Users>>() { } .getType());
    }
}
