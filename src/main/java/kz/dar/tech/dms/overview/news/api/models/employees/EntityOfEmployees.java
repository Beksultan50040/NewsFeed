package kz.dar.tech.dms.overview.news.api.models.employees;


import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
public class EntityOfEmployees {
    private String id;
    @Field(type = FieldType.Nested, includeInParent = true)
    private Name name;
    @Field(type = FieldType.Nested, includeInParent = true)
    private NameRu nameRu;
    private String position;
    private String managerId;
    private String photo;
    private String email;
    private String companyId;
    private String companyName;
}
