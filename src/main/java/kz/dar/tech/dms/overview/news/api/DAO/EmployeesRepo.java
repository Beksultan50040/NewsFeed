package kz.dar.tech.dms.overview.news.api.DAO;
import kz.dar.tech.dms.overview.news.api.models.employees.EmployeeInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


public interface EmployeesRepo extends ElasticsearchRepository<EmployeeInfo, java.lang.String> {



}
