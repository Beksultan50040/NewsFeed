package kz.dar.tech.dms.overview.news.api.models.companies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyInfo {
    private List<EntityOfCompanies> entities;
}
