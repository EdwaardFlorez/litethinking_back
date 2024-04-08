package co.com.litethinking.model.client;
import co.com.litethinking.model.order.Order;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Client {
    private String clientIdentification;
    private String name;
    private String address;
    private String telephone;
    private List<Order> ordersSet;
}
