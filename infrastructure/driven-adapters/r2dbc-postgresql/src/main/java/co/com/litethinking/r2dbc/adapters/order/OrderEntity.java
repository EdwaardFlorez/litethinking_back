package co.com.litethinking.r2dbc.adapters.order;

import co.com.litethinking.r2dbc.adapters.client.ClientEntity;
import co.com.litethinking.r2dbc.adapters.product.ProductEntity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Builder;
import lombok.ToString;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@Table("TBL_LT_ORDER")
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity {
    @Id
    @Column("PK_ORDER_CODE")
    private int orderCode;
    @Column("DATE")
    private String date;
    @Column("DESTINATION_ADDRESS")
    private String destinationAddress;
    @ManyToMany(targetEntity = ProductEntity.class)
    private List<ProductEntity> productsSet;
    @ManyToOne
    @JoinColumn(name = "CLIENT")
    private ClientEntity client;
}
