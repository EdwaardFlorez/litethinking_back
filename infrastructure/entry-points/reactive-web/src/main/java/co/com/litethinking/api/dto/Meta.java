package co.com.litethinking.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Builder(toBuilder = true)
public class Meta {
    @JsonProperty("requestDateTime")
    private LocalDateTime requestDateTime;
}
