package co.com.litethinking.api.request;

import co.com.litethinking.model.exception.BusinessExceptionConstants;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RequestCreateProduct {
    @Valid
    @NotBlank(message = "code " + BusinessExceptionConstants.ResponseCodesBody.ERROR_BODY_BLANK)
    @Size(min = 1, max = 9, message = "nit " + BusinessExceptionConstants.ResponseCodesBody.ERROR_BODY_CHARACTERS)
    public Integer code;
    @Valid
    @NotBlank(message = "name " + BusinessExceptionConstants.ResponseCodesBody.ERROR_BODY_BLANK)
    @Size(min = 1, max = 50, message = "name " + BusinessExceptionConstants.ResponseCodesBody.ERROR_BODY_CHARACTERS)
    public String name;
    @Valid
    @NotBlank(message = "address " + BusinessExceptionConstants.ResponseCodesBody.ERROR_BODY_BLANK)
    @Size(min = 1, max = 100, message = "address " + BusinessExceptionConstants.ResponseCodesBody.ERROR_BODY_CHARACTERS)
    public String features;
    @Valid
    @NotBlank(message = "telephone " + BusinessExceptionConstants.ResponseCodesBody.ERROR_BODY_BLANK)
    @Size(min = 1, max = 10, message = "telephone " + BusinessExceptionConstants.ResponseCodesBody.ERROR_BODY_CHARACTERS)
    public String price;

    @Valid
    @NotBlank(message = "telephone " + BusinessExceptionConstants.ResponseCodesBody.ERROR_BODY_BLANK)
    @Size(min = 1, max = 10, message = "telephone " + BusinessExceptionConstants.ResponseCodesBody.ERROR_BODY_CHARACTERS)
    public String company;
}
