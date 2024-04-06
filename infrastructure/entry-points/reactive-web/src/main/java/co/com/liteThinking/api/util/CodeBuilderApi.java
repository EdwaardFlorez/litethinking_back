package co.com.liteThinking.api.util;

import co.com.liteThinking.api.request.RequestCreateCompany;
import co.com.liteThinking.api.response.DataResponse;
import co.com.liteThinking.model.company.Company;

public class CodeBuilderApi {
    public DataResponse responseBuilder(Company company, String action){
        return DataResponse.builder()
                .idRequest(company.getNit())
                .nameAction(action)
                .statusAction(true)
                .build();
    }

    public DataResponse responseBuilderError(Company company, String action){
        return DataResponse.builder()
                .idRequest(company.getNit())
                .nameAction(action)
                .statusAction(false)
                .build();
    }

    public Company buildCompanyModel(RequestCreateCompany requestCreateCompany) {
        return Company.builder()
                .nit(requestCreateCompany.getNit())
                .name(requestCreateCompany.getName())
                .address(requestCreateCompany.getAddress())
                .telephone(requestCreateCompany.getTelephone())
                .build();
    }

}
