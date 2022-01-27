package kz.dar.tech.dms.overview.news.api.feign;

import kz.dar.tech.dms.overview.news.api.models.companies.CompanyInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "company", url = "https://dms.dar.io/api/v1/hcms")
public interface CompaniesFeign {

    @GetMapping(value = "/companies")
    CompanyInfo companiesInfo();

}
