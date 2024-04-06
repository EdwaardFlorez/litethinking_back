package co.com.liteThinking.model.company.gateways;

import co.com.liteThinking.model.company.Company;
import reactor.core.publisher.Mono;

public interface CompanyRepository {
    Mono<Company> saveCompany(Company company);
}
