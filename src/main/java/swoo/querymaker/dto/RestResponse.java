package swoo.querymaker.dto;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RestResponse<T> {
    private Integer code;
    private HttpStatus httpStatus;
    private String message;
    private T data;
}
