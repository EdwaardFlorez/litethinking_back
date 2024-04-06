package co.com.liteThinking.r2dbc.adapters.company;

import co.com.liteThinking.r2dbc.adapters.product.ProductEntity;
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

@Table("TBL_LT_COMPANY")
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompanyEntity {
    @Id
    @Column("PK_COMPANY_NIT")
    private String nit;
    @Column("NAME")
    private String name;
    @Column("ADDRESS")
    private String address;
    @Column("TELEPHONE")
    private String telephone;
    @ManyToMany(targetEntity = ProductEntity.class)
    private List<ProductEntity> productsSet;
}
