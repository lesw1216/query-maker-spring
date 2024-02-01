package swoo.querymaker.service;

import org.junit.jupiter.api.Test;
import swoo.querymaker.domain.ColumnName;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SelectServiceTest {
    private SelectService service = new SelectService();

    @Test
    void defaultSelect() {
        // when
        String tableName = "고객";
        List<ColumnName> columnNames = List.of(
                new ColumnName("id", "고객아이디"),
                new ColumnName("name", "고객이름"),
                new ColumnName("grade", null));
        Boolean allSelect = false;

        // given
        String defaultSelectQuery = service.createDefaultSelect(tableName, columnNames, allSelect);

        // then
        ArrayList<String> arr = new ArrayList<>();
        for (ColumnName columnName : columnNames) {
            arr.add(columnName.extractNameAndAsName());
        }
        String joined = String.join(", ", arr);
        assertEquals("SELECT ".concat(joined).concat(" from ").concat(tableName), defaultSelectQuery);
    }

    @Test
    void defaultAllSelect() {
        // when
        String tableName = "고객";
        List<ColumnName> columnNames = List.of();
        Boolean allSelect = true;

        // given
        String defaultSelectQuery = service.createDefaultSelect(tableName, columnNames, allSelect);

        // then
        assertEquals("SELECT ".concat("*").concat(" from ").concat(tableName), defaultSelectQuery);
    }
}