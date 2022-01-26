package kz.dar.tech.dms.overview.news.api.models.companies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Root {
    private List<Entity> entities;
}
