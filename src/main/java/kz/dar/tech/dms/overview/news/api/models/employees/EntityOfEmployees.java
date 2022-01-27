package kz.dar.tech.dms.overview.news.api.models.employees;


import lombok.Data;

@Data
public class EntityOfEmployees {
    private String id;
    private Name name;
    private NameRu nameRu;
    private String position;
    private String managerId;
    private String photo;
    private String email;
    private String companyId;
    private String companyName;
}
