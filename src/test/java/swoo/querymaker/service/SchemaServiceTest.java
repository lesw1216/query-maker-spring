package swoo.querymaker.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class SchemaServiceTest {

    private SchemaService schemaService = new SchemaService();

    @Test
    void success_create_schema_query() {
        String tableName = "todo_list";

        String schemaQuery = schemaService.createSchemaQuery(tableName);

        assertEquals("CREATE DATABASE " + tableName + ";", schemaQuery);
    }
}