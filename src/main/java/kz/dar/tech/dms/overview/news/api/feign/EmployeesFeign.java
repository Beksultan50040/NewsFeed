package kz.dar.tech.dms.overview.news.api.feign;


import kz.dar.tech.dms.overview.news.api.models.EmployeeInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient( name = "dms", url = "https://dms.dar.io/api/v1/hcms")
public interface EmployeesFeign {


    @GetMapping(value = "/integration-api/employees/shortinfo")
    EmployeeInfo info(
            @RequestHeader("Api-Key") String apiKey,
            @RequestParam String companyId, @RequestParam (required = false) String birthDate,
            @RequestParam (defaultValue = "expression") String birthDateSearchType
    );
}
