package kz.dar.tech.dms.overview.news.api.models.companies;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
public class Parent {


    private String id;

    private String name;

    private String shortName;

    private String bin;
}
