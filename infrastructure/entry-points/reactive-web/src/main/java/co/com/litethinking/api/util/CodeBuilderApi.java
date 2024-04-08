package co.com.litethinking.api.util;

import co.com.litethinking.api.request.RequestCreateCompany;
import co.com.litethinking.api.request.RequestCreateProduct;
import co.com.litethinking.api.response.DataResponse;
import co.com.litethinking.model.company.Company;
import co.com.litethinking.model.product.Product;

public class CodeBuilderApi {
    public DataResponse responseBuilder(Company company, String action){
        return DataResponse.builder()
                .idRequest(company.getNit())
                .nameAction(action)
                .statusAction(true)
                .build();
    }

    public DataResponse responseBuilder2(Product company, String action){
        return DataResponse.builder()
                .idRequest(String.valueOf(company.getCode()))
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

    public DataResponse responseBuilderError2(Product company, String action){
        return DataResponse.builder()
                .idRequest(String.valueOf(company.getCode()))
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

    public Product buildProductModel(RequestCreateProduct requestCreateProduct) {
        return Product.builder()
                .code(requestCreateProduct.getCode())
                .name(requestCreateProduct.getName())
                .features(requestCreateProduct.getFeatures())
                .price(requestCreateProduct.getPrice())
                .companies(requestCreateProduct.getCompany())
                .build();
    }

}
