package co.com.liteThinking.usecase.company;

import co.com.liteThinking.model.company.Company;
import co.com.liteThinking.model.company.gateways.CompanyRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Getter
public class CompanyUseCase {

    private final CompanyRepository companyRepository;
    public Mono<Company> saveCompanyRest(Company company) {
        return companyRepository.saveCompany(company);
    }
}
