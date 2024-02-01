package swoo.querymaker.service;

import org.springframework.stereotype.Service;
import swoo.querymaker.domain.ColumnName;

import java.util.ArrayList;
import java.util.List;

@Service
public class SelectService {

    public String createDefaultSelect(String tableName, List<ColumnName> columnNames, Boolean allSelect) {
        if (allSelect) {
            return "SELECT ".concat("*").concat(" from ").concat(tableName);
        }

        List<String> columnNameAndAsNames = extractColumnNameString(columnNames);
        String joinedColumnNames = String.join(", ", columnNameAndAsNames);

        return "SELECT ".concat(joinedColumnNames).concat(" FROM ").concat(tableName);
    }

    private List<String> extractColumnNameString(List<ColumnName> columnNames) {
        ArrayList<String> arr = new ArrayList<>();
        for (ColumnName columnName : columnNames) {
            arr.add(columnName.extractNameAndAsName());
        }

        return arr;
    }
}
