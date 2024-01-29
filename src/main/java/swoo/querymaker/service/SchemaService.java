package swoo.querymaker.service;

import org.springframework.stereotype.Service;

@Service
public class SchemaService {

    public String createSchemaQuery(String tableName) {
        return "CREATE DATABASE " + tableName + ";";
    }
}
