package kz.dar.tech.dms.overview.news.api.services.impl;

import kz.dar.tech.dms.overview.news.api.DAO.CompaniesRepo;
import kz.dar.tech.dms.overview.news.api.DAO.EmployeesRepo;
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
import java.util.stream.StreamSupport;

@Service
public class ListOfEmployeesFromAllCompaniesServiceImpl implements ListOfEmployeesFromAllCompaniesService {

    @Autowired
    private CompaniesFeign companiesFeign;

    @Autowired
    private EmployeesFeign employeesFeign;

    @Autowired
    private ListOfEmployeesFromOneCompanyService listOfEmployeesFromOneCompanyService;

    @Autowired
    private CompaniesRepo companiesRepo;

    @Autowired
    private EmployeesRepo employeesRepo;


    @Value("${api.key.prod}")
    String apiKey;

    String birthDateSearchType = null;

    String birthDate = null;

    String limit = "500";

    List<String> idCollect = new ArrayList<>();

    List<EmployeeInfo> employeeInfoList = new ArrayList<>();

    List<ListOfPeople> listOfPeople = new ArrayList<>();

    @Override
    public CompanyInfo companyInfo() {
        return companiesRepo.save(companiesFeign.companiesInfo());
    }

    @Override
    public String saveEmployeesInfo() {

        CompanyInfo companyInfo = companiesFeign.companiesInfo();

        for (int i = 0; i < companyInfo.getEntities().size(); i++){

            idCollect.add(companyInfo.getEntities().get(i).getId());
        }

        for (int i = 0; i < idCollect.size(); i++){
            String id = idCollect.get(i);
            EmployeeInfo employeeInfo = employeesFeign.info(apiKey, id, birthDate, birthDateSearchType ,limit);
            employeeInfoList.add(employeeInfo);
        }
        employeesRepo.saveAll(employeeInfoList);

        return "ok";
    }

    @Override
    public String deleteAllEmpInfo() {
        employeesRepo.deleteAll();
        return "deleted";
    }

    @Override
    public List<ListOfPeople> createNews(String birthDate) {

        CompanyInfo companyInfo = companiesFeign.companiesInfo();
        for (int i = 0; i < companyInfo.getEntities().size(); i++){

            idCollect.add(companyInfo.getEntities().get(i).getId());
        }
        for (int i = 0; i < idCollect.size(); i++){

            Iterable<EmployeeInfo> iterable = employeesRepo.findAll();
            List<EmployeeInfo> result =
                    StreamSupport.stream(iterable.spliterator(), false)
                            .collect(Collectors.toList());

           listOfPeople.addAll(listOfEmployeesFromOneCompanyService.creationOfEmployees(result.get(i)));
        }
                return Stream.of(listOfPeople)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }


}
