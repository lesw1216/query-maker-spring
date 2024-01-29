package swoo.querymaker.service;

import org.springframework.stereotype.Service;
import swoo.querymaker.domain.Column;

import java.util.ArrayList;
import java.util.List;

@Service
public class SchemaService {

    public String createSchemaQuery(String schemaName) {
        return "CREATE DATABASE " + schemaName + ";";
    }

    public String createTableQuery(String tableName, List<Column> columns) {
        String prefix = "CREATE TABLE ";

        StringBuilder sb = new StringBuilder();
        sb.append(prefix).append(tableName).append(" ( ");

        ArrayList<String> arr = new ArrayList<>();
        for (Column column : columns) {
            arr.add(column.extractColumnDefinition());
        }

        String joinedColumns = String.join(", ", arr);
        sb.append(joinedColumns).append(");");

        return sb.toString();
    }
}
