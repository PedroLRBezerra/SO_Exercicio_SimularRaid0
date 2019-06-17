package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DisksUsageView extends JFrame {

	private JPanel contentPane;
	private int altura;
	JTable disksTables [];
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				int qtyDisks=Integer.parseInt(JOptionPane.showInputDialog("Digite a Quantidade de discos"));
				try {
					DisksUsageView frame = new DisksUsageView(qtyDisks);
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
	public DisksUsageView(int qtyDisks) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JButton btnEnviarArquivo = new JButton("Salvar Arquivo");
		btnEnviarArquivo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sendFileSize();
			}
		});
		btnEnviarArquivo.setBounds(900, qtyDisks*90, 150, 25);
		contentPane.add(btnEnviarArquivo);
		addDisks(qtyDisks);
		setBounds(100, 100, 1200, (qtyDisks*120));
	}
	
	private void sendFileSize() {
		
	}

	public void addDisks(int qtyDisk) {
		disksTables = new JTable[qtyDisk]; 
		JScrollPane rollBar[]=new JScrollPane[qtyDisk];
		JLabel lblDisk[]=new JLabel[qtyDisk+1];
		for(int disk=0;disk<qtyDisk;disk++) {
			lblDisk[disk]=new JLabel("Disco "+disk+" : ");
			lblDisk[disk].setBounds(17, 15+((disk)*74), 70, 10);
			disksTables[disk]=new JTable(createRow(32),createColumnNames(32));
			rollBar[disk] = new JScrollPane(disksTables[disk]);
			rollBar[disk].setBounds(70,((disk)*70), 1100, 50);
			this.contentPane.add(rollBar[disk]);
			this.contentPane.add(lblDisk[disk]);
		}
		lblDisk[qtyDisk]=new JLabel("");
		lblDisk[qtyDisk].setBounds(15, 15+((qtyDisk)*75), 70, 10);
		this.contentPane.add(lblDisk[qtyDisk]);	
	}
	
	public String[] createColumnNames(int qty) {
		String [] column=new String[qty];   
		for(int x=0;x<qty;x++) {
			column[x]=x+"";
		}
		return column;
	}
	
	public Object[][] createRow(int qty) {
		Object row [][]=new Object[1][qty];
		for(int x=0;x<qty;x++) {
			row[0][x]="0/32";
		}
		return row;
	}

}
