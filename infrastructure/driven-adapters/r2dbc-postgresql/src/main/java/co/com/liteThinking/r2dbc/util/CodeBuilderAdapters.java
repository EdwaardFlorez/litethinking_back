package co.com.litethinking.r2dbc.util;

import co.com.litethinking.model.company.Company;
import co.com.litethinking.r2dbc.adapters.company.CompanyEntity;

public class CodeBuilder {
    public CompanyEntity toTransferEntityCompany(Company company) {
        return CompanyEntity.builder()
                .nit(company.getNit())
                .name(company.getName())
                .address(company.getAddress())
                .telephone(company.getTelephone())
                .build();
    }
}
