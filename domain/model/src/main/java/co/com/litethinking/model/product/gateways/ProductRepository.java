package co.com.litethinking.model.product.gateways;

import co.com.litethinking.model.company.Company;
import co.com.litethinking.model.product.Product;
import reactor.core.publisher.Mono;

public interface ProductRepository {
    Mono<Product> saveProduct(Product company);
}
