package co.com.liteThinking.r2dbc.util;

import co.com.liteThinking.model.company.Company;
import co.com.liteThinking.r2dbc.adapters.company.CompanyEntity;

public class CodeBuilderAdapters {
    public CompanyEntity toTransferEntityCompany(Company company) {
        return CompanyEntity.builder()
                .nit(company.getNit())
                .name(company.getName())
                .address(company.getAddress())
                .telephone(company.getTelephone())
                .build();
    }
}
