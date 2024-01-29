package swoo.querymaker.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import swoo.querymaker.enums.ColumnDataType;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Column {
    private String name;
    private ColumnDataType type;
    private Integer size;
    private boolean primaryKey;
    private boolean notNull;

    public String extractColumnDefinition() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" ").append(type);

        if (size != null) {
            sb.append("(").append(size).append(")");
        }

        if (notNull) {
            sb.append(" not null");
        }

        if (primaryKey) {
            sb.append(" primary key");
        }

        return sb.toString();
    }
}
