package kz.dar.tech.dms.overview.news.api.services;

import kz.dar.tech.dms.overview.news.api.models.employees.EmployeeInfo;
import kz.dar.tech.dms.overview.news.api.models.employees.NewsFeedModel;

public interface NewsFeedService {

    EmployeeInfo save();

    NewsFeedModel findAll(String birthDate);

    String deleteAll();

}
