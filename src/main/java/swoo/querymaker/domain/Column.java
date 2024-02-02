package swoo.querymaker.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Column {
    private String name;
    private String type;
    private String size;
    private Boolean primaryKey;
    private Boolean notNull;

    public String extractColumnDefinition() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" ").append(type);

        if (size != null && !size.equals("0")) {
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
