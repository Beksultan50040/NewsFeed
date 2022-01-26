package kz.dar.tech.dms.overview.news.api.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeInfo {

        private int total;
        private List<Entity> entities;



}
