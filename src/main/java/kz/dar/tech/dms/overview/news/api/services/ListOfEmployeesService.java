package kz.dar.tech.dms.overview.news.api.services;

import kz.dar.tech.dms.overview.news.api.models.EmployeeInfo;
import kz.dar.tech.dms.overview.news.api.models.ListOfPeople;

import java.util.List;

public interface ListOfEmployeesService {

    List<ListOfPeople> creationOfEmployees(EmployeeInfo employeeInfo);
}
