package dialogues;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

@SuppressWarnings("serial")
public class DlgDrawDonut extends JDialog {

	private final JPanel pnlCenter = new JPanel();
	private boolean isOk;
	private JButton btnDraw;
	private JButton btnCancel;
	private JTextField txtDonutRadius;
	private JTextField txtDonutInnerRadius;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgDrawDonut dialog = new DlgDrawDonut();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgDrawDonut() {
		setBackground(new Color(255, 228, 196));
		setBounds(100, 100, 350, 250);
		setTitle("Draw Donut");
		setModal(true);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		pnlCenter.setBackground(new Color(250, 128, 114));
		pnlCenter.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnlCenter, BorderLayout.CENTER);
		JLabel lblDonut = new JLabel("Donut");
		lblDonut.setFont(new Font("Arial", Font.BOLD, 18));
		JLabel lblRadius = new JLabel("Radius:");
		lblRadius.setFont(new Font("Arial", Font.BOLD, 15));
		JLabel lblInnerRadius = new JLabel("Inner radius:");
		lblInnerRadius.setFont(new Font("Arial", Font.BOLD, 15));
		txtDonutRadius = new JTextField();
		txtDonutRadius.setColumns(10);
		txtDonutInnerRadius = new JTextField();
		txtDonutInnerRadius.setColumns(10);
		GroupLayout gl_pnlCenter = new GroupLayout(pnlCenter);
		gl_pnlCenter.setHorizontalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addGap(32)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
						.addComponent(lblInnerRadius)
						.addComponent(lblRadius))
					.addGap(18)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING, false)
						.addComponent(txtDonutRadius)
						.addComponent(txtDonutInnerRadius))
					.addContainerGap())
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addGap(134)
					.addComponent(lblDonut)
					.addContainerGap(152, Short.MAX_VALUE))
		);
		gl_pnlCenter.setVerticalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblDonut)
					.addGap(26)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRadius)
						.addComponent(txtDonutRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblInnerRadius)
						.addComponent(txtDonutInnerRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(35, Short.MAX_VALUE))
		);
		pnlCenter.setLayout(gl_pnlCenter);
		{
			JPanel pnlSouth = new JPanel();
			pnlSouth.setBackground(new Color(255, 218, 185));
			getContentPane().add(pnlSouth, BorderLayout.SOUTH);
			{
				btnDraw = new JButton("Draw");
				btnDraw.setBackground(new Color(248, 248, 255));
				btnDraw.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(txtDonutRadius.getText().trim().equals("") || txtDonutInnerRadius.getText().trim().equals("")){
							getToolkit().beep();
							JOptionPane.showMessageDialog(null, "Some fields are empty!", "Error", JOptionPane.ERROR_MESSAGE, null);
							isOk = false;
							return;
						}
						try {
							validate(txtDonutRadius.getText(),txtDonutInnerRadius.getText());
						} catch (NumberFormatException exc) {
							getToolkit().beep();
							JOptionPane.showMessageDialog(null, "Please insert a valid data type!", "Error", JOptionPane.ERROR_MESSAGE, null);
							isOk = false;
							return;
						}
						
						if(Integer.parseInt(txtDonutRadius.getText()) < 1 || Integer.parseInt(txtDonutInnerRadius.getText()) <1){
							getToolkit().beep();
							JOptionPane.showMessageDialog(null, "Radius or inner radius can't be less than 1", "Error", JOptionPane.ERROR_MESSAGE, null);
							isOk = false;
							return;
						}else if(Integer.parseInt(txtDonutRadius.getText()) < Integer.parseInt(txtDonutInnerRadius.getText())){
							getToolkit().beep();
							JOptionPane.showMessageDialog(null, "Radius must be greater than Inner Radius!", "Error", JOptionPane.ERROR_MESSAGE, null);
							isOk = false;
							return;
						}else if(Integer.parseInt(txtDonutRadius.getText()) == Integer.parseInt(txtDonutInnerRadius.getText())){
								getToolkit().beep();
								JOptionPane.showMessageDialog(null, "Radius can't be equal to Inner Radius!", "Error", JOptionPane.ERROR_MESSAGE, null);
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
				btnDraw.setActionCommand("OK");
				getRootPane().setDefaultButton(btnDraw);
			}
			{
				btnCancel = new JButton("Cancel");
				btnCancel.setBackground(new Color(248, 248, 255));
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
				btnCancel.setActionCommand("Cancel");
			}
			GroupLayout gl_pnlSouth = new GroupLayout(pnlSouth);
			gl_pnlSouth.setHorizontalGroup(
				gl_pnlSouth.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnlSouth.createSequentialGroup()
						.addGap(88)
						.addComponent(btnDraw)
						.addGap(18)
						.addComponent(btnCancel)
						.addGap(98))
			);
			gl_pnlSouth.setVerticalGroup(
				gl_pnlSouth.createParallelGroup(Alignment.LEADING)
					.addGroup(Alignment.TRAILING, gl_pnlSouth.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_pnlSouth.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnDraw)
							.addComponent(btnCancel))
						.addContainerGap())
			);
			pnlSouth.setLayout(gl_pnlSouth);
		}
	}
	public void validate(String radius, String innerRadius) {
		String supp = "^(([+-])?([1-9]{1})([0-9]+)?)$";
        if(!radius.matches(supp)|| !innerRadius.matches(supp)){  
        	throw new NumberFormatException();
        }
	}

	public boolean isOk() {
		return isOk;
	}

	public void setOk(boolean isOk) {
		this.isOk = isOk;
	}

	public JTextField getTxtDonutRadius() {
		return txtDonutRadius;
	}

	public void setTxtDonutRadius(JTextField txtDonutRadius) {
		this.txtDonutRadius = txtDonutRadius;
	}

	public JTextField getTxtDonutInnerRadius() {
		return txtDonutInnerRadius;
	}

	public void setTxtDonutInnerRadius(JTextField txtDonutInnerRadius) {
		this.txtDonutInnerRadius = txtDonutInnerRadius;
	}
}
