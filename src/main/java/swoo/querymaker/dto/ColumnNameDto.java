package swoo.querymaker.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import swoo.querymaker.domain.ColumnName;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ColumnNameDto {

    @NotBlank
    private String name;

    private String asName;

    public ColumnName toColumnName() {
        return ColumnName.builder()
                .name(this.name)
                .asName(this.asName)
                .build();
    }
}
