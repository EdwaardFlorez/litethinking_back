package co.com.litethinking.model.company.gateways;

import co.com.litethinking.model.company.Company;
import reactor.core.publisher.Mono;

public interface CompanyRepository {
    Mono<Company> saveCompany(Company company);
}
