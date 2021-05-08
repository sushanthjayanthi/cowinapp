package com.example.demo;

import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.websocket.server.PathParam;
import java.time.ZonedDateTime;

@FeignClient(value = "jplaceholder", url = "https://cdn-api.co-vin.in/api/v2/appointment/sessions/public")
public interface CowinApi {
    @Headers({"accept:application/json","Accept-Language: hi_IN"})
    @GetMapping(value = "/calendarByDistrict")
    String getByDate(@RequestParam("district_id") String districtId,@RequestParam("date") String date);
}
