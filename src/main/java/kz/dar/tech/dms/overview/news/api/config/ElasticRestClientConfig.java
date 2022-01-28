package kz.dar.tech.dms.overview.news.api.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;

@Configuration
public class ElasticRestClientConfig extends AbstractElasticsearchConfiguration {

    @Value("${spring.data.elasticsearch.hosts}")
    private String elasticHost;

    @Override
    public RestHighLevelClient elasticsearchClient() {
        final ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                .connectedTo(elasticHost.split(","))
                .build();

        return RestClients.create(clientConfiguration).rest();
    }
}
