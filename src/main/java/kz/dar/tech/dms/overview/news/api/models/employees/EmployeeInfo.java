package kz.dar.tech.dms.overview.news.api.models.employees;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "dms-news-feed-employees", createIndex = true)
public class EmployeeInfo {

        @Field(type = FieldType.Auto)
        private String id;

        private int total;

        @Field(type = FieldType.Nested, includeInParent = true)
        private List<EntityOfEmployees> entities;



}
