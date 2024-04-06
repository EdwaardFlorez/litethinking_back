package co.com.liteThinking.api;

import co.com.liteThinking.api.dto.ResponseDTO;
import co.com.liteThinking.api.request.RequestCreateCompany;
import co.com.liteThinking.api.util.CodeBuilderApi;
import co.com.liteThinking.model.company.Company;
import co.com.liteThinking.usecase.company.CompanyUseCase;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.*;


import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Mono;
@Log4j2
@RestController
@RequestMapping(value = "/api",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {

    private final CodeBuilderApi codeBuilder;
    @NonNull
    private final CompanyUseCase companyUseCase;
    @PostMapping(path = "/company/create")
    public Mono<ResponseEntity<ResponseDTO>> endpointDeposit(@Valid @RequestBody RequestCreateCompany requestCreateCompany,
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
}
