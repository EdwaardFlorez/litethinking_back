package co.com.litethinking.r2dbc.adapters.product;

import co.com.litethinking.r2dbc.adapters.categories.CategoryEntity;
import co.com.litethinking.r2dbc.adapters.company.CompanyEntity;
import co.com.litethinking.r2dbc.adapters.order.OrderEntity;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.Builder;
import lombok.ToString;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.domain.Persistable;
import java.util.List;

@Table("TBL_LT_PRODUCT")
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity implements Persistable<Integer> {
    @Id
    @Column("PK_PRODUCT_CODE")
    private Integer code;
    @Column("NAME")
    private String name;
    @Column("FEATURES")
    private String features;
    @Column("PRICE")
    private String price;
    /*
    @ManyToMany(targetEntity = CategoryEntity.class)
    private List<CategoryEntity> categoriesSet;
    */
    @Column("PRODUCT_SET")
    private String companies;
    /*
    @ManyToMany(targetEntity = OrderEntity.class)
    private List<OrderEntity> ordersSet;
     */

    @Override
    public Integer getId() {
        return code;
    }

    @Override
    public boolean isNew() {
        return true;
    }
}
