package kz.dar.tech.dms.overview.news.api.services;

import kz.dar.tech.dms.overview.news.api.models.ListOfPeople;
import kz.dar.tech.dms.overview.news.api.models.companies.CompanyInfo;

import java.util.List;

public interface ListOfEmployeesFromAllCompaniesService {

  //  String list(java.lang.String birthDate);

    CompanyInfo companyInfo();

    String saveEmployeesInfo();

    String deleteAllEmpInfo();

    List<ListOfPeople> createNews(String birthDate);

}
