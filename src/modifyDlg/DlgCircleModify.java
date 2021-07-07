  package modifyDlg;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Circle;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

@SuppressWarnings("serial")
public class DlgCircleModify extends JDialog {

	private final JPanel pnlCenter = new JPanel();
	private JButton btnModify;
	private JButton cancelButton;
	private JLabel lblCenterOfX;
	private JLabel lblCenterYCoordinate;
	private JLabel lblRadius;
	private JTextField txtXcoordinate;
	private JTextField txtYcoordinate;
	private JTextField txtRadius;
	
	private Circle circle;
	private Color edgeColor = Color.black;
	private Color innerColor = Color.white;
	private JButton btnChooseEdgeColor;
	private JButton btnChooseInnerColor;

	
	public static void main(String[] args) {
		try {
			DlgCircleModify dialog = new DlgCircleModify();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public DlgCircleModify() {
		setBounds(100, 100, 400, 370);
		setTitle("Modify Circle");
		setModal(true);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		pnlCenter.setBackground(new Color(250, 128, 114));
		pnlCenter.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnlCenter, BorderLayout.CENTER);
		
		JLabel lblCircleModify = new JLabel("Circle Modify");
		lblCircleModify.setFont(new Font("Arial", Font.BOLD, 18));
		lblCenterOfX = new JLabel("Center X coordinate:");
		lblCenterOfX.setFont(new Font("Arial", Font.BOLD, 15));
		lblCenterYCoordinate = new JLabel("Center Y coordinate:");
		lblCenterYCoordinate.setFont(new Font("Arial", Font.BOLD, 15));
		lblRadius = new JLabel("Radius:");
		lblRadius.setFont(new Font("Arial", Font.BOLD, 15));
		
		txtXcoordinate = new JTextField();
		txtXcoordinate.setColumns(10);
		
		txtYcoordinate = new JTextField();
		txtYcoordinate.setColumns(10);
		
		txtRadius = new JTextField();
		txtRadius.setColumns(10);
		
		btnChooseEdgeColor = new JButton("Choose edge color");
		btnChooseEdgeColor.setBackground(new Color(248, 248, 255));
		btnChooseEdgeColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				edgeColor = JColorChooser.showDialog(null, "SELECT CIRCLE COLOR", edgeColor);
				if(edgeColor==null){
					edgeColor=Color.black;
					//txtEdgeColor.setBackground(Color.black);
					
				}else{
					//txtEdgeColor.setBackground(edgeColor);
				}
				
			}
		});
		btnChooseEdgeColor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		btnChooseInnerColor = new JButton("Choose inner color");
		btnChooseInnerColor.setBackground(new Color(248, 248, 255));
		btnChooseInnerColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				innerColor=JColorChooser.showDialog(null, "SELECT CIRCLE COLOR", innerColor);
				if(innerColor==null){
					innerColor=Color.white;
					//txtInnerColor.setBackground(Color.WHITE);
				}else{
					//txtInnerColor.setBackground(innerColor);
				}
				
			}
		});
		btnChooseInnerColor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GroupLayout gl_pnlCenter = new GroupLayout(pnlCenter);
		gl_pnlCenter.setHorizontalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlCenter.createSequentialGroup()
							.addGap(142)
							.addComponent(lblCircleModify))
						.addGroup(gl_pnlCenter.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCenterOfX)
								.addComponent(lblCenterYCoordinate)
								.addComponent(lblRadius))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtXcoordinate)
								.addComponent(txtYcoordinate)
								.addComponent(txtRadius)))
						.addGroup(gl_pnlCenter.createSequentialGroup()
							.addGap(111)
							.addGroup(gl_pnlCenter.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnChooseInnerColor)
								.addComponent(btnChooseEdgeColor))))
					.addContainerGap(116, Short.MAX_VALUE))
		);
		gl_pnlCenter.setVerticalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCircleModify)
					.addGap(18)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCenterOfX)
						.addComponent(txtXcoordinate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCenterYCoordinate)
						.addComponent(txtYcoordinate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRadius)
						.addComponent(txtRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addComponent(btnChooseEdgeColor)
					.addGap(30)
					.addComponent(btnChooseInnerColor)
					.addGap(33))
		);
		pnlCenter.setLayout(gl_pnlCenter);
		{
			JPanel pnlSouth = new JPanel();
			pnlSouth.setBackground(new Color(255, 218, 185));
			getContentPane().add(pnlSouth, BorderLayout.SOUTH);
			{
				btnModify = new JButton("Modify");
				btnModify.setBackground(new Color(248, 248, 255));
				btnModify.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							validation(txtXcoordinate.getText(), txtYcoordinate.getText(), txtRadius.getText());
						} catch (NumberFormatException exc) {
							JOptionPane.showMessageDialog(null, "Please insert a valid data type!", "ERROR", JOptionPane.ERROR_MESSAGE, null);
							return;
						}
						if(txtXcoordinate.getText().trim().equals("") || txtYcoordinate.getText().trim().equals("") || txtRadius.getText().trim().equals("")){
							JOptionPane.showMessageDialog(null, "Fields are empty!", "ERROR", JOptionPane.ERROR_MESSAGE, null);
							return;
						}else if(Integer.parseInt(txtRadius.getText()) < 1){
							JOptionPane.showMessageDialog(null, "Radius can't be less than 1!", "ERROR", JOptionPane.ERROR_MESSAGE, null);
							return;
						}else{
							int x = Integer.parseInt(txtXcoordinate.getText());
							int y = Integer.parseInt(txtYcoordinate.getText());
							int radius = Integer.parseInt(txtRadius.getText());
							
							circle.getCenter().setX(x);
							circle.getCenter().setY(y);
							try {
								circle.setRadius(radius);
							} catch (Exception e1) {
								
								e1.printStackTrace();
							}
							circle.setColor(edgeColor);
							circle.setInnerColor(innerColor);
							dispose();
							
						}
					}
				});
				btnModify.setFont(new Font("Tahoma", Font.PLAIN, 15));
				btnModify.setActionCommand("OK");
				getRootPane().setDefaultButton(btnModify);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.setBackground(new Color(248, 248, 255));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
				cancelButton.setActionCommand("Cancel");
			}
			GroupLayout gl_pnlSouth = new GroupLayout(pnlSouth);
			gl_pnlSouth.setHorizontalGroup(
				gl_pnlSouth.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnlSouth.createSequentialGroup()
						.addGap(126)
						.addComponent(btnModify)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(cancelButton)
						.addGap(106))
			);
			gl_pnlSouth.setVerticalGroup(
				gl_pnlSouth.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnlSouth.createSequentialGroup()
						.addGroup(gl_pnlSouth.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnModify)
							.addComponent(cancelButton))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			);
			pnlSouth.setLayout(gl_pnlSouth);
		}
	}
	
	public void fillAll(Circle circleModify) {
		this.circle = circleModify;
		txtXcoordinate.setText(String.valueOf(circle.getCenter().getX()));
		txtYcoordinate.setText(String.valueOf(circle.getCenter().getY()));
		txtRadius.setText(String.valueOf(circle.getRadius()));
		//txtEdgeColor.setBackground(circle.getColor());
		//txtInnerColor.setBackground(circle.getInnerColor());
		edgeColor = circle.getColor();
		innerColor = circle.getInnerColor();
	}
	
	public void validation(String x, String y, String radius) {
		String exp2 = "^(([+-])?([1-9]{1})([0-9]+)?)$";
		if(x.matches("") || y.matches("") || radius.matches("")) {
			
		}
		else if(!x.matches(exp2) || !y.matches(exp2) || !radius.matches(exp2)){
        	throw new NumberFormatException();
        }
	}
}
