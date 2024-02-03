package swoo.querymaker.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import swoo.querymaker.domain.ColumnName;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SelectDto {

    @NotBlank
    private String tableName;

    @NotNull
    @Size(min = 1)
    @Valid
    private List<ColumnNameDto> columnNames;

    @NotNull
    private Boolean allSelect;

    public List<ColumnName> getColumnNames() {
        ArrayList<ColumnName> arr = new ArrayList<>();
        for (ColumnNameDto columnDto : columnNames) {
            arr.add(columnDto.toColumnName());
        }

        return arr;
    }
}
