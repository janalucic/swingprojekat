package modifyDlg;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Rectangle;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class DlgRectangleModify extends JDialog {

	private final JPanel pnlCenter = new JPanel();
	private JButton btnModify;
	private JButton btnCancel;
	private JLabel lblRectangleModify;
	private JLabel lblUpperLeftPoint;
	private JLabel lblUpperLeftPoint_1;
	private JLabel lblWidth;
	private JLabel lblHeight;
	private JButton btnChooseEdgeColor;
	private JButton btnChooseInnerColor;
	private JTextField txtUpperLeftX;
	private JTextField txtUpperLeftY;
	private JTextField txtWidthRec;
	private JTextField txtHeightRec;

	private Rectangle rectangle;
	private Color edgeColorRectangle;
	private Color innerColorRectangle;
	private boolean isOk;
	
	
	
	public static void main(String[] args) {
		try {
			DlgRectangleModify dialog = new DlgRectangleModify();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgRectangleModify() {
		setBounds(100, 100, 450, 470);
		setTitle("Modify Rectangle");
		setModal(true);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		pnlCenter.setBackground(new Color(250, 128, 114));
		pnlCenter.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnlCenter, BorderLayout.CENTER);
		lblRectangleModify = new JLabel("Rectangle Modify");
		lblRectangleModify.setFont(new Font("Arial", Font.BOLD, 18));
		lblUpperLeftPoint = new JLabel("Upper left point X coordinate:");
		lblUpperLeftPoint.setFont(new Font("Arial", Font.BOLD, 15));
		lblUpperLeftPoint_1 = new JLabel("Upper left point Y coordinate:");
		lblUpperLeftPoint_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblWidth = new JLabel("Width:");
		lblWidth.setFont(new Font("Arial", Font.BOLD, 15));
		lblHeight = new JLabel("Height:");
		lblHeight.setFont(new Font("Arial", Font.BOLD, 15));
		
		btnChooseEdgeColor = new JButton("Choose edge color");
		btnChooseEdgeColor.setBackground(new Color(248, 248, 255));
		btnChooseEdgeColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				edgeColorRectangle = JColorChooser.showDialog(null, "Choose RECTANGLE color", rectangle.getColor());
				if(edgeColorRectangle==null){
					edgeColorRectangle = rectangle.getColor();
				}else {
					//txtEdgeColorRec.setBackground(edgeColorRectangle);
				}
				
			}
		});
		btnChooseEdgeColor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		btnChooseInnerColor = new JButton("Choose inner color");
		btnChooseInnerColor.setBackground(new Color(248, 248, 255));
		btnChooseInnerColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				innerColorRectangle = JColorChooser.showDialog(null, "Choose RECTANGLE color", rectangle.getInnerColor());
				if(innerColorRectangle==null){
					innerColorRectangle = rectangle.getInnerColor();
				}
				//txtInnerColorRec.setBackground(innerColorRectangle);
			}
		});
		btnChooseInnerColor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtUpperLeftX = new JTextField();
		txtUpperLeftX.setColumns(10);
		
		txtUpperLeftY = new JTextField();
		txtUpperLeftY.setColumns(10);
		
		txtWidthRec = new JTextField();
		txtWidthRec.setColumns(10);
		
		txtHeightRec = new JTextField();
		txtHeightRec.setColumns(10);
		GroupLayout gl_pnlCenter = new GroupLayout(pnlCenter);
		gl_pnlCenter.setHorizontalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addContainerGap(160, Short.MAX_VALUE)
					.addComponent(lblRectangleModify)
					.addGap(138))
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addGap(26)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
						.addComponent(lblUpperLeftPoint)
						.addComponent(lblUpperLeftPoint_1)
						.addComponent(lblWidth)
						.addComponent(lblHeight))
					.addGap(47)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING, false)
						.addComponent(txtHeightRec)
						.addComponent(txtWidthRec)
						.addComponent(txtUpperLeftY)
						.addComponent(txtUpperLeftX))
					.addContainerGap(68, Short.MAX_VALUE))
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addGap(109)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
						.addComponent(btnChooseInnerColor)
						.addComponent(btnChooseEdgeColor))
					.addContainerGap(170, Short.MAX_VALUE))
		);
		gl_pnlCenter.setVerticalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblRectangleModify)
					.addGap(28)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUpperLeftPoint)
						.addComponent(txtUpperLeftX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(42)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblUpperLeftPoint_1)
						.addComponent(txtUpperLeftY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(39)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblWidth)
						.addComponent(txtWidthRec, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblHeight)
						.addComponent(txtHeightRec, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
					.addComponent(btnChooseEdgeColor)
					.addGap(18)
					.addComponent(btnChooseInnerColor)
					.addGap(23))
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
							validation(txtUpperLeftX.getText(), txtUpperLeftY.getText(), txtWidthRec.getText(), txtHeightRec.getText());
						} catch (NumberFormatException exc) {
							getToolkit().beep();
							JOptionPane.showMessageDialog(null, "Invalid data, please check and correct data!", "ERROR", JOptionPane.ERROR_MESSAGE, null);
							isOk = false; 
							return;
						}
						if(txtUpperLeftX.getText().trim().equals("") || txtUpperLeftY.getText().trim().equals("")
									|| txtWidthRec.getText().trim().equals("") || txtHeightRec.getText().trim().equals("")){
							getToolkit().beep();
							JOptionPane.showMessageDialog(null, "Fields are empty! Insert values!", "ERROR", JOptionPane.ERROR_MESSAGE, null);
							return;
						}else if(Integer.parseInt(txtWidthRec.getText()) < 0 || Integer.parseInt(txtHeightRec.getText()) < 0){
							getToolkit().beep();
							JOptionPane.showMessageDialog(null, "Width/Height must be greater than 0!", "ERROR", JOptionPane.ERROR_MESSAGE, null);
							return;
						}else{
						
								int upperLeftX = Integer.parseInt(txtUpperLeftX.getText());
								int upperLeftY = Integer.parseInt(txtUpperLeftY.getText());
								int widthRec = Integer.parseInt(txtWidthRec.getText());
								int heightRec = Integer.parseInt(txtHeightRec.getText());
								
								
									rectangle.getUpperLeftPoint().setX(upperLeftX);
									rectangle.getUpperLeftPoint().setY(upperLeftY);
									rectangle.setHeight(heightRec);
									rectangle.setWidth(widthRec);
									rectangle.setColor(edgeColorRectangle);
									rectangle.setInnerColor(innerColorRectangle);
									dispose();
							
							
							
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
						.addGap(134)
						.addComponent(btnModify)
						.addGap(27)
						.addComponent(btnCancel)
						.addGap(161))
			);
			gl_pnlSouth.setVerticalGroup(
				gl_pnlSouth.createParallelGroup(Alignment.LEADING)
					.addGroup(Alignment.TRAILING, gl_pnlSouth.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_pnlSouth.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnModify)
							.addComponent(btnCancel))
						.addContainerGap())
			);
			pnlSouth.setLayout(gl_pnlSouth);
		}
	}
	
	public void fillAll(Rectangle rectangleModify) {
		this.rectangle= rectangleModify;
		txtUpperLeftX.setText(String.valueOf(rectangle.getUpperLeftPoint().getX()));
		txtUpperLeftY.setText(String.valueOf(rectangle.getUpperLeftPoint().getY()));
		txtWidthRec.setText(String.valueOf(rectangle.getWidth()));
		txtHeightRec.setText(String.valueOf(rectangle.getHeight()));
		//txtEdgeColorRec.setBackground(rectangle.getColor());
		//txtInnerColorRec.setBackground(rectangle.getInnerColor());
		edgeColorRectangle = rectangle.getColor();
		innerColorRectangle = rectangle.getInnerColor();
	}
	
	public void validation(String x, String y, String width, String height) {
		String supp1 ="^[+-]?([0-9]+([.][0-9]*)?|[.][0-9]+)$";
		if(x.matches("") || y.matches("") || width.matches("") || height.matches("") ) {
			
		}else if(!x.matches(supp1) || !y.matches(supp1) || !width.matches(supp1) || !height.matches(supp1)){  
        	throw new NumberFormatException();
        }
	}

}
