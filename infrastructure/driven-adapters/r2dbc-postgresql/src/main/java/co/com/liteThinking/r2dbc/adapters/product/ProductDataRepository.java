package co.com.liteThinking.r2dbc.adapters.product;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ProductDataRepository extends ReactiveCrudRepository<ProductEntity, String> {
}
