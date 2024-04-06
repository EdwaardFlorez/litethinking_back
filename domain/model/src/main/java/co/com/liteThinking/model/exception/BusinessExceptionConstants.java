package co.com.liteThinking.model.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

public class BusinessExceptionConstants {

    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class ResponseCodesBody {

        public static final String ERROR_BODY_CHARACTERS = "field does not meet the required number of characters";
        public static final String ERROR_BODY_NULL = "field cannot be null";
        public static final String ERROR_BODY_BLANK = "field cannot be blank";
    }

}
