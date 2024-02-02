package swoo.querymaker.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import swoo.querymaker.domain.Column;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ColumnsDto {

    @NotBlank
    private String tableName;

    @NotNull
    @Size(min=1)
    @Valid
    private List<ColumnDto> columns;

    public List<Column> getColumns() {
        List<Column> columnsList = new ArrayList<>();
        for (ColumnDto columnDto : this.columns) {
            columnsList.add(columnDto.toColumn());
        }

        return columnsList;
    }
}
