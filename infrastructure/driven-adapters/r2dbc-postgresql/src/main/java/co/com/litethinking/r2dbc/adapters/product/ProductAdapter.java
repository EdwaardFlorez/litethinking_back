package co.com.litethinking.r2dbc.adapters.product;

import co.com.litethinking.model.company.Company;
import co.com.litethinking.model.exception.BusinessException;
import co.com.litethinking.model.product.Product;
import co.com.litethinking.model.product.gateways.ProductRepository;
import co.com.litethinking.r2dbc.adapters.company.CompanyDataRepository;
import co.com.litethinking.r2dbc.adapters.company.CompanyEntity;
import co.com.litethinking.r2dbc.util.CodeBuilderAdapters;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;
@Service
@RequiredArgsConstructor
@Log4j2
public class ProductAdapter implements ProductRepository {
    private final ProductDataRepository repository;
    private final CodeBuilderAdapters codeBuilderAdapters;
    @Transactional(rollbackFor = BusinessException.class)
    @Override
    public Mono<Product> saveProduct(Product company) {
        ProductEntity entity = codeBuilderAdapters.toTransferEntityProduct(company);
        return repository.save(entity)
                .map(save -> {
                    log.info("The company is saved with Nit: " + company.getCode());
                    return company;
                })
                .onErrorResume(error -> {
                    if (error instanceof DataIntegrityViolationException) {
                        log.error("The company with id: {} already exists in table",
                                company.getCode());
                        return Mono.error(new BusinessException(500, "The record already exists in the database"));
                    } else {
                        return Mono.error(new BusinessException(500, "An error occurred while saving to the database. "));
                    }
                });
    }
}
