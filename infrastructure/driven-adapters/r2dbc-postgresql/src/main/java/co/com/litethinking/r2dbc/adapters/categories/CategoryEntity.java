package co.com.litethinking.r2dbc.adapters.categories;

import co.com.litethinking.r2dbc.adapters.product.ProductEntity;
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


@Table("TBL_LT_CATEGORY")
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryEntity {
    @Id
    @Column("PK_CATEGORY_CODE")
    private String code;
    @Column("NAME")
    private String name;
    @ManyToMany(targetEntity = ProductEntity.class)
    private List<ProductEntity> productsSet;
}
