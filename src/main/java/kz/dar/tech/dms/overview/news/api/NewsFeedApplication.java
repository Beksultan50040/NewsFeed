package kz.dar.tech.dms.overview.news.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
@EnableFeignClients
public class NewsFeedApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewsFeedApplication.class, args);

        LocalDate dateObj = LocalDate.now();

        System.out.println(dateObj);
    }


}
