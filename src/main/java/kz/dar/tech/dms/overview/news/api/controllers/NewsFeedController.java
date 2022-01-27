package kz.dar.tech.dms.overview.news.api.controllers;

import kz.dar.tech.dms.overview.news.api.models.employees.NewsFeedModel;
import kz.dar.tech.dms.overview.news.api.services.NewsFeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/news-feed")
public class NewsFeedController {

    @Autowired
    private NewsFeedService newsFeedService;


//
//    @PostMapping("/save")
//    public NewsFeed save(@RequestBody NewsFeed newsFeed){
//        return newsFeedService.save(newsFeed);
//    }
//
    @GetMapping("/findAll")
    public NewsFeedModel findAll(@RequestParam (required = false) String birthDate ){
        return newsFeedService.findAll(birthDate);
    }
//
//    @DeleteMapping("/deleteAll")
//    public String deleteAll(){
//        return newsFeedService.deleteAll();
//    }
}
