import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class GUI extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Controller controller = new Controller();
	
	protected JButton fpga, jpga;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public GUI() {
		controller.setSsdd(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 275, 100);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	
		fpga = new JButton("FPGA");
		fpga.setBounds(10, 10, 91, 23);
		contentPane.add(fpga);
		fpga.addActionListener(this);
		
		
		jpga = new JButton("JPGA");
		jpga.setBounds(150, 10, 91, 23);
		contentPane.add(jpga);
		jpga.addActionListener(this);
				

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton)e.getSource();
		
		if(source==jpga) {
			jpgaButtonListener();
			return;
		}
		else {
			fpgaButtonListener();
			return;
		}
		
		
	}
	private void jpgaButtonListener(){
		System.out.println("jpgaButtonListener");
		controller.doJPGAButtonAction();
	}
	private void fpgaButtonListener(){
		System.out.println("fpgaButtonListener");
		controller.doFPGAButtonAction();			
	}

	

}
