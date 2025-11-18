package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.user;  // pake huruf kecil sesuai nama class kamu

public class TableUser extends AbstractTableModel {
    List<user> ls;
    private String[] columnNames = {"ID", "Name", "Username", "Password"};

    public TableUser(List<user> ls) {
        this.ls = ls;
    }

    @Override
    public int getRowCount() {
        return ls.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return ls.get(rowIndex).getId();
            case 1:
                return ls.get(rowIndex).getNama();
            case 2:
                return ls.get(rowIndex).getUsername();
            case 3:
                return ls.get(rowIndex).getPassword();
            default:
                return null;
        }
    }
}