import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Interface extends JFrame {

	private JPanel contentPane;
	private Environnement environnement;
	private JButton btnRecherche;
	private JButton btnReset;
	private JSpinner spnEnX;
	private JLabel lblEnX;
	private JSpinner spnEnY;
	private JLabel lblEnY;
	private JSpinner spnIniEnX;
	private JLabel lblIniEnX;
	private JSpinner spnIniEnY;
	private JLabel lblIniEnY;
	private JSpinner spnGoalX;
	private JLabel lblGoalX;
	private JSpinner spnGoalY;
	private JLabel lblGoalY;
	private Carree initiale;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface frame = new Interface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Interface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 770, 489);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	
		
		
		btnReset = new JButton("R\u00E9initialiser");
		btnReset.setBounds(10, 124, 89, 23);
		contentPane.add(btnReset);
		
		spnEnX = new JSpinner();
		spnEnX.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				environnement.setEnX((int) spnEnX.getValue());
			}
		});
		spnEnX.setModel(new SpinnerNumberModel(new Integer(25), new Integer(0), null, new Integer(1)));
		spnEnX.setBounds(10, 158, 30, 20);
		contentPane.add(spnEnX);
		
		lblEnX = new JLabel("EnX");
		lblEnX.setBounds(50, 158, 46, 14);
		contentPane.add(lblEnX);
		
		spnEnY = new JSpinner();
		spnEnY.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				environnement.setEnY((int) spnEnY.getValue());
			}
		});
		spnEnY.setModel(new SpinnerNumberModel(new Integer(25), new Integer(0), null, new Integer(1)));
		spnEnY.setBounds(10, 189, 30, 20);
		contentPane.add(spnEnY);
		
		lblEnY = new JLabel("EnY");
		lblEnY.setBounds(50, 192, 46, 14);
		contentPane.add(lblEnY);
		
		spnIniEnX = new JSpinner();
		spnIniEnX.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
			}
		});
		spnIniEnX.setModel(new SpinnerNumberModel(0, 0, (int) spnEnX.getValue(), 1));
		spnIniEnX.setBounds(10, 220, 30, 20);
		contentPane.add(spnIniEnX);
		
		lblIniEnX = new JLabel("Coordon\u00E9 initiale en x");
		lblIniEnX.setBounds(50, 223, 128, 14);
		contentPane.add(lblIniEnX);
		
		spnIniEnY = new JSpinner();
		spnIniEnY.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
			}
		});
		spnIniEnY.setModel(new SpinnerNumberModel(0, 0,(int) spnEnY.getValue() , 1));
		spnIniEnY.setBounds(10, 249, 30, 20);
		contentPane.add(spnIniEnY);
		
		lblIniEnY = new JLabel("Coordon\u00E9 initiale en y");
		lblIniEnY.setBounds(50, 252, 125, 14);
		contentPane.add(lblIniEnY);		

		spnGoalX = new JSpinner();
		spnGoalX.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
			}
		});
		spnGoalX.setModel(new SpinnerNumberModel(0, 0, 3, 1));
		spnGoalX.setBounds(10, 280, 30, 20);
		contentPane.add(spnGoalX);
		
		lblGoalX = new JLabel("Coordon\u00E9 du but en x");
		lblGoalX.setBounds(50, 283, 111, 14);
		contentPane.add(lblGoalX);
		
		spnGoalY = new JSpinner();
		spnGoalY.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
			}
		});
		spnGoalY.setModel(new SpinnerNumberModel(0, 0, 2, 1));
		spnGoalY.setBounds(10, 311, 30, 20);
		contentPane.add(spnGoalY);
		
		lblGoalY = new JLabel("Coordon\u00E9 du but en y");
		lblGoalY.setBounds(53, 308, 125, 14);
		contentPane.add(lblGoalY);
		
		environnement = new Environnement(20, 10, new Carree(2,2), new Carree(15,9));
		environnement.setBounds(163, 10, 583, 452);
		contentPane.add(environnement);
		
		btnRecherche = new JButton("Recherche");
		btnRecherche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				environnement.recherche();
			}
		});
		btnRecherche.setBounds(10, 75, 89, 23);
		contentPane.add(btnRecherche);
	}
}
