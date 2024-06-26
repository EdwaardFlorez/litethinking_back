package co.com.litethinking.model.category;
import co.com.litethinking.model.product.Product;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Category {
    private String code;
    private String name;
    private List<Product> productsSet;
}
