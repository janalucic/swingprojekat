package modifyDlg;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Point;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class DlgPointModify extends JDialog {

	private final JPanel pnlCenter = new JPanel();
	private JButton btnModify;
	private JButton btnCancel;
	private JLabel lblModifyPoint;
	private JLabel lblXCoordinate;
	private JLabel lblYCoordinate;
	private JButton btnChooseColor;
	private JTextField txtCX;
	private JTextField txtCY;

	private Point point;
	private Color colorPoint;
	
	
	
	public static void main(String[] args) {
		try {
			DlgPointModify dialog = new DlgPointModify();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgPointModify() {
		setBounds(100, 100, 350, 270);
		setTitle("Modify Point");
		setResizable(false);
		setModal(true);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		pnlCenter.setBackground(new Color(250, 128, 114));
		pnlCenter.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnlCenter, BorderLayout.CENTER);
		lblModifyPoint = new JLabel("Point Modify");
		lblModifyPoint.setFont(new Font("Arial", Font.BOLD, 18));
		lblXCoordinate = new JLabel("X coordinate:");
		lblXCoordinate.setFont(new Font("Arial", Font.BOLD, 15));
		lblYCoordinate = new JLabel("Y coordinate:");
		lblYCoordinate.setFont(new Font("Arial", Font.BOLD, 15));
		btnChooseColor = new JButton("Choose color");
		btnChooseColor.setBackground(new Color(248, 248, 255));
		btnChooseColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				colorPoint = JColorChooser.showDialog(null, "Choose POINT color", point.getColor());
				if(colorPoint==null){
					colorPoint=point.getColor();
				}
				//txtColorPoint.setBackground(colorPoint);
			}
		});
		btnChooseColor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtCX = new JTextField();
		txtCX.setColumns(10);
		txtCY = new JTextField();
		txtCY.setColumns(10);
		GroupLayout gl_pnlCenter = new GroupLayout(pnlCenter);
		gl_pnlCenter.setHorizontalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addGap(100)
					.addComponent(lblModifyPoint)
					.addContainerGap(137, Short.MAX_VALUE))
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblYCoordinate)
						.addComponent(lblXCoordinate))
					.addPreferredGap(ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING, false)
						.addComponent(txtCY)
						.addComponent(txtCX, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))
					.addContainerGap(32, Short.MAX_VALUE))
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addGap(110)
					.addComponent(btnChooseColor)
					.addContainerGap(109, Short.MAX_VALUE))
		);
		gl_pnlCenter.setVerticalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblModifyPoint)
					.addGap(18)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblXCoordinate)
						.addComponent(txtCX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblYCoordinate)
						.addComponent(txtCY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
					.addComponent(btnChooseColor)
					.addGap(20))
		);
		pnlCenter.setLayout(gl_pnlCenter);
		{
			JPanel pnlSouth = new JPanel();
			pnlSouth.setBackground(new Color(255, 222, 173));
			getContentPane().add(pnlSouth, BorderLayout.SOUTH);
			{
				btnModify = new JButton("Modify");
				btnModify.setBackground(new Color(248, 248, 255));
				btnModify.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(txtCX.getText().trim().equals("") || txtCY.getText().trim().equals("")){
							JOptionPane.showMessageDialog(null, "Fields are empty! Please insert values!", "ERROR", JOptionPane.ERROR_MESSAGE, null);
							return;
						}
						try {
							int coordinateX = Integer.parseInt(txtCX.getText());
							int coordinateY = Integer.parseInt(txtCY.getText());
							point.setX(coordinateX);
							point.setY(coordinateY);
							point.setColor(colorPoint);
							dispose();
						} catch (NumberFormatException exc) {
							JOptionPane.showMessageDialog(null, "Incorrect data type inserted, please insert data again!", "ERROR", JOptionPane.ERROR_MESSAGE, null);
						}
					}
				});
				btnModify.setFont(new Font("Tahoma", Font.PLAIN, 15));
				btnModify.setActionCommand("OK");
				getRootPane().setDefaultButton(btnModify);
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
						.addGap(76)
						.addComponent(btnModify)
						.addGap(40)
						.addComponent(btnCancel)
						.addGap(216))
			);
			gl_pnlSouth.setVerticalGroup(
				gl_pnlSouth.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_pnlSouth.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_pnlSouth.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnModify)
							.addComponent(btnCancel))
						.addContainerGap())
			);
			pnlSouth.setLayout(gl_pnlSouth);
		}
	}
	public void fillAll(Point pointModify) {
		this.point = pointModify;
		txtCX.setText(String.valueOf(point.getX()));
		txtCY.setText(String.valueOf(point.getY()));
		colorPoint = point.getColor();
		//txtColorPoint.setBackground(colorPoint);
		}
}
