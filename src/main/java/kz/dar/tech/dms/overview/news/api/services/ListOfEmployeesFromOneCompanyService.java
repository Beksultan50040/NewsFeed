package kz.dar.tech.dms.overview.news.api.services;

import kz.dar.tech.dms.overview.news.api.models.employees.EmployeeInfo;
import kz.dar.tech.dms.overview.news.api.models.ListOfPeople;

import java.util.List;

public interface ListOfEmployeesFromOneCompanyService {

    List<ListOfPeople> creationOfEmployees(EmployeeInfo employeeInfo);
}
