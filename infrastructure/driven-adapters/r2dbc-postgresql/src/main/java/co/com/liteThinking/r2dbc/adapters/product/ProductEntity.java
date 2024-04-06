package co.com.liteThinking.r2dbc.adapters.product;

import co.com.liteThinking.r2dbc.adapters.categories.CategoryEntity;
import co.com.liteThinking.r2dbc.adapters.company.CompanyEntity;
import co.com.liteThinking.r2dbc.adapters.order.OrderEntity;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.Builder;
import lombok.ToString;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@Table("TBL_LT_PRODUCT")
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {
    @Id
    @Column("PK_PRODUCT_CODE")
    private int code;
    @Column("NAME")
    private String name;
    @Column("FEATURES")
    private String features;
    @Column("PRICE")
    private String price;
    @ManyToMany(targetEntity = CategoryEntity.class)
    private List<CategoryEntity> categoriesSet;
    @ManyToMany(targetEntity = CompanyEntity.class)
    private List<CompanyEntity> companies;
    @ManyToMany(targetEntity = OrderEntity.class)
    private List<OrderEntity> ordersSet;
}
