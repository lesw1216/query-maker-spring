package swoo.querymaker.enums;

public enum ColumnDataType {
    VARCHAR,
    CHAR,
    BOOLEAN,
    TINYINT,
    INTEGER,
    BIGINT,
    SMALLINT,
    DATE,
    TIME,
    DATETIME;

    public static ColumnDataType[] toList() {
        return ColumnDataType.values();
    }
}
