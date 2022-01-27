package kz.dar.tech.dms.overview.news.api.models.companies;

import lombok.Data;

import java.util.Date;

@Data
public class EntityOfCompanies {
    private String id;
    private String name;
    private String shortName;
    private String bin;
    private Boolean isHolding;
    private Date createdAt;
    private String country;
    private Parent parent;
    private Holding holding;
    private String dateOfRegistration;
}
