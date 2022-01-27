package kz.dar.tech.dms.overview.news.api.services.impl;

import kz.dar.tech.dms.overview.news.api.feign.CompaniesFeign;
import kz.dar.tech.dms.overview.news.api.feign.EmployeesFeign;
import kz.dar.tech.dms.overview.news.api.models.employees.EmployeeInfo;
import kz.dar.tech.dms.overview.news.api.models.ListOfPeople;
import kz.dar.tech.dms.overview.news.api.models.companies.CompanyInfo;
import kz.dar.tech.dms.overview.news.api.services.ListOfEmployeesFromAllCompaniesService;
import kz.dar.tech.dms.overview.news.api.services.ListOfEmployeesFromOneCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ListOfEmployeesFromAllCompaniesServiceImpl implements ListOfEmployeesFromAllCompaniesService {

    @Autowired
    private CompaniesFeign companiesFeign;

    @Autowired
    private EmployeesFeign employeesFeign;

    @Autowired
    private ListOfEmployeesFromOneCompanyService listOfEmployeesFromOneCompanyService;

    @Value("${api.key.prod}")
    String apiKey;

    String birthDateSearchType = "expression";

//    String birthDate = "*-01-26";

    @Override
    public List<ListOfPeople> list(String birthDate) {
        CompanyInfo companyInfo = companiesFeign.companiesInfo();

        List<String> idCollect = new ArrayList<>();

        List<EmployeeInfo> employeeInfoList = new ArrayList<>();

        List<ListOfPeople> listOfPeople = new ArrayList<>();


        for (int i = 0; i < companyInfo.getEntities().size(); i++){

            idCollect.add(companyInfo.getEntities().get(i).getId());
        }

        for (int i = 0; i < idCollect.size(); i++){
            String id = idCollect.get(i);
            EmployeeInfo employeeInfo = employeesFeign.info( apiKey, id, birthDate, birthDateSearchType);
            employeeInfoList.add(employeeInfo);
            listOfPeople.addAll(listOfEmployeesFromOneCompanyService.creationOfEmployees(employeeInfoList.get(i)));
        }

        return Stream.of(listOfPeople)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }


}
