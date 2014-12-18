import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JProgressBar;
public class Main extends JFrame {

    private LSB l=null;
   
	StringBuilder log= new StringBuilder();
	
	private static final long serialVersionUID = 1L;
	
	private JTextField textField = null;
	
	private JTextField textField_1 = null;
	
	private File fileI = null ,fileO = null ;
	
//	private JTextField textField_2 = null;
	
	private JLabel lblNewLabel = new JLabel("Откуда");
	
	private JButton btnNewButton = new JButton(". . .");
	
	private JLabel lblNewLabel_1 = new JLabel("Куда");
	
	private JButton btnNewButton_1 = new JButton(". . .");
	
	private JButton btnNewButton_2 = new JButton("Положить");
	
	private JButton btnNewButton_3 = new JButton("Вытащить");
	
	//private JLabel lblNewLabel_2 = new JLabel("Information:");
	
	private JProgressBar progressBar = new JProgressBar();
	
	byte Bin[] = null , Bout[] = null;//read data from files into them
	
	long a = 0 , b = 0;//size of fileI and fileO
	
	private final JLabel lblNewLabel_3 = new JLabel("Прогресс");
	
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,300);
		setTitle("Лабораторная работа ЛСБ. Мария Алисова. 2014.");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);	
				
	//	textField_2 = new JTextField();
	//	textField_2.setColumns(10);
		
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_1)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textField)
								.addComponent(textField_1, 432, 432, Short.MAX_VALUE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addGroup(groupLayout.createSequentialGroup()
									//	.addComponent(lblNewLabel_2)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnNewButton_3))
									//.addComponent(textField_2, 432, 432, Short.MAX_VALUE)
									)
								.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, 432, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(btnNewButton_2, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE))
						.addComponent(lblNewLabel_3))
					.addGap(73))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(18)
					.addComponent(lblNewLabel)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addGap(18)
					.addComponent(lblNewLabel_1)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1))
					.addGap(18)
					.addComponent(lblNewLabel_3)
					.addGap(18)
					.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						//.addComponent(lblNewLabel_2)
						.addComponent(btnNewButton_3)
						.addComponent(btnNewButton_2))
					.addGap(18)
				//	.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(64))
		);
		getContentPane().setLayout(groupLayout);
		setVisible(true);
		
		
		 // Processing button ". . ."
		btnNewButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){				
				JFileChooser fileopen = new JFileChooser();          
					int ret = fileopen.showDialog(null, "Open file");
						if (ret == JFileChooser.APPROVE_OPTION) {
							fileI = fileopen.getSelectedFile(); 
							textField.setText(fileI.getAbsolutePath());
			}}});
		
		 // Processing button ". . ." 2
		btnNewButton_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){				
				JFileChooser fileopen = new JFileChooser();           
					int ret = fileopen.showDialog(null, "Open file");
						if (ret == JFileChooser.APPROVE_OPTION) {
							fileO = fileopen.getSelectedFile(); 
							textField_1.setText(fileO.getAbsolutePath());   
			}}});
		
		
		 // Processing button " ENCRYPT"
		btnNewButton_2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){			
							
							if(b/8>a) 
							{
								INF ("Encoding immposible, too big source file");
								
							}
							else{
							l = new LSB(fileI,fileO,progressBar);
							l.encrypt();
							}
			}});
		
		 // Processing button " DECRYPT"
		btnNewButton_3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){	
				l = new LSB(fileI,fileO,progressBar);
				l.decrypt();
			}});
		
}
	
	
	

//FUNCTION PRINT ERROR IN TEXTFIELD	
	public void INF (String message)
	
	{		
		log=log.append(message+"\n");
	//	textField_2.setText(message);
	}
}
