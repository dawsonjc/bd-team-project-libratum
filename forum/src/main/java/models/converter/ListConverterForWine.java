package models.converter;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import models.Wine;

import java.util.ArrayList;
import java.util.List;

public class ListConverterForWine implements DynamoDBTypeConverter<String, List> {
    private static final Gson GSON = new Gson();

    @Override
    public String convert(List object) {
        return GSON.toJson(object);
    }

    @Override
    public List unconvert(String object) {
        return GSON.fromJson(object, new TypeToken<ArrayList<Wine>>() { } .getType());
    }
}
