package co.com.litethinking.r2dbc.adapters.client;

import co.com.litethinking.r2dbc.adapters.order.OrderEntity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.Builder;
import lombok.ToString;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@Table("TBL_LT_CLIENT")
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientEntity {
    @Id
    @Column("PK_CLIENT_IDENTIFICATION")
    public String clientIdentification;
    @Column("NAME")
    public String name;
    @Column("ADDRESS")
    public String address;
    @Column("TELEPHONE")
    public String telephone;
    @OneToMany(mappedBy = "client")
    private List<OrderEntity> ordersSet;

}
