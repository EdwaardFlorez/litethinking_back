package co.com.litethinking.api;

import co.com.litethinking.api.dto.ResponseDTO;
import co.com.litethinking.api.request.RequestCreateCompany;
import co.com.litethinking.api.request.RequestCreateProduct;
import co.com.litethinking.api.util.CodeBuilderApi;
import co.com.litethinking.model.company.Company;
import co.com.litethinking.model.product.Product;
import co.com.litethinking.usecase.company.CompanyUseCase;
import co.com.litethinking.usecase.product.ProductUseCase;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.*;


import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Mono;
@Log4j2
@CrossOrigin(
        origins = {
                "https://d1sqw3c8j5yb58.cloudfront.net"
        },
        methods = {
                RequestMethod.OPTIONS,
                RequestMethod.GET,
                RequestMethod.PUT,
                RequestMethod.DELETE,
                RequestMethod.POST
        })
@RestController
@RequestMapping(value = "/api",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {

    private final CodeBuilderApi codeBuilder;
    @NonNull
    private final CompanyUseCase companyUseCase;
    private final ProductUseCase productUseCase;
    @PostMapping(path = "/company/create")
    public Mono<ResponseEntity<ResponseDTO>> endpointCompany(@Valid @RequestBody RequestCreateCompany requestCreateCompany,
                                                             @RequestHeader(name = "Accept") String accept,
                                                             ServerHttpRequest serverRequest)
            throws Exception {
            log.info("the saving process is started, company: {}", requestCreateCompany);
            Company company = codeBuilder.buildCompanyModel(requestCreateCompany);

        return companyUseCase.saveCompanyRest(company)
                .map(response ->{
                    log.info("Respuesta exitosa del guardado de compañia con Nit: {}",
                            company.getNit());
                    return ResponseEntity.ok().body(ResponseDTO.success(
                            codeBuilder.responseBuilder(response, "INSERT"),
                            serverRequest));
                }).switchIfEmpty(Mono.defer(() -> {
                    log.error("No se pudo realizar el guardado de compañia con Nit: {}",
                            company.getNit());
                    return Mono.just(ResponseEntity.ok().body(ResponseDTO.success(
                            codeBuilder.responseBuilderError(company, "INSERT"),
                            serverRequest)));
                }))
                .onErrorResume(erro -> {
                    log.error("Error interno al guardar la compañia con Nit: {}",
                            company.getNit());
                    return Mono.just(ResponseEntity.ok().body(ResponseDTO.success(
                            codeBuilder.responseBuilderError(company, "INSERT"),
                            serverRequest)));
                });
    }

    @PostMapping(path = "/product/create")
    public Mono<ResponseEntity<ResponseDTO>> endpointProduct(@Valid @RequestBody RequestCreateProduct requestCreateCompany,
                                                             @RequestHeader(name = "Accept") String accept,
                                                             ServerHttpRequest serverRequest)
            throws Exception {
        log.info("the saving process is started, company: {}", requestCreateCompany);
        Product company = codeBuilder.buildProductModel(requestCreateCompany);

        return productUseCase.saveCompanyRest(company)
                .map(response ->{
                    log.info("Respuesta exitosa del guardado de compañia con Nit: {}",
                            company.getCode());
                    return ResponseEntity.ok().body(ResponseDTO.success(
                            codeBuilder.responseBuilder2(response, "INSERT"),
                            serverRequest));
                }).switchIfEmpty(Mono.defer(() -> {
                    log.error("No se pudo realizar el guardado de compañia con Nit: {}",
                            company.getCode());
                    return Mono.just(ResponseEntity.ok().body(ResponseDTO.success(
                            codeBuilder.responseBuilderError2(company, "INSERT"),
                            serverRequest)));
                }))
                .onErrorResume(erro -> {
                    log.error("Error interno al guardar la compañia con Nit: {}",
                            company.getCode());
                    return Mono.just(ResponseEntity.ok().body(ResponseDTO.success(
                            codeBuilder.responseBuilderError2(company, "INSERT"),
                            serverRequest)));
                });
    }


    @GetMapping(path = "/check-status")
    public ResponseEntity<String> checkStatus() {

        log.info("Se inicia el proceso de chequear estado ");
        String msg = "The ms_modify_bd app is healthy. v1.0";
        return new ResponseEntity<>(msg, HttpStatus.OK);

    }

}
