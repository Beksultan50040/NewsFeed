package kz.dar.tech.dms.overview.news.api.models.employees;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeInfo {

        private int total;
        private List<EntityOfEmployees> entities;



}
