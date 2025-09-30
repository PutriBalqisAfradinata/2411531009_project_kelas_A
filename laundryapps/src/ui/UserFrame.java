package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.UserRepo;

import model.user;
import table.TableUser;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UserFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnCancel;
	private JTable tableUsers;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserFrame frame = new UserFrame();
					frame.setVisible(true);
					frame.loadTable();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void reset() {
		txtName.setText("");
		txtUsername.setText("");
		txtPassword.setText("");
	}
	
	UserRepo usr = new UserRepo();
	List<user> ls;
	public String id;
	
	public void loadTable() {
		ls = usr.show();
		TableUser tu = new TableUser(ls);
		tableUsers.setModel(tu);
		tableUsers.getTableHeader().setVisible(true);
	}
	

	private String sanitizeUsername(String raw) {
	    if (raw == null) return "";
	    return raw.toLowerCase().replaceAll("\\s+", "");
	}

	private boolean isPasswordValid(String pwd) {
	    if (pwd == null) return false;
	    return pwd.length() >= 6;
	}


	/**
	 * Create the frame.
	 */
	public UserFrame() {
		setTitle("User");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 583, 744);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(32, 52, 68, 29);
		contentPane.add(lblNewLabel);
		
		txtName = new JTextField();
		txtName.setBounds(108, 54, 398, 27);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsername.setBounds(32, 95, 68, 29);
		contentPane.add(lblUsername);
		
		txtUsername = new JTextField();
		txtUsername.setColumns(10);
		txtUsername.setBounds(108, 98, 398, 27);
		contentPane.add(txtUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(32, 141, 68, 29);
		contentPane.add(lblPassword);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(108, 144, 398, 27);
		contentPane.add(txtPassword);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtName.getText().trim();
		        String username = sanitizeUsername(txtUsername.getText());
		        String password = txtPassword.getText();

		        // validasi password
		        if (!isPasswordValid(password)) {
		            JOptionPane.showMessageDialog(null, "Password harus minimal 6 karakter.");
		            txtPassword.requestFocus();
		            return;
		        }

		        // validasi username kosong
		        if (username.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Username tidak boleh kosong.");
		            txtUsername.requestFocus();
		            return;
		        }
		        
		        txtUsername.setText(username);

		        user user = new user();
		        user.setNama(name);
		        user.setUsername(username);
		        user.setPassword(password);

		        usr.save(user);
		        reset();
		        loadTable();
		        JOptionPane.showMessageDialog(null, "User berhasil disimpan.");
			}
		});
		btnSave.setBackground(new Color(0, 255, 0));
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSave.setBounds(108, 191, 81, 29);
		contentPane.add(btnSave);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (id == null || id.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Silahkan pilih data yang akan diubah.");
		            return;
		        }

		        String name = txtName.getText().trim();
		        String username = sanitizeUsername(txtUsername.getText());
		        String password = txtPassword.getText();

		        if (!isPasswordValid(password)) {
		            JOptionPane.showMessageDialog(null, "Password harus minimal 6 karakter.");
		            txtPassword.requestFocus();
		            return;
		        }

		        if (username.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Username tidak boleh kosong.");
		            txtUsername.requestFocus();
		            return;
		        }

		        txtUsername.setText(username);

		        user user = new user();
		        user.setId(id);
		        user.setNama(name);
		        user.setUsername(username);
		        user.setPassword(password);

		        usr.update(user);
		        reset();
		        loadTable();
		        JOptionPane.showMessageDialog(null, "User berhasil diupdate.");
			}
		});
		
		btnUpdate.setBackground(new Color(128, 128, 255));
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnUpdate.setBounds(219, 191, 81, 29);
		contentPane.add(btnUpdate);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(id != null) {
				    usr.delete(id);
				    reset();
				    loadTable();
				} else {
				    JOptionPane.showMessageDialog(null, "Silahkan pilih data yang akan di hapus");
				}
			}
		});
		
		btnDelete.setBackground(new Color(255, 0, 0));
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDelete.setBounds(323, 191, 81, 29);
		contentPane.add(btnDelete);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBackground(new Color(255, 255, 0));
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancel.setBounds(425, 191, 81, 29);
		contentPane.add(btnCancel);
		
		tableUsers = new JTable();
		tableUsers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				id = tableUsers.getValueAt(tableUsers.getSelectedRow(),0).toString();
				txtName.setText(tableUsers.getValueAt(tableUsers.getSelectedRow(),1).toString());
				txtUsername.setText(tableUsers.getValueAt(tableUsers.getSelectedRow(),2).toString());
				txtPassword.setText(tableUsers.getValueAt(tableUsers.getSelectedRow(),3).toString());
			}
		});
		tableUsers.setBounds(8, 268, 551, 427);
		contentPane.add(tableUsers);
		
		loadTable();
	}

}
