package com.example.demo;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.commons.httpclient.OkHttpClientFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class Vaccine {
    @Autowired
    CowinApi cowinApi;
    public Vaccine() {
    }

    @PostConstruct
    public void makecalls(){
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
            .url("https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/calendarByDistrict?district_id=294&date=10-05-2021")
            .method("GET", null)
            .build();
        try {
            Response response = client.newCall(request).execute();
            System.out.println(response);
            System.out.println(response.body().string());
        } catch (IOException e) {
            System.out.println("Exception : "+e);
        }
        try {
            System.out.println("feign :");
            System.out.println(cowinApi.getByDate("294",DateTimeFormatter.ofPattern("dd-MM-yyyy").format(now)));
        }
        catch (Exception e){
            System.out.println("Exception : "+e);
        }

    }
}
