package kz.dar.tech.dms.overview.news.api.services.impl;

import kz.dar.tech.dms.overview.news.api.feign.EmployeesFeign;
import kz.dar.tech.dms.overview.news.api.models.EmployeeInfo;
import kz.dar.tech.dms.overview.news.api.models.ListOfPeople;
import kz.dar.tech.dms.overview.news.api.models.NewsFeedModel;
import kz.dar.tech.dms.overview.news.api.services.ListOfEmployeesService;
import kz.dar.tech.dms.overview.news.api.services.NewsFeedService;
import kz.dar.tech.dms.overview.news.api.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class NewsFeedServiceImpl implements NewsFeedService {

    @Autowired
    private EmployeesFeign feign;

    @Autowired
    private ListOfEmployeesService listOfEmployeesService;

    @Autowired
    private TestService testService;

    @Value("${api.key.prod}")
    String apiKey;

    @Value("${company.id.dar}")
    String darId;

    @Value("${company.id.dar.tech}")
    String darTechId;

    @Value("${company.id.dar.play}")
    String darPlayId;

    @Value("${company.id.dar.academy}")
    String darAcademyId;

    @Value("${company.id.dar.animation}")
    String darAnimationId;

    @Value("${company.id.fin.tech}")
    String darFinTechId;

    @Value("${company.id.dar.security}")
    String darSecurityId;

    @Value("${company.id.dar.sport}")
    String darSportId;

    @Value("${company.id.dar.naiza}")
    String darNaizaId;

    @Value("${company.id.dar.team}")
    String darTeamId;

    @Value("${company.id.5q}")
    String dar5qId;

    @Value("${company.id.dar.lab}")
    String darLabId;

    @Value("${company.id.dar.global}")
    String darGlobalId;

    @Value("${company.id.dar.tech.ru}")
    String darTechRuId;



//    LocalDate date = LocalDate.now();
//    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("*-MM-dd");
//    String birthDate = date.format(formatter);

    String birthDateSearchType = "expression";

    String birthDate = "*-01-01";

    @Override
    public EmployeeInfo save() {
        return null;
    }



//    String companyId2= "f01a53da-96f8-4085-bc34-472a6f78b3f3";
    String birthDate2 = "*-03-17";

    @Override
    public NewsFeedModel findAll() {
//        EmployeeInfo employeeInfo = feign.info( apiKey, darTechId, birthDate, birthDateSearchType);
////        EmployeeInfo employeeInfo1 = feign.info(apiKey, companyId, birthDate2, birthDateSearchType);
//
//        List<ListOfPeople> newList = Stream.of(listOfEmployeesService.creationOfEmployees(employeeInfo))
//                .flatMap(Collection::stream)
//                .collect(Collectors.toList());

        testService.list();

        NewsFeedModel newsFeedModel = new NewsFeedModel();
        newsFeedModel.setId("TestId");
        newsFeedModel.setDate(LocalDate.now());
        newsFeedModel.setLogoUrl("TestLogo");
        newsFeedModel.setPrimaryText("Happy Birthday!");
        newsFeedModel.setListOfPeople(testService.list());
        newsFeedModel.setSecondaryText("Dear Friends!");
        newsFeedModel.setImageURL("TestURL");

        return newsFeedModel;


    }

    @Override
    public String deleteAll() {
        return null;
    }

}
