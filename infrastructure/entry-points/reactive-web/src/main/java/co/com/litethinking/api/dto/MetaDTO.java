package co.com.litethinking.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.server.reactive.ServerHttpRequest;

import java.time.LocalDateTime;

public class MetaDTO {
    @Data
    @Builder(toBuilder = true)
    public static class Meta {
        @JsonProperty("requestDateTime")
        private LocalDateTime requestDateTime;
        @JsonProperty("messageId")
        private String messageId;
        @JsonProperty("applicationId")
        private String applicationId;

    }

    public static <T> Meta build(T data, ServerHttpRequest request) {
        return Meta.builder()
                .requestDateTime(LocalDateTime.now())
                .applicationId(validateAddress(request))
                .build();

    }

    private static String validateAddress(ServerHttpRequest request) {
        if (request.getRemoteAddress() != null) {
            return request.getRemoteAddress().getAddress().getHostAddress();
        } else {
            return "";
        }
    }

}