package co.com.litethinking.usecase.product;

import co.com.litethinking.model.company.Company;
import co.com.litethinking.model.company.gateways.CompanyRepository;
import co.com.litethinking.model.product.Product;
import co.com.litethinking.model.product.gateways.ProductRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ProductUseCase {
    private final ProductRepository productRepository;
    public Mono<Product> saveCompanyRest(Product company) {
        return productRepository.saveProduct(company);
    }
}
