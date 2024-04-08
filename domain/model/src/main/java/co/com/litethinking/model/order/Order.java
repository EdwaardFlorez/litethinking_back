package co.com.litethinking.model.order;
import co.com.litethinking.model.client.Client;
import co.com.litethinking.model.product.Product;
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
public class Order {
    private int orderCode;
    private String date;
    private String destinationAddress;
    private List<Product> productsSet;
    private Client client;
}
