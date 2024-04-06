package co.com.litethinking.r2dbc.adapters.company;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CompanyDataRepository extends ReactiveCrudRepository<CompanyEntity, String> {
}
