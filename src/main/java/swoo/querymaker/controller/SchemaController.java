package swoo.querymaker.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import swoo.querymaker.dto.ColumnOptionsDto;
import swoo.querymaker.dto.ColumnsDto;
import swoo.querymaker.dto.RestResponse;
import swoo.querymaker.dto.SchemaDto;
import swoo.querymaker.enums.ColumnDataType;
import swoo.querymaker.service.SchemaService;

@Slf4j
@RestController
@RequestMapping("/api")
public class SchemaController {

    private final SchemaService schemaService;

    public SchemaController(SchemaService schemaService) {
        this.schemaService = schemaService;
    }

    @PostMapping("/ddl/creation/schema")
    public ResponseEntity<RestResponse<Object>> createSchema(@RequestBody @Validated SchemaDto SchemaName) {
        String schemaQuery = schemaService.createSchemaQuery(SchemaName.getSchemaName());

        RestResponse<Object> response = RestResponse.builder()
                .code(HttpStatus.OK.value())
                .httpStatus(HttpStatus.OK)
                .message("success schema create query")
                .data(schemaQuery)
                .build();

        return new ResponseEntity<>(response, response.getHttpStatus());
    }

    @PostMapping("/ddl/creation/table")
    public ResponseEntity<RestResponse<Object>> createTable(@RequestBody @Validated ColumnsDto columns,
                                                            @RequestBody ColumnOptionsDto columnOptions) {
        String tableQuery = schemaService.createTableQuery(columns.getTableName(), columns.getColumns());

        RestResponse<Object> response = RestResponse.builder()
                .code(HttpStatus.OK.value())
                .httpStatus(HttpStatus.OK)
                .message("success table create query")
                .data(tableQuery)
                .build();

        log.info("[POST][/ddl/creation/table][CREATE TABLE QUERY][{}]", tableQuery);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }

    @GetMapping("/ddl/creation/table/types")
    public ResponseEntity<RestResponse<Object>> getTableDefinition() {
        log.info("getTableDefinition call");
        ColumnDataType[] columnDataTypes = ColumnDataType.toList();

        RestResponse<Object> response = RestResponse.builder()
                .code(HttpStatus.OK.value())
                .httpStatus(HttpStatus.OK)
                .message("success get columns types")
                .data(columnDataTypes)
                .build();

        return new ResponseEntity<>(response, response.getHttpStatus());
    }
}
