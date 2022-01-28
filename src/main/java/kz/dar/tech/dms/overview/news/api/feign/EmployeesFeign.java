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
    java.lang.String birthDate = date.format(formatter);


    @GetMapping(value = "/integration-api/employees/shortinfo")
    EmployeeInfo info(
            @RequestHeader("Api-Key") java.lang.String apiKey,
            @RequestParam java.lang.String companyId, @RequestParam (required = false) java.lang.String birthDate,
            @RequestParam  (required = false) /*(defaultValue = "expression")*/ java.lang.String birthDateSearchType,
            @RequestParam (defaultValue = "500") java.lang.String limit
    );
}
