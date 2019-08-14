import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import org.eclipse.wb.swing.FocusTraversalOnArray;

public class WindowApplication {

	private JFrame frmMyfitnessmedic;
	private JTable tableOfFoods;
	private JScrollPane scrollPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowApplication window = new WindowApplication();
					window.frmMyfitnessmedic.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WindowApplication() {
		initialize();
	}

	public void updateDataTable() {
		String[] headers = new String[MainProgram.Food.str.length + 1];
		headers[0] = "Ime";
		int j = 1;
		for (String t : MainProgram.Food.str)
			headers[j++] = t;

		ArrayList<String[]> tableData = new ArrayList<String[]>();
		String[] temp;
		for (MainProgram.Food t : MainProgram.foodsList) {
			temp = new String[MainProgram.Food.abbr.length + 1];
			temp[0] = t.name;
			for (int i = 0; i < MainProgram.Food.abbr.length; i++) {
				temp[i + 1] = t.values[i] + "";
			}
			tableData.add(temp);
		}
		tableOfFoods = new JTable(tableData.toArray(new String[tableData.size()][tableData.get(0).length]), headers);
		tableOfFoods.setVisible(true);
		tableOfFoods.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setViewportView(tableOfFoods);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		MainProgram.loadFoods(MainProgram.saveFileName);
		frmMyfitnessmedic = new JFrame();
		frmMyfitnessmedic.setResizable(false);
		frmMyfitnessmedic.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {

				MainProgram.saveFoods(MainProgram.saveFileName);
				frmMyfitnessmedic.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		frmMyfitnessmedic.setTitle("MyFitnessMedic");
		frmMyfitnessmedic.setBounds(100, 100, 474, 358);
		frmMyfitnessmedic.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmMyfitnessmedic.getContentPane().setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 458, 319);
		frmMyfitnessmedic.getContentPane().add(tabbedPane);

		JPanel panelFood = new JPanel();
		tabbedPane.addTab("Hrana", null, panelFood, null);
		panelFood.setLayout(null);

		JButton btnAddFood = new JButton("Dodaj hrano");
		btnAddFood.setBounds(290, 250, 135, 30);
		btnAddFood.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		btnAddFood.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panelFood.add(btnAddFood);

		tableOfFoods = new JTable();
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 269, 291);
		scrollPane.setAlignmentX(Component.LEFT_ALIGNMENT);
		panelFood.add(scrollPane);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setViewportView(tableOfFoods);
		updateDataTable();

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Cilji", null, panel_1, null);
		panel_1.setLayout(null);

		textField = new JTextField();
		textField.setBounds(10, 33, 127, 20);
		panel_1.add(textField);
		textField.setColumns(10);

		JButton btnNovCilj = new JButton("Nov cilj");
		btnNovCilj.setBounds(10, 64, 89, 23);
		panel_1.add(btnNovCilj);

		JLabel lblTrenutniCilj = new JLabel("Trenutni cilj:");
		lblTrenutniCilj.setBounds(10, 17, 127, 14);
		panel_1.add(lblTrenutniCilj);
		frmMyfitnessmedic.getContentPane()
				.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { btnAddFood }));

		btnAddFood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainProgram.addFood(MainProgram.foodInput());
				updateDataTable();
			}
		});

	}

	public String getGoalText() {
		return textField.getText();
	}

	public void setGoalText(String text) {
		textField.setText(text);
	}
}
