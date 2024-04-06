package co.com.litethinking.r2dbc.adapters.product;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ProductDataRepository extends ReactiveCrudRepository<ProductEntity, String> {
}
