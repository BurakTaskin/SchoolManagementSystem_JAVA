

/*JSON Parse iþlemini Controller/JsonParselClass içerisinde yaptýrdým ancak jtable'a aktarmada sorun yaþadým. Ben de json
dosyasýný csv formatýna dönüþtürerek bu sorunu çözdüm. Verileri jtable'a aktardým ancak bu sefer de jtable'dan verileri 
geri csv'ye güncelletemedim. Yeni bir json veya csv dosyasý olarak export ettim ama asýl beklentiniz, var olan json dosyasýný
güncellemek olduðundan güncelleme iþlemini yapamadan projeyi eksik bir þekilde bitirmek durumunda kaldým.*/





import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.Console;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

import java.util.*;



import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class MainPage extends JFrame {

	private JPanel contentPane;
	private JTable studentTable;
	private JTable teacherTable;
	private JTable classTable;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage frame = new MainPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainPage() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		setBounds(0,0,750,550);
		setTitle("School Management System");	
		
		JMenuBar menuBar = new JMenuBar();						
		JMenu menu1 = new JMenu("Dosya");							
        JMenuItem menu1_1 = new JMenuItem("Dosya Seç");				
        menu1.add(menu1_1);											
        menuBar.add(menu1);											
        setJMenuBar(menuBar);
        getContentPane().setLayout(null);
        
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(10, 72, 716, 409);
        getContentPane().add(tabbedPane);
        
        
        
        
        JPanel panel = new JPanel();
        tabbedPane.addTab("Student", null, panel, null);
        panel.setLayout(null);
        
        studentTable = new JTable();
        panel.add(studentTable);
        
        final DefaultTableModel model = (DefaultTableModel)studentTable.getModel();
		model.addColumn("STUDENT");
		model.addColumn("Surname");
		model.addColumn("Name");
		model.addColumn("Grade");
		model.addColumn("Age");
		model.addColumn("Fee");
        
		JScrollPane scrollPane = new JScrollPane(studentTable);
        scrollPane.setBounds(10, 10, 600, 300);
        panel.add(scrollPane);
        
        
        
        
        JPanel panel_1 = new JPanel();
        tabbedPane.addTab("Teacher", null, panel_1, null);
        panel_1.setLayout(null);
        
        teacherTable = new JTable();
        panel_1.add(teacherTable);
        
        final DefaultTableModel modelTeacher = (DefaultTableModel)teacherTable.getModel();
        modelTeacher.addColumn("BRACHN");
		modelTeacher.addColumn("Surname");
		modelTeacher.addColumn("Name");
		modelTeacher.addColumn("Salary");
		modelTeacher.addRow(new Object[] {"Music"});
		modelTeacher.addRow(new Object[] {"Math"});
		modelTeacher.addRow(new Object[] {"Science"});
		modelTeacher.addRow(new Object[] {"Literature"});
        
        
		JScrollPane scrollPaneTeacher = new JScrollPane(teacherTable);
        scrollPaneTeacher.setBounds(10, 10, 600, 300);
        panel_1.add(scrollPaneTeacher);
        
        
        
        
        JPanel panel_2 = new JPanel();
        tabbedPane.addTab("Class", null, panel_2, null);
        panel_2.setLayout(null);
        
        classTable = new JTable();
        panel_2.add(classTable);
        
        final DefaultTableModel modelClass = (DefaultTableModel)classTable.getModel();
        modelClass.addColumn("GRADE");
		modelClass.addColumn("Monday");
		modelClass.addColumn("Tuesday");
		modelClass.addColumn("Wednesday");
		modelClass.addColumn("Thursday");
		modelClass.addColumn("Friday");
        
        
		JScrollPane scrollPaneClass = new JScrollPane(classTable);
        scrollPaneClass.setBounds(10, 10, 600, 300);
        panel_2.add(scrollPaneClass);
        
        //Bu kýsým seçilen csv dosyasýnýn her bir tabloya aktarýmýný saglar
        menu1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileopen = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
						"Text/CSV file", "txt", "csv","json");
				fileopen.addChoosableFileFilter(filter);
				int ret = fileopen.showDialog(null, "Choose file");
				if (ret == JFileChooser.APPROVE_OPTION ) {
					File file = fileopen.getSelectedFile();
					try {
						BufferedReader br = new BufferedReader(new FileReader(file));
						String line;
						int row = 0 ;
						while ((line = br.readLine()) != null ) {	
							String[] arr = line.split(",");
							model.addRow(new Object[0]);
							model.setValueAt(arr[0], row,0);
							model.setValueAt(arr[1], row,1);
							model.setValueAt(arr[2], row,2);
							model.setValueAt(arr[3], row,3);
							model.setValueAt(arr[4], row,4);
							model.setValueAt(arr[5], row,5);
							modelTeacher.addRow(new Object[0]);
							modelTeacher.setValueAt(arr[7], row, 1);
							modelTeacher.setValueAt(arr[8], row, 2);
							modelTeacher.setValueAt(arr[9], row, 3);
							modelClass.addRow(new Object[0]);
							modelClass.setValueAt(arr[10], row,0);
							modelClass.setValueAt(arr[11], row,1);
							modelClass.setValueAt(arr[12], row,2);
							modelClass.setValueAt(arr[13], row,3);
							modelClass.setValueAt(arr[14], row,4);
							modelClass.setValueAt(arr[15], row,5);
							row++;
							
							
						}
						br.close();										
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				}
			}
        });
        
        JButton btnNewButton = new JButton("UPDATE");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int selectedRowIndex = studentTable.getSelectedRow();
        		String surname = model.getValueAt(selectedRowIndex, 1).toString();
        		String name = model.getValueAt(selectedRowIndex, 2).toString();
        		String grade = model.getValueAt(selectedRowIndex, 3).toString();
        		String age = model.getValueAt(selectedRowIndex, 4).toString();
        		String fee = model.getValueAt(selectedRowIndex, 5).toString();
        		
        		String newSurname = JOptionPane.showInputDialog(null,"Enter the new surname", surname);
        		String newName = JOptionPane.showInputDialog(null,"Enter the new name", name);
        		String newGrade = JOptionPane.showInputDialog(null,"Enter the new grade", grade);
        		String newAge = JOptionPane.showInputDialog(null,"Enter the new age", age);
        		String newFee = JOptionPane.showInputDialog(null,"Enter the new fee", fee);
        		
        		model.setValueAt(newSurname, selectedRowIndex, 1);
        		model.setValueAt(newName, selectedRowIndex, 2);
        		model.setValueAt(newGrade, selectedRowIndex, 3);
        		model.setValueAt(newAge, selectedRowIndex, 4);
        		model.setValueAt(newFee, selectedRowIndex, 5);
        		
        		
        	}
        });
        btnNewButton.setBounds(269, 320, 85, 21);
        panel.add(btnNewButton);
        
        
        
        
        JButton btnNewButton2 = new JButton("UPDATE");
        btnNewButton2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int selectedRowIndex = teacherTable.getSelectedRow();
        		String surname = modelTeacher.getValueAt(selectedRowIndex, 1).toString();
        		String name = modelTeacher.getValueAt(selectedRowIndex, 2).toString();
        		String salary = modelTeacher.getValueAt(selectedRowIndex, 3).toString();
        		
        		String newSurname = JOptionPane.showInputDialog(null,"Enter the new surname", surname);
        		String newName = JOptionPane.showInputDialog(null,"Enter the new name", name);
        		String newSalary = JOptionPane.showInputDialog(null,"Enter the new salary", salary);
        		
        		modelTeacher.setValueAt(newSurname, selectedRowIndex, 1);
        		modelTeacher.setValueAt(newName, selectedRowIndex, 2);
        		modelTeacher.setValueAt(newSalary, selectedRowIndex, 3);
        	}
        });
        btnNewButton2.setBounds(269, 320, 85, 21);
        panel_1.add(btnNewButton2);
        
        
        
        JButton btnNewButton3 = new JButton("UPDATE");
        btnNewButton3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int selectedRowIndex = classTable.getSelectedRow();
        		String monday = modelClass.getValueAt(selectedRowIndex, 1).toString();
        		String tuesday = modelClass.getValueAt(selectedRowIndex, 2).toString();
        		String wednesday = modelClass.getValueAt(selectedRowIndex, 3).toString();
        		String thursday = modelClass.getValueAt(selectedRowIndex, 4).toString();
        		String friday = modelClass.getValueAt(selectedRowIndex, 5).toString();
        		
        		String newMonday = JOptionPane.showInputDialog(null,"Enter the new Monday", monday);
        		String newTuesday = JOptionPane.showInputDialog(null,"Enter the new Tuesday", tuesday);
        		String newWednesday = JOptionPane.showInputDialog(null,"Enter the new Wednesday", wednesday);
        		String newThursday = JOptionPane.showInputDialog(null,"Enter the new Thursday", thursday);
        		String newFriday = JOptionPane.showInputDialog(null,"Enter the new Friday", friday);
        		
        		
        		modelClass.setValueAt(newMonday, selectedRowIndex, 1);
        		modelClass.setValueAt(newTuesday, selectedRowIndex, 2);
        		modelClass.setValueAt(newWednesday, selectedRowIndex, 3);
        		modelClass.setValueAt(newThursday, selectedRowIndex, 4);
        		modelClass.setValueAt(newFriday, selectedRowIndex, 5);
        	}
        });
        btnNewButton3.setBounds(269, 320, 85, 21);
        panel_2.add(btnNewButton3);
        
        //Bu kýsým seçili satýrýn, seçilecek olan csv dosyasýnda güncellenmesini saðlar ancak geliþtirme asamasýnda kaldýðýndan düzgün çalýþmamaktadýr.
        JButton btnNewButton_1 = new JButton("PUSH UPDATE");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int selectedRowIndex = studentTable.getSelectedRow();
        		JFileChooser fileopen = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
						"Text/CSV file", "txt", "csv","json");
				fileopen.addChoosableFileFilter(filter);
				int ret = fileopen.showDialog(null, "Choose file");
				if (ret == JFileChooser.APPROVE_OPTION ) {
					File file = fileopen.getSelectedFile();
					try {
						CSVReader reader = new CSVReader(new FileReader(file));
						List<String[]> csvBody = reader.readAll();
						csvBody.get(selectedRowIndex)[1] = "";
						reader.close();
						CSVWriter writer = new CSVWriter(new FileWriter(file), ',');
						writer.writeAll(csvBody);
						writer.flush();
						writer.close();
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
        	}
        	}});
        btnNewButton_1.setBounds(394, 320, 128, 21);
        panel.add(btnNewButton_1);
        
        
		
		
	}
	
}
