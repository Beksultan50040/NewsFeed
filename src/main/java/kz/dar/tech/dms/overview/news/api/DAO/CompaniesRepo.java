package kz.dar.tech.dms.overview.news.api.DAO;
import kz.dar.tech.dms.overview.news.api.models.companies.CompanyInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


public interface CompaniesRepo extends ElasticsearchRepository<CompanyInfo, String> {


}
