package table;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import model.customer;

public class TableCustomer extends AbstractTableModel {
    private List<customer> list;

    public TableCustomer(List<customer> list) {
        this.list = list;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 4; // id, nama, alamat, noHp
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0: return "ID";
            case 1: return "Nama";
            case 2: return "Alamat";
            case 3: return "No HP";
            default: return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        customer c = list.get(rowIndex);
        switch (columnIndex) {
            case 0: return c.getId();
            case 1: return c.getNama();
            case 2: return c.getAlamat();
            case 3: return c.getNoHp();
            default: return null;
        }
    }
}
