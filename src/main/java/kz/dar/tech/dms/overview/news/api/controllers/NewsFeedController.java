package kz.dar.tech.dms.overview.news.api.controllers;

import kz.dar.tech.dms.overview.news.api.models.NewsFeedModel;
import kz.dar.tech.dms.overview.news.api.services.ListOfEmployeesFromAllCompaniesService;
import kz.dar.tech.dms.overview.news.api.services.NewsFeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/news-feed")
public class NewsFeedController {

    @Autowired
    private NewsFeedService newsFeedService;

    @Autowired
    private ListOfEmployeesFromAllCompaniesService list;



//    @PostMapping("/save")
//    public CompanyInfo save(){
//        return list.companyInfo();
//    }

    @PostMapping("/saveEmp")
    public java.lang.String saveEmp(){
        return list.saveEmployeesInfo();
    }

    @DeleteMapping("/deleteAllEmp")
    public String deleteAllEmp(){
        return list.deleteAllEmpInfo();
    }

    @GetMapping("/findAll")
    public NewsFeedModel findAll(@RequestParam (required = false) java.lang.String birthDate ){
        return newsFeedService.findAll(birthDate);
    }
//
//    @DeleteMapping("/deleteAll")
//    public String deleteAll(){
//        return newsFeedService.deleteAll();
//    }
}
