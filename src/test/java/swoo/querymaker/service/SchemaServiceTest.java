package swoo.querymaker.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import swoo.querymaker.domain.Column;
import swoo.querymaker.enums.ColumnDataType;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SchemaServiceTest {

    private SchemaService schemaService = new SchemaService();

    @Test
    void success_create_schema_query() {
        String schemaName = "todo_list";

        String schemaQuery = schemaService.createSchemaQuery(schemaName);

        assertEquals("CREATE DATABASE " + schemaName + ";", schemaQuery);
    }

    @Test
    void success_create_table_query() {
        // when
        String tableName = "todolist";
        Column column1 = new Column("id", ColumnDataType.BIGINT, 10, true, false);
        Column column2 = new Column("content", ColumnDataType.VARCHAR, 200, false, true);
        List<Column> columns = List.of(column1, column2);
        // given
        String tableQuery = schemaService.createTableQuery(tableName, columns);

        // then
        String expectQuery = "CREATE TABLE " + tableName + " ( " + column1.extractColumnDefinition() +
                ", " + column2.extractColumnDefinition() + ");";
        assertEquals(expectQuery, tableQuery);
    }
}