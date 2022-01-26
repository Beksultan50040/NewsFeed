package kz.dar.tech.dms.overview.news.api.services;

import kz.dar.tech.dms.overview.news.api.models.EmployeeInfo;
import kz.dar.tech.dms.overview.news.api.models.ListOfPeople;
import kz.dar.tech.dms.overview.news.api.models.NewsFeedModel;

import java.util.List;

public interface NewsFeedService {

    EmployeeInfo save();

    NewsFeedModel findAll();

    String deleteAll();

}
