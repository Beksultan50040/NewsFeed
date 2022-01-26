package kz.dar.tech.dms.overview.news.api.services.impl;

import kz.dar.tech.dms.overview.news.api.models.EmployeeInfo;
import kz.dar.tech.dms.overview.news.api.models.ListOfPeople;
import kz.dar.tech.dms.overview.news.api.services.ListOfEmployeesService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListOfEmployeesServiceImpl implements ListOfEmployeesService {
    @Override
    public List<ListOfPeople> creationOfEmployees(EmployeeInfo employeeInfo) {
        List<ListOfPeople> listOfPeople = new ArrayList<>();
        for (int i = 1; i<=employeeInfo.getEntities().size(); i++) {
            listOfPeople.add(i-1, new ListOfPeople("Test", "Test","Test"));
        }

        for (int i =0; i<=employeeInfo.getEntities().size()-1; i++){

            listOfPeople.get(i).setNameEng(employeeInfo.getEntities().get(i).getName().getFirst() + " " + employeeInfo.getEntities().get(i).getName().getLast());
            listOfPeople.get(i).setNameRu(employeeInfo.getEntities().get(i).getNameRu().getFirst() + " " + employeeInfo.getEntities().get(i).getNameRu().getLast());
            listOfPeople.get(i).setJobTitle(employeeInfo.getEntities().get(i).getPosition());

        }

        

        return listOfPeople;
    }
}
