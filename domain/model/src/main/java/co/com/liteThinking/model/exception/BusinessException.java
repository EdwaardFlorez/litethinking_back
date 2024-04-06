package co.com.liteThinking.model.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class BusinessException extends Exception {

    private final int status;
    private final String code;
    private final String description;
    private final String title;

    public BusinessException(int status,
                             String coreCode,
                             String message,
                             String title) {
        super(message);
        this.status = status;
        this.code = coreCode;
        this.description = message;
        this.title = title;
    }

    public BusinessException(int status,
                             String code) {
        this.status = status;
        this.code = code;
        this.description = null;
        this.title = null;
    }

}
