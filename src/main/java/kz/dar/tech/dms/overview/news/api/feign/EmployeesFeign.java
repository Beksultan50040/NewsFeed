package kz.dar.tech.dms.overview.news.api.feign;


import kz.dar.tech.dms.overview.news.api.models.employees.EmployeeInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@FeignClient( name = "dms", url = "https://dms.dar.io/api/v1/hcms")
public interface EmployeesFeign {

    LocalDate date = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("*-MM-dd");
    String birthDate = date.format(formatter);


    @GetMapping(value = "/integration-api/employees/shortinfo")
    EmployeeInfo info(
            @RequestHeader("Api-Key") String apiKey,
            @RequestParam String companyId, @RequestParam String birthDate,
            @RequestParam (defaultValue = "expression") String birthDateSearchType
    );
}
