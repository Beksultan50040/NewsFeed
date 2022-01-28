package kz.dar.tech.dms.overview.news.api.models.companies;

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
@Document(indexName = "dms-news-feed-companies", createIndex = true)
public class CompanyInfo {

    @Field(type = FieldType.Auto)
    private String id;

    @Field(type = FieldType.Nested, includeInParent = true)
    private List<EntityOfCompanies> entities;
}
