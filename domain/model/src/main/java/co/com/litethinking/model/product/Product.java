package co.com.litethinking.model.product;
import co.com.litethinking.model.category.Category;
import co.com.litethinking.model.company.Company;
import co.com.litethinking.model.order.Order;
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
