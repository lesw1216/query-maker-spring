package swoo.querymaker.exceptions;

import jakarta.validation.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import swoo.querymaker.dto.RestResponse;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Objects;

@Slf4j
@RestControllerAdvice
public class BadRequestHandler {

    private final MessageSource messageSource;

    public BadRequestHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    private String getErrorMessage(ObjectError error) {
        String[] codes = error.getCodes();
        if (codes != null) {
            for (String code : codes) {
                try {
                    return messageSource.getMessage(code, error.getArguments(), Locale.getDefault());
                } catch (NoSuchMessageException ignored) {

                }
            }
        }
        return error.getDefaultMessage();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<RestResponse<Object>> validException(MethodArgumentNotValidException ex) {

        HashMap<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(e -> errors.put(e.getField(), getErrorMessage(e)));

        RestResponse<Object> errorResponse = RestResponse.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .httpStatus(HttpStatus.BAD_REQUEST)
                .message("custom validException")
                .data(errors)
                .build();
        return new ResponseEntity<>(errorResponse, errorResponse.getHttpStatus());
    }
}
