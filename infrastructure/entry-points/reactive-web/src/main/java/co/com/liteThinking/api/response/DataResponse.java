package co.com.liteThinking.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class DataResponse {
    private String idRequest;
    private String nameAction;
    private Boolean statusAction;
}
