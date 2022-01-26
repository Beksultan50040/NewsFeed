package kz.dar.tech.dms.overview.news.api.services;

import kz.dar.tech.dms.overview.news.api.feign.CompaniesFeign;
import kz.dar.tech.dms.overview.news.api.feign.EmployeesFeign;
import kz.dar.tech.dms.overview.news.api.models.EmployeeInfo;
import kz.dar.tech.dms.overview.news.api.models.ListOfPeople;
import kz.dar.tech.dms.overview.news.api.models.companies.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class TestService {

    @Autowired
    private CompaniesFeign companiesFeign;

    @Autowired
    private EmployeesFeign employeesFeign;

    @Autowired
    private ListOfEmployeesService listOfEmployeesService;

    @Value("${api.key.prod}")
    String apiKey;

    String birthDateSearchType = "expression";

    String birthDate = "*-01-01";

     public List<ListOfPeople> list(){

          Root root = companiesFeign.companiesInfo();

         List<String> idCollect = new ArrayList<>();

        List<EmployeeInfo> employeeInfoList = new ArrayList<>();

        List<ListOfPeople> listOfPeople = new ArrayList<>();


        for (int i=0; i<root.getEntities().size(); i++){

            idCollect.add(root.getEntities().get(i).getId());
        }

        for (int i=0; i<idCollect.size(); i++){
            String id = idCollect.get(i);
            EmployeeInfo employeeInfo = employeesFeign.info( apiKey, id, birthDate, birthDateSearchType);
            employeeInfoList.add(employeeInfo);
            listOfPeople = listOfEmployeesService.creationOfEmployees(employeeInfoList.get(i));
        }

         return Stream.of(listOfPeople)
                 .flatMap(Collection::stream)
                 .collect(Collectors.toList());
    }



}
