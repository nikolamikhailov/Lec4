package com.l4gunner4l.reader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.l4gunner4l.model.Employee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class JsonEmployeeReader implements EmployeeReader {
    public JsonEmployeeReader() {
    }

    @Override
    public ArrayList<Employee> readEmployees(String path) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) (new URL(path)).openConnection();
        StringBuilder json = readJson(httpURLConnection);
        return convertFromJsonToEmployees(json);
    }

    private StringBuilder readJson(HttpURLConnection httpURLConnection) throws IOException {
        StringBuilder json = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null && !line.isEmpty()) {
            json.append(line).append("\n");
        }
        return json;
    }

    private ArrayList<Employee> convertFromJsonToEmployees(StringBuilder json) {
        Gson gson = new GsonBuilder().registerTypeAdapter(Employee.class, new EmployeeDeserializer()).create();
        Type type = new TypeToken<ArrayList<Employee>>() {
        }.getType();
        ArrayList<Employee> employees = gson.fromJson(json.toString(), type);
        return employees;
    }
}
