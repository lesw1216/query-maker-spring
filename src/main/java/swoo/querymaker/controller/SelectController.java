package swoo.querymaker.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import swoo.querymaker.dto.RestResponse;
import swoo.querymaker.dto.SelectDto;
import swoo.querymaker.service.SelectService;

@Slf4j
@RestController
@RequestMapping("/api")
public class SelectController {

    private final SelectService selectService;

    public SelectController(SelectService selectService) {
        this.selectService = selectService;
    }

    @PostMapping("/selects")
    public ResponseEntity<RestResponse<Object>> createDefaultSelect(@RequestBody SelectDto selectDto) {
        String defaultSelectQuery = selectService.createDefaultSelect(
                selectDto.getTableName(),
                selectDto.getColumnNames(),
                selectDto.getAllSelect()
        );

        RestResponse<Object> response = RestResponse.builder()
                .code(HttpStatus.OK.value())
                .httpStatus(HttpStatus.OK)
                .message("success create default select query")
                .data(defaultSelectQuery)
                .build();

        log.info("[POST][/selects][CREATE DEFAULT SELECT QUERY][{}]", defaultSelectQuery);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }
}
