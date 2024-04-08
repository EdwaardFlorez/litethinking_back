package co.com.litethinking.r2dbc.util;

import co.com.litethinking.model.company.Company;
import co.com.litethinking.model.product.Product;
import co.com.litethinking.r2dbc.adapters.company.CompanyEntity;
import co.com.litethinking.r2dbc.adapters.product.ProductEntity;

public class CodeBuilderAdapters {
    public CompanyEntity toTransferEntityCompany(Company company) {
        return CompanyEntity.builder()
                .nit(company.getNit())
                .name(company.getName())
                .address(company.getAddress())
                .telephone(company.getTelephone())
                .build();
    }

    public ProductEntity toTransferEntityProduct(Product company) {
        return ProductEntity.builder()
                .code(company.getCode())
                .name(company.getName())
                .features(company.getFeatures())
                .price(company.getPrice())
                .companies(company.getCompanies())
                .build();
    }
}
