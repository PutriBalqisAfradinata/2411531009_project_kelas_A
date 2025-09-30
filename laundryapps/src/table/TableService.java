package table;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import model.service;

public class TableService extends AbstractTableModel {
    private List<service> list;

    public TableService(List<service> list) {
        this.list = list;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 4; // id, jenis, harga, status
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0: return "ID";
            case 1: return "Jenis";
            case 2: return "Harga";
            case 3: return "Status";
            default: return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        service s = list.get(rowIndex);
        switch (columnIndex) {
            case 0: return s.getId();
            case 1: return s.getJenis();
            case 2: return s.getHarga();
            case 3: return s.getStatus();
            default: return null;
        }
    }
}
