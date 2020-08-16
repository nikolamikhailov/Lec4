package com.l4gunner4l.reader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.l4gunner4l.base.BaseEmployeeReader;
import com.l4gunner4l.model.Employee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class JsonEmployeeReader extends BaseEmployeeReader {
    public JsonEmployeeReader() {
    }

    public ArrayList<Employee> readEmployees(String path) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) (new URL(path)).openConnection();
            StringBuilder json = readJson(httpURLConnection);
            if (json == null) return null;
            return convertFromJsonToEmployees(json);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private StringBuilder readJson(HttpURLConnection httpURLConnection) {
        StringBuilder json = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null && !line.isEmpty()) {
                json.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return json;
    }

    private ArrayList<Employee> convertFromJsonToEmployees(StringBuilder json) {
        Gson gson = new GsonBuilder().registerTypeAdapter(Employee.class, new EmployeeDeserializer()).create();
        Type type = new TypeToken<ArrayList<Employee>>() {
        }.getType();
        return gson.fromJson(json.toString(), type);
    }
}
