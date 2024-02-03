package swoo.querymaker.domain;

import lombok.*;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ColumnName {
    private String name;
    private String asName;

    public String extractNameAndAsName() {
        if (asName != null) {
            return name.concat(" as ").concat(asName);
        }

        return name;
    }
}
