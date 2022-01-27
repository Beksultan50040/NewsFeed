package kz.dar.tech.dms.overview.news.api.services;

import kz.dar.tech.dms.overview.news.api.models.ListOfPeople;

import java.util.List;

public interface ListOfEmployeesFromAllCompaniesService {
    public List<ListOfPeople> list(String birthDate);
}
