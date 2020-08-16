package com.l4gunner4l.reader;

import com.google.gson.*;
import com.l4gunner4l.model.AverageEmployee;
import com.l4gunner4l.model.Employee;
import com.l4gunner4l.model.HourEmployee;

import java.lang.reflect.Type;

import static com.l4gunner4l.model.Employee.*;

public class EmployeeDeserializer implements JsonDeserializer<Employee> {
    public EmployeeDeserializer() {
    }

    public Employee deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        switch (jsonObject.get(KEY_TYPE).getAsString()) {
            case AverageEmployee.TYPE:
                return new AverageEmployee(
                        jsonObject.get(KEY_ID).getAsLong(),
                        jsonObject.get(KEY_NAME).getAsString(),
                        jsonObject.get(KEY_PAY).getAsDouble()
                );
            case HourEmployee.TYPE:
                return new HourEmployee(
                        jsonObject.get(KEY_ID).getAsLong(),
                        jsonObject.get(KEY_NAME).getAsString(),
                        jsonObject.get(KEY_PAY).getAsDouble()
                );
            default:
                return null;
        }
    }
}