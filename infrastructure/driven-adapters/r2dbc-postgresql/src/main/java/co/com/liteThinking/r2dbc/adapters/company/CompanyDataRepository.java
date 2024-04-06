package co.com.liteThinking.r2dbc.adapters.company;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyDataRepository extends ReactiveCrudRepository<CompanyEntity, String> {
}
