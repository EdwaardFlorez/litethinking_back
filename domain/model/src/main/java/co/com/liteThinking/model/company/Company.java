package co.com.liteThinking.model.company;
import co.com.liteThinking.model.product.Product;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
//@NoArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Company {
    private String nit;
    private String name;
    private String address;
    private String telephone;
    private List<Product> productsSet;
}
