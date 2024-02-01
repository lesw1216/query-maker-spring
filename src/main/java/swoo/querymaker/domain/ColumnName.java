package swoo.querymaker.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
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
