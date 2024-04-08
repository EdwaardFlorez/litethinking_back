package co.com.litethinking.usecase.company;

import co.com.litethinking.model.company.Company;
import co.com.litethinking.model.company.gateways.CompanyRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CompanyUseCase {

    private final CompanyRepository companyRepository;
    public Mono<Company> saveCompanyRest(Company company) {
        return companyRepository.saveCompany(company);
    }
}
