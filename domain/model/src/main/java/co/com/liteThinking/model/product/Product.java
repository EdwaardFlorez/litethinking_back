package co.com.liteThinking.model.product;
import co.com.liteThinking.model.category.Category;
import co.com.liteThinking.model.company.Company;
import co.com.liteThinking.model.order.Order;
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
public class Product {
    private int code;
    private String name;
    private String features;
    private String price;
    private List<Category> categoriesSet;
    private List<Company> companies;
    private List<Order> ordersSet;
}
