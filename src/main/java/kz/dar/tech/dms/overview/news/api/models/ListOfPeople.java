package kz.dar.tech.dms.overview.news.api.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListOfPeople {

    private String nameEng;
    private String nameRu;
    private String jobTitle;
}
