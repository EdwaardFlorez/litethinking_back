package co.com.liteThinking.r2dbc.adapters.company;

import co.com.liteThinking.model.company.Company;
import co.com.liteThinking.model.company.gateways.CompanyRepository;
import co.com.liteThinking.model.exception.BusinessException;
import co.com.liteThinking.r2dbc.util.CodeBuilderAdapters;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Log4j2
public class CompanyAdapter implements CompanyRepository {

    private final CompanyDataRepository repository;
    private final CodeBuilderAdapters codeBuilderAdapters;
    @Transactional(rollbackFor = BusinessException.class)
    @Override
    public Mono<Company> saveCompany(Company company) {
        CompanyEntity entity = codeBuilderAdapters.toTransferEntityCompany(company);
        return repository.save(entity)
                .map(save -> {
                    log.info("The company is saved with Nit: " + company.getNit());
                    return company;
                })
                .onErrorResume(error -> {
                    if (error instanceof DataIntegrityViolationException) {
                        log.error("The company with id: {} already exists in table",
                                company.getNit());
                        return Mono.error(new BusinessException(500, "The record already exists in the database"));
                    } else {
                        return Mono.error(new BusinessException(500, "An error occurred while saving to the database. "));
                    }
                });
    }
}
