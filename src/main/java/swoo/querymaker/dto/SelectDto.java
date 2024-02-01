package swoo.querymaker.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import swoo.querymaker.domain.ColumnName;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SelectDto {
    private String tableName;
    private List<ColumnName> columnNames;
    private Boolean allSelect;
}
