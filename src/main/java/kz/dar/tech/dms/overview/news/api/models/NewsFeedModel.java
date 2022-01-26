package kz.dar.tech.dms.overview.news.api.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsFeedModel {

    private String id;
    private LocalDate date;
    private String logoUrl;
    private String primaryText;
    private List<ListOfPeople> listOfPeople;
    private String secondaryText;
    private String imageURL;


}
