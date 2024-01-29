package swoo.querymaker.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import swoo.querymaker.domain.Column;
import swoo.querymaker.dto.ColumnsDto;
import swoo.querymaker.dto.RestResponse;
import swoo.querymaker.service.SchemaService;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api")
public class SchemaController {

    private final SchemaService schemaService;

    public SchemaController(SchemaService schemaService) {
        this.schemaService = schemaService;
    }

    @PostMapping("/schemas")
    public ResponseEntity<RestResponse<Object>> createSchema(@RequestBody Map<String, String> SchemaName) {
        String schemaQuery = schemaService.createSchemaQuery(SchemaName.get("schemaName"));

        RestResponse<Object> response = RestResponse.builder()
                .code(HttpStatus.OK.value())
                .httpStatus(HttpStatus.OK)
                .message("success schema create query")
                .data(schemaQuery)
                .build();

        return new ResponseEntity<>(response, response.getHttpStatus());
    }

    @PostMapping("/tables")
    public ResponseEntity<RestResponse<Object>> createTable(@RequestBody ColumnsDto columns) {
        String tableQuery = schemaService.createTableQuery(columns.getTableName(), columns.getColumns());

        RestResponse<Object> response = RestResponse.builder()
                .code(HttpStatus.OK.value())
                .httpStatus(HttpStatus.OK)
                .message("success table create query")
                .data(tableQuery)
                .build();

        return new ResponseEntity<>(response, response.getHttpStatus());
    }
}
