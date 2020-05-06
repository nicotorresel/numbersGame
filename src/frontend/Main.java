package frontend;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import backend.Juego;
import java.awt.Font;

public class Main {

	private Juego juego;

	private JFrame frame;
	private JButton comenzar;
	private JButton reglas;
	private JButton salir;
	private JButton nuevoJuego;
	
	private JTextField f0c0;
	private JTextField f0c1;
	private JTextField f0c2;
	private JTextField f0c3;
	private JTextField f1c0;
	private JTextField f1c1;
	private JTextField f1c2;
	private JTextField f1c3;
	private JTextField f2c0;
	private JTextField f2c1;
	private JTextField f2c2;
	private JTextField f2c3;
	private JTextField f3c0;
	private JTextField f3c1;
	private JTextField f3c2;
	private JTextField f3c3;
	private ArrayList<JTextField> boxes;
	
	private JLabel parcialFila0;
	private JLabel parcialFila1;
	private JLabel parcialFila2;
	private JLabel parcialFila3;
	
	private JLabel parcialColumna0;
	private JLabel parcialColumna1;
	private JLabel parcialColumna2;
	private JLabel parcialColumna3;
	
	private ArrayList<JLabel> parciales;
	
	private JLabel resultadoFila0;
	private JLabel resultadoFila1;
	private JLabel resultadoFila2;
	private JLabel resultadoFila3;
	
	private JLabel resultadoColumna0;
	private JLabel resultadoColumna1;
	private JLabel resultadoColumna2;
	private JLabel resultadoColumna3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
	    try { 
	        UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); 
	    } catch(Exception e) {  }

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		juego = new Juego(4,4);
		
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//boton para comenzar la partida
		comenzar = new JButton("COMENZAR");
		comenzar.setFont(new Font("Century Gothic", Font.BOLD, 15));
		comenzar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f0c0.setEditable(true);
				f0c1.setEditable(true);
				f0c2.setEditable(true);
				f0c3.setEditable(true);
				f1c0.setEditable(true);
				f1c1.setEditable(true);
				f1c2.setEditable(true);
				f1c3.setEditable(true);
				f2c0.setEditable(true);
				f2c1.setEditable(true);
				f2c2.setEditable(true);
				f2c3.setEditable(true);
				f3c0.setEditable(true);
				f3c1.setEditable(true);
				f3c2.setEditable(true);
				f3c3.setEditable(true);
				
				resultadoFila0.setVisible(true);
				resultadoFila1.setVisible(true);
				resultadoFila2.setVisible(true);
				resultadoFila3.setVisible(true);
				resultadoColumna0.setVisible(true);
				resultadoColumna1.setVisible(true);
				resultadoColumna2.setVisible(true);
				resultadoColumna3.setVisible(true);
				
			}
		});
		comenzar.setBounds(40, 20, 120, 40);
		frame.getContentPane().add(comenzar);
		
		//boton para ver las reglas
		reglas = new JButton("REGLAS");
		reglas.setFont(new Font("Century Gothic", Font.BOLD, 17));
		reglas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(frame, "OBJETIVO: El objetivo del juego consiste en igualar los números presentados como RESULTADO \n" +
						"tanto en las filas como en las columnas. Para ello se deben completar los casilleros con números \n"+
						"mayores a 0 (cero), los cuales se irán sumando por fila y por columna. Una vez completada una fila\n"+
						"y/o  columna,  si  la  suma  equivale  al  respectivo  \"RESULTADO\"  entonces dicha  fila/columna  se \n"+
						"considerará   como  acertada  y se marcará en color VERDE,  si se pasa  del valor se  marcará   en \n"+
						"color ROJO.\n"+
						"El juego se gana cuando todas las filas y todas las columnas equivalen al resultado.\r\n" + 
						"\r\n" + 
						"INSERTAR NÚMERO: Para insertar un número en el tablero hay que hacer un click sobre el casillero \n"+
						" a insertar, luego escribir el número deseado y dar ENTER (*).\r\n" + 
						"\r\n" + 
						"(*) Una vez pulsado ENTER no se podrá modificar el valor del casillero.");
			}
		});
		reglas.setBounds(300, 20, 120, 40);
		frame.getContentPane().add(reglas);
		
		//boton para abandonar el juego
		salir = new JButton("SALIR");
		salir.setFont(new Font("Century Gothic", Font.BOLD, 17));
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		salir.setBounds(580-120, 505-40, 120, 40);
		frame.getContentPane().add(salir);
		
		//boton para comenzar un nuevo juego
		nuevoJuego = new JButton("NUEVO JUEGO");
		nuevoJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				juego = new Juego (4,4);
				boxes = new ArrayList<JTextField>();
				boxes.add(f0c0);
				boxes.add(f0c1);
				boxes.add(f0c2);
				boxes.add(f0c3);
				boxes.add(f1c0);
				boxes.add(f1c1);
				boxes.add(f1c2);
				boxes.add(f1c3);
				boxes.add(f2c0);
				boxes.add(f2c1);
				boxes.add(f2c2);
				boxes.add(f2c3);
				boxes.add(f3c0);
				boxes.add(f3c1);
				boxes.add(f3c2);
				boxes.add(f3c3);
				for (JTextField box : boxes) {
					box.setText("");
					box.setEditable(false);
					box.setEnabled(true);
					
				}
				
				parciales = new ArrayList<JLabel>();
				parciales.add(parcialFila0);
				parciales.add(parcialFila1);
				parciales.add(parcialFila2);
				parciales.add(parcialFila3);
				parciales.add(parcialColumna0);
				parciales.add(parcialColumna1);
				parciales.add(parcialColumna2);
				parciales.add(parcialColumna3);
				for (JLabel parcial : parciales) {
					parcial.setText("0");
					parcial.setForeground(new Color(255, 140, 0));
				}
				
				resultadoFila0.setText(String.valueOf(juego.rowResult(0)));
				resultadoFila0.setVisible(false);
				resultadoFila0.setForeground(new Color(0, 0, 0));
				resultadoFila1.setText(String.valueOf(juego.rowResult(1)));
				resultadoFila1.setVisible(false);
				resultadoFila1.setForeground(new Color(0, 0, 0));
				resultadoFila2.setText(String.valueOf(juego.rowResult(2)));
				resultadoFila2.setVisible(false);
				resultadoFila2.setForeground(new Color(0, 0, 0));
				resultadoFila3.setText(String.valueOf(juego.rowResult(3)));
				resultadoFila3.setVisible(false);
				resultadoFila3.setForeground(new Color(0, 0, 0));

				resultadoColumna0.setText(String.valueOf(juego.columnResult(0)));
				resultadoColumna0.setVisible(false);
				resultadoColumna0.setForeground(new Color(0, 0, 0));
				resultadoColumna1.setText(String.valueOf(juego.columnResult(1)));
				resultadoColumna1.setVisible(false);
				resultadoColumna1.setForeground(new Color(0, 0, 0));
				resultadoColumna2.setText(String.valueOf(juego.columnResult(2)));
				resultadoColumna2.setVisible(false);
				resultadoColumna2.setForeground(new Color(0, 0, 0));
				resultadoColumna3.setText(String.valueOf(juego.columnResult(3)));
				resultadoColumna3.setVisible(false);
				resultadoColumna3.setForeground(new Color(0, 0, 0));
			}
		});
		nuevoJuego.setFont(new Font("Century Gothic", Font.BOLD, 13));
		nuevoJuego.setBounds(170, 20, 120, 40);
		frame.getContentPane().add(nuevoJuego);
		

		//========================== FILA 0 ===========================================
		//fila 0 columna 0
		f0c0 = new JTextField();
		f0c0.setFont(new Font("Century Gothic", Font.BOLD, 15));
		f0c0.setEditable(false);
		f0c0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isNumeric(f0c0.getText())) {
					int ret00 = Integer.parseInt(f0c0.getText());
					if (ret00>0) {
						f0c0.setEnabled(false);
						juego.inputNumber(ret00, 0, 0);
						parcialFila0.setText(String.valueOf(juego.parcialRow(0)));
						parcialColumna0.setText(String.valueOf(juego.parcialColumn(0)));
					}
					if (juego.compareRows(0)) {
						parcialFila0.setForeground(new Color(0,255,0));
						resultadoFila0.setForeground(new Color(0, 255, 0));
					}
					else if (juego.parcialRow(0)>juego.rowResult(0)) {
						parcialFila0.setForeground(new Color(254,0,0));
						resultadoFila0.setForeground(new Color(254, 0, 0));	
					}
					if (juego.compareColumns(0)) {
						parcialColumna0.setForeground(new Color(0, 255, 0));
						resultadoColumna0.setForeground(new Color(0, 255, 0));
					}
					else if (juego.parcialColumn(0)>juego.columnResult(0)) {
						parcialColumna0.setForeground(new Color(254, 0, 0));
						resultadoColumna0.setForeground(new Color(254, 0, 0));
					}
					if (juego.win())
						JOptionPane.showMessageDialog(frame, "FELICITACIONES!!! \n GANASTE!!!");
				}
			}
		});
		f0c0.setHorizontalAlignment(SwingConstants.CENTER);
		f0c0.setBounds(40 , 90 , 60, 60);
		frame.getContentPane().add(f0c0);
		
		//fila 0 columna 1
		f0c1 = new JTextField();
		f0c1.setFont(new Font("Century Gothic", Font.BOLD, 15));
		f0c1.setEditable(false);
		f0c1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isNumeric(f0c1.getText())) {
					int ret01 = Integer.parseInt(f0c1.getText());
					if (ret01>0) {
						f0c1.setEnabled(false);
						juego.inputNumber(ret01, 0, 1);
						parcialFila0.setText(String.valueOf(juego.parcialRow(0)));
						parcialColumna1.setText(String.valueOf(juego.parcialColumn(1)));
					}
					if (juego.compareRows(0)) {
						parcialFila0.setForeground(new Color(0,255,0));
						resultadoFila0.setForeground(new Color(0, 255, 0));
					}
					else if (juego.parcialRow(0)>juego.rowResult(0)) {
						parcialFila0.setForeground(new Color(254,0,0));
						resultadoFila0.setForeground(new Color(254, 0, 0));	
					}
					if (juego.compareColumns(1)) {
						parcialColumna1.setForeground(new Color(0, 255, 0));
						resultadoColumna1.setForeground(new Color(0, 255, 0));
					}
					else if (juego.parcialColumn(1)>juego.columnResult(1)) {
						parcialColumna1.setForeground(new Color(254,0,0));
						resultadoColumna1.setForeground(new Color(254, 0, 0));	
					}
					if (juego.win())
						JOptionPane.showMessageDialog(frame, "FELICITACIONES!!! \n GANASTE!!!");
					
				}
				
			}
		});
		f0c1.setHorizontalAlignment(SwingConstants.CENTER);
		f0c1.setBounds(105 , 90 , 60, 60);
		frame.getContentPane().add(f0c1);
		
		//fila 0 columna 2
		f0c2 = new JTextField();
		f0c2.setFont(new Font("Century Gothic", Font.BOLD, 15));
		f0c2.setEditable(false);
		f0c2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isNumeric(f0c2.getText())) {
					int ret02 = Integer.parseInt(f0c2.getText());
					if (ret02>0) {
						f0c2.setEnabled(false);
						juego.inputNumber(ret02, 0, 2);
						parcialFila0.setText(String.valueOf(juego.parcialRow(0)));
						parcialColumna2.setText(String.valueOf(juego.parcialColumn(2)));						
					}
					if (juego.compareRows(0)) {
						parcialFila0.setForeground(new Color(0,255,0));
						resultadoFila0.setForeground(new Color(0, 255, 0));
					}
					else if (juego.parcialRow(0)>juego.rowResult(0)) {
						parcialFila0.setForeground(new Color(254,0,0));
						resultadoFila0.setForeground(new Color(254, 0, 0));	
					}
					if (juego.compareColumns(2)) {
						parcialColumna2.setForeground(new Color(0, 255, 0));
						resultadoColumna2.setForeground(new Color(0, 255, 0));
					}
					else if (juego.parcialColumn(2)>juego.columnResult(2)) {
						parcialColumna2.setForeground(new Color(254,0,0));
						resultadoColumna2.setForeground(new Color(254, 0, 0));	
					}
					if (juego.win())
						JOptionPane.showMessageDialog(frame, "FELICITACIONES!!! \n GANASTE!!!");
					
				}
			}
		});
		f0c2.setHorizontalAlignment(SwingConstants.CENTER);
		f0c2.setBounds(170 , 90 , 60, 60);
		frame.getContentPane().add(f0c2);
		
		//fila 0 columna 3
		f0c3 = new JTextField();
		f0c3.setFont(new Font("Century Gothic", Font.BOLD, 15));
		f0c3.setEditable(false);
		f0c3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isNumeric(f0c3.getText())) {
					int ret03 = Integer.parseInt(f0c3.getText());
					if (ret03>0) {
						f0c3.setEnabled(false);
						juego.inputNumber(ret03, 0, 3);
						parcialFila0.setText(String.valueOf(juego.parcialRow(0)));
						parcialColumna3.setText(String.valueOf(juego.parcialColumn(3)));						
					}
					if (juego.compareRows(0)) {
						parcialFila0.setForeground(new Color(0,255,0));
						resultadoFila0.setForeground(new Color(0, 255, 0));
					}
					else if (juego.parcialRow(0)>juego.rowResult(0)) {
						parcialFila0.setForeground(new Color(254,0,0));
						resultadoFila0.setForeground(new Color(254, 0, 0));	
					}
					if (juego.compareColumns(3)) {
						parcialColumna3.setForeground(new Color(0, 255, 0));
						resultadoColumna3.setForeground(new Color(0, 255, 0));
					}
					else if (juego.parcialColumn(3)>juego.columnResult(3)) {
						parcialColumna3.setForeground(new Color(254,0,0));
						resultadoColumna3.setForeground(new Color(254, 0, 0));	
					}
					if (juego.win())
						JOptionPane.showMessageDialog(frame, "FELICITACIONES!!! \n GANASTE!!!");
					
				}
			}
		});
		f0c3.setHorizontalAlignment(SwingConstants.CENTER);
		f0c3.setBounds(235 , 90 , 60, 60);
		frame.getContentPane().add(f0c3);

		//======================== FILA 1 ==============================================
		
		//fila 1 columna 0
		f1c0 = new JTextField();
		f1c0.setFont(new Font("Century Gothic", Font.BOLD, 15));
		f1c0.setEditable(false);
		f1c0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isNumeric(f1c0.getText())) {
					int ret10 = Integer.parseInt(f1c0.getText());
					if (ret10>0) {
						f1c0.setEnabled(false);
						juego.inputNumber(ret10, 1, 0);
						parcialFila1.setText(String.valueOf(juego.parcialRow(1)));
						parcialColumna0.setText(String.valueOf(juego.parcialColumn(0)));						
					}
					if (juego.compareRows(1)) {
						parcialFila1.setForeground(new Color(0,255,0));
						resultadoFila1.setForeground(new Color(0, 255, 0));
					}
					else if (juego.parcialRow(1)>juego.rowResult(1)) {
						parcialFila1.setForeground(new Color(254,0,0));
						resultadoFila1.setForeground(new Color(254, 0, 0));	
					}
					if (juego.compareColumns(0)) {
						parcialColumna0.setForeground(new Color(0, 255, 0));
						resultadoColumna0.setForeground(new Color(0, 255, 0));
					}
					else if (juego.parcialColumn(0)>juego.columnResult(0)) {
						parcialColumna0.setForeground(new Color(254,0,0));
						resultadoColumna0.setForeground(new Color(254, 0, 0));	
					}
					if (juego.win())
						JOptionPane.showMessageDialog(frame, "FELICITACIONES!!! \n GANASTE!!!");
					
				}
			}
		});
		f1c0.setHorizontalAlignment(SwingConstants.CENTER);
		f1c0.setBounds(40 , 155 , 60, 60);
		frame.getContentPane().add(f1c0);
		
		//fila 1 columna 1
		f1c1 = new JTextField();
		f1c1.setFont(new Font("Century Gothic", Font.BOLD, 15));
		f1c1.setEditable(false);
		f1c1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isNumeric(f1c1.getText())) {
					int ret11 = Integer.parseInt(f1c1.getText());
					if (ret11>0) {
						f1c1.setEnabled(false);
						juego.inputNumber(ret11, 1, 1);
						parcialFila1.setText(String.valueOf(juego.parcialRow(1)));
						parcialColumna1.setText(String.valueOf(juego.parcialColumn(1)));						
					}
					if (juego.compareRows(1)) {
						parcialFila1.setForeground(new Color(0,255,0));
						resultadoFila1.setForeground(new Color(0, 255, 0));
					}
					else if (juego.parcialRow(1)>juego.rowResult(1)) {
						parcialFila1.setForeground(new Color(254,0,0));
						resultadoFila1.setForeground(new Color(254, 0, 0));	
					}
					if (juego.compareColumns(1)) {
						parcialColumna1.setForeground(new Color(0, 255, 0));
						resultadoColumna1.setForeground(new Color(0, 255, 0));
					}
					else if (juego.parcialColumn(1)>juego.columnResult(1)) {
						parcialColumna1.setForeground(new Color(254,0,0));
						resultadoColumna1.setForeground(new Color(254, 0, 0));	
					}
					if (juego.win())
						JOptionPane.showMessageDialog(frame, "FELICITACIONES!!! \n GANASTE!!!");
					
				}
			}
		});
		f1c1.setHorizontalAlignment(SwingConstants.CENTER);
		f1c1.setBounds(105 , 155 , 60, 60);
		frame.getContentPane().add(f1c1);
		
		//fila 1 columna 2
		f1c2 = new JTextField();
		f1c2.setFont(new Font("Century Gothic", Font.BOLD, 15));
		f1c2.setEditable(false);
		f1c2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isNumeric(f1c2.getText())) {
					int ret12 = Integer.parseInt(f1c2.getText());
					if (ret12>0) {
						f1c2.setEnabled(false);
						juego.inputNumber(ret12, 1, 2);
						parcialFila1.setText(String.valueOf(juego.parcialRow(1)));
						parcialColumna2.setText(String.valueOf(juego.parcialColumn(2)));						
					}
					if (juego.compareRows(1)) {
						parcialFila1.setForeground(new Color(0,255,0));
						resultadoFila1.setForeground(new Color(0, 255, 0));
					}
					else if (juego.parcialRow(1)>juego.rowResult(1)) {
						parcialFila1.setForeground(new Color(254,0,0));
						resultadoFila1.setForeground(new Color(254, 0, 0));	
					}
					if (juego.compareColumns(2)) {
						parcialColumna2.setForeground(new Color(0, 255, 0));
						resultadoColumna2.setForeground(new Color(0, 255, 0));
					}
					else if (juego.parcialColumn(2)>juego.columnResult(2)) {
						parcialColumna2.setForeground(new Color(254,0,0));
						resultadoColumna2.setForeground(new Color(254, 0, 0));	
					}
					if (juego.win())
						JOptionPane.showMessageDialog(frame, "FELICITACIONES!!! \n GANASTE!!!");
					
				}
			}
		});
		f1c2.setHorizontalAlignment(SwingConstants.CENTER);
		f1c2.setBounds(170 , 155 , 60, 60);
		frame.getContentPane().add(f1c2);
		
		//fila 1 columna 3
		f1c3 = new JTextField();
		f1c3.setFont(new Font("Century Gothic", Font.BOLD, 15));
		f1c3.setEditable(false);
		f1c3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isNumeric(f1c3.getText())) {
					int ret13 = Integer.parseInt(f1c3.getText());
					if (ret13>0) {
						f1c3.setEnabled(false);
						juego.inputNumber(ret13, 1, 3);
						parcialFila1.setText(String.valueOf(juego.parcialRow(1)));
						parcialColumna3.setText(String.valueOf(juego.parcialColumn(3)));						
					}
					if (juego.compareRows(1)) {
						parcialFila1.setForeground(new Color(0,255,0));
						resultadoFila1.setForeground(new Color(0, 255, 0));
					}
					else if (juego.parcialRow(1)>juego.rowResult(1)) {
						parcialFila1.setForeground(new Color(254,0,0));
						resultadoFila1.setForeground(new Color(254, 0, 0));	
					}
					if (juego.compareColumns(3)) {
						parcialColumna3.setForeground(new Color(0, 255, 0));
						resultadoColumna3.setForeground(new Color(0, 255, 0));
					}
					else if (juego.parcialColumn(3)>juego.columnResult(3)) {
						parcialColumna3.setForeground(new Color(254,0,0));
						resultadoColumna3.setForeground(new Color(254, 0, 0));	
					}
					if (juego.win())
						JOptionPane.showMessageDialog(frame, "FELICITACIONES!!! \n GANASTE!!!");
					
				}
			}
		});
		f1c3.setHorizontalAlignment(SwingConstants.CENTER);
		f1c3.setBounds(235 , 155 , 60, 60);
		frame.getContentPane().add(f1c3);
		
		//======================== FILA 2 ==============================================
				
		//fila 2 columna 0
		f2c0 = new JTextField();
		f2c0.setFont(new Font("Century Gothic", Font.BOLD, 15));
		f2c0.setEditable(false);
		f2c0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isNumeric(f2c0.getText())) {
					int ret20 = Integer.parseInt(f2c0.getText());
					if (ret20>0) {
						f2c0.setEnabled(false);
						juego.inputNumber(ret20, 2, 0);
						parcialFila2.setText(String.valueOf(juego.parcialRow(2)));
						parcialColumna0.setText(String.valueOf(juego.parcialColumn(0)));						
					}
					if (juego.compareRows(2)) {
						parcialFila2.setForeground(new Color(0,255,0));
						resultadoFila2.setForeground(new Color(0, 255, 0));
					}
					else if (juego.parcialRow(2)>juego.rowResult(2)) {
						parcialFila2.setForeground(new Color(254,0,0));
						resultadoFila2.setForeground(new Color(254, 0, 0));	
					}
					if (juego.compareColumns(0)) {
						parcialColumna0.setForeground(new Color(0, 255, 0));
						resultadoColumna0.setForeground(new Color(0, 255, 0));
					}
					else if (juego.parcialColumn(0)>juego.columnResult(0)) {
						parcialColumna0.setForeground(new Color(254,0,0));
						resultadoColumna0.setForeground(new Color(254, 0, 0));	
					}
					if (juego.win())
						JOptionPane.showMessageDialog(frame, "FELICITACIONES!!! \n GANASTE!!!");
					
				}
			}
		});
		f2c0.setHorizontalAlignment(SwingConstants.CENTER);
		f2c0.setBounds(40 , 220 , 60, 60);
		frame.getContentPane().add(f2c0);
		
		//fila 2 columna 1
		f2c1 = new JTextField();
		f2c1.setFont(new Font("Century Gothic", Font.BOLD, 15));
		f2c1.setEditable(false);
		f2c1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isNumeric(f2c1.getText())) {
					int ret21 = Integer.parseInt(f2c1.getText());
					if (ret21>0) {
						f2c1.setEnabled(false);
						juego.inputNumber(ret21, 2, 1);
						parcialFila2.setText(String.valueOf(juego.parcialRow(2)));
						parcialColumna1.setText(String.valueOf(juego.parcialColumn(1)));						
					}
					if (juego.compareRows(2)) {
						parcialFila2.setForeground(new Color(0,255,0));
						resultadoFila2.setForeground(new Color(0, 255, 0));
					}
					else if (juego.parcialRow(2)>juego.rowResult(2)) {
						parcialFila2.setForeground(new Color(254,0,0));
						resultadoFila2.setForeground(new Color(254, 0, 0));	
					}
					if (juego.compareColumns(1)) {
						parcialColumna1.setForeground(new Color(0, 255, 0));
						resultadoColumna1.setForeground(new Color(0, 255, 0));
					}
					else if (juego.parcialColumn(1)>juego.columnResult(1)) {
						parcialColumna1.setForeground(new Color(254,0,0));
						resultadoColumna1.setForeground(new Color(254, 0, 0));	
					}
					if (juego.win())
						JOptionPane.showMessageDialog(frame, "FELICITACIONES!!! \n GANASTE!!!");
					
				}
			}
		});
		f2c1.setHorizontalAlignment(SwingConstants.CENTER);
		f2c1.setBounds(105 , 220 , 60, 60);
		frame.getContentPane().add(f2c1);
		
		//fila 2 columna 2
		f2c2 = new JTextField();
		f2c2.setFont(new Font("Century Gothic", Font.BOLD, 15));
		f2c2.setEditable(false);
		f2c2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isNumeric(f2c2.getText())) {
					int ret22 = Integer.parseInt(f2c2.getText());
					if (ret22>0) {
						f2c2.setEnabled(false);
						juego.inputNumber(ret22, 2, 2);
						parcialFila2.setText(String.valueOf(juego.parcialRow(2)));
						parcialColumna2.setText(String.valueOf(juego.parcialColumn(2)));						
					}
					if (juego.compareRows(2)) {
						parcialFila2.setForeground(new Color(0,255,0));
						resultadoFila2.setForeground(new Color(0, 255, 0));
					}
					else if (juego.parcialRow(2)>juego.rowResult(2)) {
						parcialFila2.setForeground(new Color(254,0,0));
						resultadoFila2.setForeground(new Color(254, 0, 0));	
					}
					if (juego.compareColumns(2)) {
						parcialColumna2.setForeground(new Color(0, 255, 0));
						resultadoColumna2.setForeground(new Color(0, 255, 0));
					}
					else if (juego.parcialColumn(2)>juego.columnResult(2)) {
						parcialColumna2.setForeground(new Color(254,0,0));
						resultadoColumna2.setForeground(new Color(254, 0, 0));	
					}
					if (juego.win())
						JOptionPane.showMessageDialog(frame, "FELICITACIONES!!! \n GANASTE!!!");
					
				}
			}
		});
		f2c2.setHorizontalAlignment(SwingConstants.CENTER);
		f2c2.setBounds(170 , 220 , 60, 60);
		frame.getContentPane().add(f2c2);
		
		//fila 2 columna 3
		f2c3 = new JTextField();
		f2c3.setFont(new Font("Century Gothic", Font.BOLD, 15));
		f2c3.setEditable(false);
		f2c3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isNumeric(f2c3.getText())) {
					int ret23 = Integer.parseInt(f2c3.getText());
					if (ret23>0) {
						f2c3.setEnabled(false);
						juego.inputNumber(ret23, 2, 3);
						parcialFila2.setText(String.valueOf(juego.parcialRow(2)));
						parcialColumna3.setText(String.valueOf(juego.parcialColumn(3)));						
					}
					if (juego.compareRows(2)) {
						parcialFila2.setForeground(new Color(0,255,0));
						resultadoFila2.setForeground(new Color(0, 255, 0));
					}
					else if (juego.parcialRow(2)>juego.rowResult(2)) {
						parcialFila2.setForeground(new Color(254,0,0));
						resultadoFila2.setForeground(new Color(254, 0, 0));	
					}
					if (juego.compareColumns(3)) {
						parcialColumna3.setForeground(new Color(0, 255, 0));
						resultadoColumna3.setForeground(new Color(0, 255, 0));
					}
					else if (juego.parcialColumn(3)>juego.columnResult(3)) {
						parcialColumna3.setForeground(new Color(254,0,0));
						resultadoColumna3.setForeground(new Color(254, 0, 0));	
					}
					if (juego.win())
						JOptionPane.showMessageDialog(frame, "FELICITACIONES!!! \n GANASTE!!!");
					
				}
			}
		});
		f2c3.setHorizontalAlignment(SwingConstants.CENTER);
		f2c3.setBounds(235 , 220 , 60, 60);
		frame.getContentPane().add(f2c3);

		//======================== FILA 3 ==============================================
		
		//fila 3 columna 0
		f3c0 = new JTextField();
		f3c0.setFont(new Font("Century Gothic", Font.BOLD, 15));
		f3c0.setEditable(false);
		f3c0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isNumeric(f3c0.getText())) {
					int ret30 = Integer.parseInt(f3c0.getText());
					if (ret30>0) {
						f3c0.setEnabled(false);
						juego.inputNumber(ret30, 3, 0);
						parcialFila3.setText(String.valueOf(juego.parcialRow(3)));
						parcialColumna0.setText(String.valueOf(juego.parcialColumn(0)));						
					}
					if (juego.compareRows(3)) {
						parcialFila3.setForeground(new Color(0,255,0));
						resultadoFila3.setForeground(new Color(0, 255, 0));
					}
					else if (juego.parcialRow(3)>juego.rowResult(3)) {
						parcialFila3.setForeground(new Color(254,0,0));
						resultadoFila3.setForeground(new Color(254, 0, 0));	
					}
					if (juego.compareColumns(0)) {
						parcialColumna0.setForeground(new Color(0, 255, 0));
						resultadoColumna0.setForeground(new Color(0, 255, 0));
					}
					else if (juego.parcialColumn(0)>juego.columnResult(0)) {
						parcialColumna0.setForeground(new Color(254,0,0));
						resultadoColumna0.setForeground(new Color(254, 0, 0));	
					}
					if (juego.win())
						JOptionPane.showMessageDialog(frame, "FELICITACIONES!!! \n GANASTE!!!");
					
				}
			}
		});
		f3c0.setHorizontalAlignment(SwingConstants.CENTER);
		f3c0.setBounds(40 , 285 , 60, 60);
		frame.getContentPane().add(f3c0);
		
		//fila 3 columna 1
		f3c1 = new JTextField();
		f3c1.setFont(new Font("Century Gothic", Font.BOLD, 15));
		f3c1.setEditable(false);
		f3c1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isNumeric(f3c1.getText())) {
					int ret31 = Integer.parseInt(f3c1.getText());
					if (ret31>0) {
						f3c1.setEnabled(false);
						juego.inputNumber(ret31, 3, 1);
						parcialFila3.setText(String.valueOf(juego.parcialRow(3)));
						parcialColumna1.setText(String.valueOf(juego.parcialColumn(1)));						
					}
					if (juego.compareRows(3)) {
						parcialFila3.setForeground(new Color(0,255,0));
						resultadoFila3.setForeground(new Color(0, 255, 0));
					}
					else if (juego.parcialRow(3)>juego.rowResult(3)) {
						parcialFila3.setForeground(new Color(254,0,0));
						resultadoFila3.setForeground(new Color(254, 0, 0));	
					}
					if (juego.compareColumns(1)) {
						parcialColumna1.setForeground(new Color(0, 255, 0));
						resultadoColumna1.setForeground(new Color(0, 255, 0));
					}
					else if (juego.parcialColumn(1)>juego.columnResult(1)) {
						parcialColumna1.setForeground(new Color(254,0,0));
						resultadoColumna1.setForeground(new Color(254, 0, 0));	
					}
					if (juego.win())
						JOptionPane.showMessageDialog(frame, "FELICITACIONES!!! \n GANASTE!!!");
					
				}
			}
		});
		f3c1.setHorizontalAlignment(SwingConstants.CENTER);
		f3c1.setBounds(105 , 285 , 60, 60);
		frame.getContentPane().add(f3c1);
		
		//fila 3 columna 2
		f3c2 = new JTextField();
		f3c2.setFont(new Font("Century Gothic", Font.BOLD, 15));
		f3c2.setEditable(false);
		f3c2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isNumeric(f3c2.getText())) {
					int ret32 = Integer.parseInt(f3c2.getText());
					if (ret32>0) {
						f3c2.setEnabled(false);
						juego.inputNumber(ret32, 3, 2);
						parcialFila3.setText(String.valueOf(juego.parcialRow(3)));
						parcialColumna2.setText(String.valueOf(juego.parcialColumn(2)));						
					}
					if (juego.compareRows(3)) {
						parcialFila3.setForeground(new Color(0,255,0));
						resultadoFila3.setForeground(new Color(0, 255, 0));
					}
					else if (juego.parcialRow(3)>juego.rowResult(3)) {
						parcialFila3.setForeground(new Color(254,0,0));
						resultadoFila3.setForeground(new Color(254, 0, 0));	
					}
					if (juego.compareColumns(2)) {
						parcialColumna2.setForeground(new Color(0, 255, 0));
						resultadoColumna2.setForeground(new Color(0, 255, 0));
					}
					else if (juego.parcialColumn(2)>juego.columnResult(2)) {
						parcialColumna2.setForeground(new Color(254,0,0));
						resultadoColumna2.setForeground(new Color(254, 0, 0));	
					}
					if (juego.win())
						JOptionPane.showMessageDialog(frame, "FELICITACIONES!!! \n GANASTE!!!");
					
				}
			}
		});
		f3c2.setHorizontalAlignment(SwingConstants.CENTER);
		f3c2.setBounds(170 , 285 , 60, 60);
		frame.getContentPane().add(f3c2);
		
		//fila 3 columna 3
		f3c3 = new JTextField();
		f3c3.setFont(new Font("Century Gothic", Font.BOLD, 15));
		f3c3.setEditable(false);
		f3c3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isNumeric(f3c3.getText())) {
					int ret33 = Integer.parseInt(f3c3.getText());
					if (ret33>0) {
						f3c3.setEnabled(false);
						juego.inputNumber(ret33, 3, 3);
						parcialFila3.setText(String.valueOf(juego.parcialRow(3)));
						parcialColumna3.setText(String.valueOf(juego.parcialColumn(3)));						
					}
					if (juego.compareRows(3)) {
						parcialFila3.setForeground(new Color(0,255,0));
						resultadoFila3.setForeground(new Color(0, 255, 0));
					}
					else if (juego.parcialRow(3)>juego.rowResult(3)) {
						parcialFila3.setForeground(new Color(254,0,0));
						resultadoFila3.setForeground(new Color(254, 0, 0));	
					}
					if (juego.compareColumns(3)) {
						parcialColumna3.setForeground(new Color(0, 255, 0));
						resultadoColumna3.setForeground(new Color(0, 255, 0));
					}
					else if (juego.parcialColumn(3)>juego.columnResult(3)) {
						parcialColumna3.setForeground(new Color(254,0,0));
						resultadoColumna3.setForeground(new Color(254, 0, 0));	
					}
					if (juego.win())
						if (juego.win())
							JOptionPane.showMessageDialog(frame, "FELICITACIONES!!! \n GANASTE!!!");					
				}
			}
		});
		f3c3.setHorizontalAlignment(SwingConstants.CENTER);
		f3c3.setBounds(235 , 285 , 60, 60);
		frame.getContentPane().add(f3c3);
		
		
		//===================== RESULTADOS PARCIALES ===================================
		
		//parcial fila 0
		parcialFila0 = new JLabel("0");
		parcialFila0.setFont(new Font("Tahoma", Font.BOLD, 11));
		parcialFila0.setHorizontalAlignment(SwingConstants.CENTER);
		parcialFila0.setForeground(new Color(255, 140, 0));
		parcialFila0.setBounds(300, 90, 60, 60);
		frame.getContentPane().add(parcialFila0);
		
		//parcial fila 1
		parcialFila1 = new JLabel("0");
		parcialFila1.setFont(new Font("Tahoma", Font.BOLD, 11));
		parcialFila1.setHorizontalAlignment(SwingConstants.CENTER);
		parcialFila1.setForeground(new Color(255, 140, 0));
		parcialFila1.setBounds(300, 155, 60, 60);
		frame.getContentPane().add(parcialFila1);
		
		//parcial fila 2
		parcialFila2 = new JLabel("0");
		parcialFila2.setFont(new Font("Tahoma", Font.BOLD, 11));
		parcialFila2.setHorizontalAlignment(SwingConstants.CENTER);
		parcialFila2.setForeground(new Color(255, 140, 0));
		parcialFila2.setBounds(300, 220, 60, 60);
		frame.getContentPane().add(parcialFila2);
		
		//parcial fila 3
		parcialFila3 = new JLabel("0");
		parcialFila3.setFont(new Font("Tahoma", Font.BOLD, 11));
		parcialFila3.setHorizontalAlignment(SwingConstants.CENTER);
		parcialFila3.setForeground(new Color(255, 140, 0));
		parcialFila3.setBounds(300, 285, 60, 60);
		frame.getContentPane().add(parcialFila3);
		
		//parcial columna 0
		parcialColumna0 = new JLabel("0");
		parcialColumna0.setFont(new Font("Tahoma", Font.BOLD, 11));
		parcialColumna0.setHorizontalAlignment(SwingConstants.CENTER);
		parcialColumna0.setForeground(new Color(255, 140, 0));
		parcialColumna0.setBounds(40, 350, 60, 60);
		frame.getContentPane().add(parcialColumna0);		
		
		//parcial columna 1
		parcialColumna1 = new JLabel("0");
		parcialColumna1.setFont(new Font("Tahoma", Font.BOLD, 11));
		parcialColumna1.setHorizontalAlignment(SwingConstants.CENTER);
		parcialColumna1.setForeground(new Color(255, 140, 0));
		parcialColumna1.setBounds(105, 350, 60, 60);
		frame.getContentPane().add(parcialColumna1);
		
		//parcial columna 2
		parcialColumna2 = new JLabel("0");
		parcialColumna2.setFont(new Font("Tahoma", Font.BOLD, 11));
		parcialColumna2.setHorizontalAlignment(SwingConstants.CENTER);
		parcialColumna2.setForeground(new Color(255, 140, 0));
		parcialColumna2.setBounds(170, 350, 60, 60);
		frame.getContentPane().add(parcialColumna2);
		
		//parcial columna 3
		parcialColumna3 = new JLabel("0");
		parcialColumna3.setFont(new Font("Tahoma", Font.BOLD, 11));
		parcialColumna3.setHorizontalAlignment(SwingConstants.CENTER);
		parcialColumna3.setForeground(new Color(255, 140, 0));
		parcialColumna3.setBounds(235, 350, 60, 60);
		frame.getContentPane().add(parcialColumna3);
		
		
		
		
		//===================== RESULTADOS ESPERADOS ===================================
		
		resultadoFila0 = new JLabel("New label");
		resultadoFila0.setVisible(false);
		resultadoFila0.setFont(new Font("Century Gothic", Font.BOLD, 20));
		String row0 = String.valueOf(juego.rowResult(0));
		resultadoFila0.setText(row0);
		resultadoFila0.setBackground(new Color(112, 128, 144));
		resultadoFila0.setHorizontalAlignment(SwingConstants.CENTER);
		resultadoFila0.setBounds(365, 90, 60, 60);
		frame.getContentPane().add(resultadoFila0);
		
		resultadoFila1 = new JLabel("New label");
		resultadoFila1.setVisible(false);
		resultadoFila1.setFont(new Font("Century Gothic", Font.BOLD, 20));
		String row1 = String.valueOf(juego.rowResult(1));
		resultadoFila1.setText(row1);
		resultadoFila1.setBackground(new Color(112, 128, 144));
		resultadoFila1.setHorizontalAlignment(SwingConstants.CENTER);
		resultadoFila1.setBounds(365, 155, 60, 60);
		frame.getContentPane().add(resultadoFila1);
		
		resultadoFila2 = new JLabel("New label");
		resultadoFila2.setVisible(false);
		resultadoFila2.setFont(new Font("Century Gothic", Font.BOLD, 20));
		String row2 = String.valueOf(juego.rowResult(2));
		resultadoFila2.setText(row2);
		resultadoFila2.setBackground(new Color(112, 128, 144));
		resultadoFila2.setHorizontalAlignment(SwingConstants.CENTER);
		resultadoFila2.setBounds(365, 220, 60, 60);
		frame.getContentPane().add(resultadoFila2);
		
		resultadoFila3 = new JLabel("New label");
		resultadoFila3.setVisible(false);
		resultadoFila3.setFont(new Font("Century Gothic", Font.BOLD, 20));
		String row3 = String.valueOf(juego.rowResult(3));
		resultadoFila3.setText(row3);
		resultadoFila3.setBackground(new Color(112, 128, 144));
		resultadoFila3.setHorizontalAlignment(SwingConstants.CENTER);
		resultadoFila3.setBounds(365, 285, 60, 60);
		frame.getContentPane().add(resultadoFila3);
		
		resultadoColumna0 = new JLabel("New label");
		resultadoColumna0.setVisible(false);
		resultadoColumna0.setFont(new Font("Century Gothic", Font.BOLD, 20));
		String column0 = String.valueOf(juego.columnResult(0));
		resultadoColumna0.setText(column0);
		resultadoColumna0.setBackground(new Color(112, 128, 144));
		resultadoColumna0.setHorizontalAlignment(SwingConstants.CENTER);
		resultadoColumna0.setBounds(40, 415, 60, 60);
		frame.getContentPane().add(resultadoColumna0);
		
		resultadoColumna1 = new JLabel("New label");
		resultadoColumna1.setVisible(false);
		resultadoColumna1.setFont(new Font("Century Gothic", Font.BOLD, 20));
		String column1 = String.valueOf(juego.columnResult(1));
		resultadoColumna1.setText(column1);
		resultadoColumna1.setBackground(new Color(112, 128, 144));
		resultadoColumna1.setHorizontalAlignment(SwingConstants.CENTER);
		resultadoColumna1.setBounds(105, 415, 60, 60);
		frame.getContentPane().add(resultadoColumna1);
		
		resultadoColumna2 = new JLabel("New label");
		resultadoColumna2.setVisible(false);
		resultadoColumna2.setFont(new Font("Century Gothic", Font.BOLD, 20));
		String column2 = String.valueOf(juego.columnResult(2));
		resultadoColumna2.setText(column2);
		resultadoColumna2.setBackground(new Color(112, 128, 144));
		resultadoColumna2.setHorizontalAlignment(SwingConstants.CENTER);
		resultadoColumna2.setBounds(170, 415, 60, 60);
		frame.getContentPane().add(resultadoColumna2);
		
		resultadoColumna3 = new JLabel("New label");
		resultadoColumna3.setVisible(false);
		resultadoColumna3.setFont(new Font("Century Gothic", Font.BOLD, 20));
		String column3 = String.valueOf(juego.columnResult(3));
		resultadoColumna3.setText(column3);
		resultadoColumna3.setBackground(new Color(112, 128, 144));
		resultadoColumna3.setHorizontalAlignment(SwingConstants.CENTER);
		resultadoColumna3.setBounds(235, 415, 60, 60);
		frame.getContentPane().add(resultadoColumna3);
		
		JLabel lblSubtotal = new JLabel("SUMA PARCIAL");
		lblSubtotal.setForeground(new Color(255, 140, 0));
		lblSubtotal.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblSubtotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubtotal.setBounds(454, 11, 120, 40);
		frame.getContentPane().add(lblSubtotal);
		
		JLabel lblObjetivo = new JLabel("RESULTADO");
		lblObjetivo.setForeground(Color.BLACK);
		lblObjetivo.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblObjetivo.setHorizontalAlignment(SwingConstants.CENTER);
		lblObjetivo.setBounds(460, 49, 120, 40);
		frame.getContentPane().add(lblObjetivo);
		
		JLabel lblYNicotorresel = new JLabel("By nicotorresel");
		lblYNicotorresel.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblYNicotorresel.setBounds(6, 474, 94, 27);
		frame.getContentPane().add(lblYNicotorresel);
	}
	
	// METODOS AUXILIARES
	
	
	//devuelve true si el string pasasdo por parametro tiene equivalenta en formato entero
	public static boolean isNumeric(String string) {
	    if (string == null) {
	        return false;
	    }
	    try {
	        Integer.parseInt(string);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
}
