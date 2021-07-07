package dialogues;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

@SuppressWarnings("serial")
public class DlgDrawCircle extends JDialog {
	
	private JTextField txtRadius;
	private boolean isOk;
	
	public static void main(String[] args) {
		try {
			DlgDrawCircle dialog = new DlgDrawCircle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgDrawCircle() {
		setBounds(100, 100, 226, 227);
		setTitle("Draw circle");
		setResizable(false);
		setModal(true);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel pnlSouth = new JPanel();
		pnlSouth.setBackground(new Color(255, 222, 173));
		getContentPane().add(pnlSouth, BorderLayout.SOUTH);
		
		JButton btnDraw = new JButton("Draw");
		btnDraw.setBackground(new Color(248, 248, 255));
		btnDraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtRadius.getText().trim().equals("")){
					getToolkit().beep();
					JOptionPane.showMessageDialog(null, "Please insert radius!", "Error", JOptionPane.ERROR_MESSAGE, null);
					isOk = false;
					return;
				}
				try {
					validate(txtRadius.getText());
				} catch (NumberFormatException exc) {
					getToolkit().beep();
					JOptionPane.showMessageDialog(null, "Please insert valid data type!", "Error", JOptionPane.ERROR_MESSAGE, null);
					isOk = false;
					return;
				}if(Integer.parseInt(txtRadius.getText()) < 0){
					getToolkit().beep();
					JOptionPane.showMessageDialog(null, "Radius must be a positive number!", "Error", JOptionPane.ERROR_MESSAGE, null);
					isOk = false;
					return;
				}else{
					isOk = true;
					dispose();
				}
			}
		}
			
			);
		btnDraw.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pnlSouth.add(btnDraw);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBackground(new Color(248, 248, 255));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					dispose();
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pnlSouth.add(btnCancel);
		
		JPanel pnlCenter = new JPanel();
		pnlCenter.setBackground(new Color(255, 160, 122));
		getContentPane().add(pnlCenter, BorderLayout.CENTER);
		
		JLabel lblRadius = new JLabel("Radius:");
		lblRadius.setFont(new Font("Arial", Font.BOLD, 15));
		
		txtRadius = new JTextField();
		txtRadius.setColumns(10);
		
		JLabel lblDrawCircle = new JLabel("Circle");
		lblDrawCircle.setFont(new Font("Arial", Font.BOLD, 18));
		GroupLayout gl_pnlCenter = new GroupLayout(pnlCenter);
		gl_pnlCenter.setHorizontalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addContainerGap(51, Short.MAX_VALUE)
					.addComponent(lblRadius)
					.addGap(18)
					.addComponent(txtRadius, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
					.addGap(28))
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblDrawCircle)
					.addContainerGap(201, Short.MAX_VALUE))
		);
		gl_pnlCenter.setVerticalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addGap(18)
					.addComponent(lblDrawCircle)
					.addGap(18)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRadius)
						.addComponent(txtRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(57, Short.MAX_VALUE))
		);
		pnlCenter.setLayout(gl_pnlCenter);
	}

	
	public void validate(String radius) {
		String supp = "^(([+-])?([1-9]{1})([0-9]+)?)$";
        if(!radius.matches(supp)){  
        	throw new NumberFormatException();
        }
	}
	
	
	public JTextField getTxtRadius() {
		return txtRadius;
	}

	public void setTxtRadius(JTextField txtRadius) {
		this.txtRadius = txtRadius;
	}

	public boolean isOk() {
		return isOk;
	}

	public void setOk(boolean isOk) {
		this.isOk = isOk;
	}
}
