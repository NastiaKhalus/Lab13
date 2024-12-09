package ua.edu.ucu.apps.task3;

import org.json.JSONObject;
import lombok.SneakyThrows;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class PDLReader {
    @SneakyThrows
    public Company fetch(String companyName){

        String API_KEY = "0b5XAqtIORRARRHF/kEUWCmTm6cx0lgePJPCBLz5szE=";
        @SuppressWarnings("deprecation")
        URL url = new URL("https://api.peopledatalabs.com/v5/company/enrich?website=ucu.edu.ua");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("X-Api-Key", API_KEY);
        connection.connect();
        String text = new Scanner(connection.getInputStream()).useDelimiter("\\Z").next();
        JSONObject jsonObject = new JSONObject(text);
        System.out.println(jsonObject);
        return new Company();
    }}

