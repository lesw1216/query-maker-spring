package swoo.querymaker.domain;

public class ColumnOptions {
    private String primaryKey;
    private String foreignKey;
    private String autoIncrement;

    public String extractPrimaryKey() {
        return "PRIMARY KEY(" + primaryKey + ")";
    }

    public String extractForeignKey() {
        return "FOREIGN KEY(" + foreignKey + ")";
    }

    public String extractAutoIncrement(String columnName) {
        if (autoIncrement.equals(columnName)) {
            return columnName + "auto_increment";
        }

        return columnName;
    }
}
