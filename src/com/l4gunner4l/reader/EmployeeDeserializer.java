package com.l4gunner4l.reader;

import com.google.gson.*;
import com.l4gunner4l.model.AverageEmployee;
import com.l4gunner4l.model.Employee;
import com.l4gunner4l.model.HourEmployee;

import java.lang.reflect.Type;

public class EmployeeDeserializer implements JsonDeserializer<Employee> {

    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PAY = "pay";
    private static final String KEY_TYPE = "type";

    public EmployeeDeserializer() {
    }

    public Employee deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        switch (jsonObject.get(KEY_TYPE).getAsString()) {
            case AverageEmployee.CLASS:
                return new AverageEmployee(
                        jsonObject.get(KEY_ID).getAsLong(),
                        jsonObject.get(KEY_NAME).getAsString(),
                        jsonObject.get(KEY_PAY).getAsDouble()
                );
            case HourEmployee.CLASS:
                return new HourEmployee(
                        jsonObject.get(KEY_ID).getAsLong(),
                        jsonObject.get(KEY_NAME).getAsString(),
                        jsonObject.get(KEY_PAY).getAsDouble()
                );
        }
        throw new JsonParseException("Not found class " + jsonObject.get(KEY_TYPE).getAsString());
    }
}