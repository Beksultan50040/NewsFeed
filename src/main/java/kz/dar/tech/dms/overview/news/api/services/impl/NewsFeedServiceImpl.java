package kz.dar.tech.dms.overview.news.api.services.impl;

import kz.dar.tech.dms.overview.news.api.feign.EmployeesFeign;
import kz.dar.tech.dms.overview.news.api.models.employees.EmployeeInfo;
import kz.dar.tech.dms.overview.news.api.models.NewsFeedModel;
import kz.dar.tech.dms.overview.news.api.services.ListOfEmployeesFromAllCompaniesService;
import kz.dar.tech.dms.overview.news.api.services.ListOfEmployeesFromOneCompanyService;
import kz.dar.tech.dms.overview.news.api.services.NewsFeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class NewsFeedServiceImpl implements NewsFeedService {

    @Autowired
    private EmployeesFeign feign;

    @Autowired
    private ListOfEmployeesFromOneCompanyService listOfEmployeesFromOneCompanyService;

    @Autowired
    private ListOfEmployeesFromAllCompaniesService listOfEmployeesFromAllCompaniesService;


    @Override
    public EmployeeInfo save() {
        return null;
    }

    @Override
    public NewsFeedModel findAll(String birthDate) {

        if (birthDate==null){
            LocalDate date = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("*-MM-dd");
            birthDate = date.format(formatter);
        }

        NewsFeedModel newsFeedModel = new NewsFeedModel();
        newsFeedModel.setId("TestId");
        newsFeedModel.setDate(LocalDate.now());
        newsFeedModel.setLogoUrl("TestLogo");
        newsFeedModel.setPrimaryText("Happy Birthday!");
        newsFeedModel.setListOfPeople(listOfEmployeesFromAllCompaniesService.createNews(birthDate));
        newsFeedModel.setSecondaryText("Dear Friends!");
        newsFeedModel.setImageURL("TestURL");

        return newsFeedModel;

//        listOfEmployeesFromAllCompaniesService.list(birthDate);


    }

    @Override
    public java.lang.String deleteAll() {
        return null;
    }

}
