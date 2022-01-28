package kz.dar.tech.dms.overview.news.api.models.companies;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDate;
import java.util.Date;

@Data
public class EntityOfCompanies {

    private String id;

    @Field(type = FieldType.Nested, includeInParent = true )
    private Parent parent;

    @Field(type = FieldType.Nested, includeInParent = true)
    private Holding holding;

    private String name;


    private String shortName;


    private String bin;


    private Boolean isHolding;

    @Field(type = FieldType.Date)
    private Date createdAt;


    private String country;

    @Field(type = FieldType.Auto)
    private LocalDate dateOfRegistration;


}
