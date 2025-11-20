package table;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import model.customer;

public class TableCustomer extends AbstractTableModel {

    private List<customer> list;
    private final String[] column = {"ID", "Nama", "Email", "Alamat", "HP"};

    public TableCustomer(List<customer> list) {
        this.list = list;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return column.length;
    }

    @Override
    public Object getValueAt(int row, int col) {
        customer c = list.get(row);
        switch (col) {
            case 0: return c.getId();
            case 1: return c.getNama();
            case 2: return c.getEmail();
            case 3: return c.getAlamat();
            case 4: return c.getHp();
            default: return null;
        }
    }

    @Override
    public String getColumnName(int col) {
        return column[col];
    }
}
