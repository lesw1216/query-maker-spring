package swoo.querymaker.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import swoo.querymaker.domain.Column;
import swoo.querymaker.enums.ColumnDataType;
import swoo.querymaker.valid.EnumValue;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ColumnDto {

    @NotBlank
    private String name;

    @EnumValue(enumClass = ColumnDataType.class, ignoreCase = true, message = "must select type")
    private String type;

    @Pattern(regexp = "^[0-9]\\d*$", message = "Must Input Number")
    private String size;

    @NotNull
    private Boolean primaryKey;

    @NotNull
    private Boolean notNull;


    public Column toColumn() {
        return Column.builder()
                .name(this.name)
                .type(this.type)
                .size(this.size)
                .primaryKey(this.primaryKey)
                .notNull(this.notNull)
                .build();
    }
}
