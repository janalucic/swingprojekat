package modifyDlg;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Line;
import geometry.Point;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

@SuppressWarnings("serial")
public class DlgLineModify extends JDialog {

	private final JPanel pnlCenter = new JPanel();
	private JButton btnModify;
	private JButton cancelButton;
	private JTextField txtStartPointX;
	private JTextField txtStartPointY;
	private JTextField txtEndPointX;
	private JTextField txtEndPointY;
	private JTextField txtColorLine;
	private Line line;
	private Color colorLine;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgLineModify dialog = new DlgLineModify();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgLineModify() {
		setBounds(100, 100, 450, 350);
		getContentPane().setLayout(new BorderLayout());
		setTitle("Modify line");
		setModal(true);
		setResizable(false);
		setLocationRelativeTo(null);
		pnlCenter.setBackground(new Color(250, 128, 114));
		pnlCenter.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnlCenter, BorderLayout.CENTER);
		JLabel lblLineModify = new JLabel("Line Modify");
		lblLineModify.setFont(new Font("Arial", Font.BOLD, 18));
		JLabel lblStartPointX = new JLabel("Start point X coordinate:");
		lblStartPointX.setFont(new Font("Arial", Font.BOLD, 15));
		JLabel lblStartPointY = new JLabel("Start point Y coordinate:");
		lblStartPointY.setFont(new Font("Arial", Font.BOLD, 15));
		JLabel lblEndPointX = new JLabel("End point X coordiante:");
		lblEndPointX.setFont(new Font("Arial", Font.BOLD, 15));
		JLabel lblEndPointY = new JLabel("End point Y coordinate:");
		lblEndPointY.setFont(new Font("Arial", Font.BOLD, 15));
		
		JButton btnChooseColor = new JButton("Choose color");
		btnChooseColor.setBackground(new Color(248, 248, 255));
		btnChooseColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				colorLine = JColorChooser.showDialog(null, "Choose LINE color", colorLine);
				if(colorLine==null){
					colorLine=line.getColor();
				}
				txtColorLine.setBackground(colorLine);
			}
		});
		btnChooseColor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtStartPointX = new JTextField();
		txtStartPointX.setColumns(10);
		
		txtStartPointY = new JTextField();
		txtStartPointY.setColumns(10);
		
		txtEndPointX = new JTextField();
		txtEndPointX.setColumns(10);
		
		txtEndPointY = new JTextField();
		txtEndPointY.setColumns(10);
		
		txtColorLine = new JTextField();
		txtColorLine.setEditable(false);
		txtColorLine.setColumns(10);
		GroupLayout gl_pnlCenter = new GroupLayout(pnlCenter);
		gl_pnlCenter.setHorizontalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_pnlCenter.createSequentialGroup()
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlCenter.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblStartPointX))
						.addGroup(gl_pnlCenter.createSequentialGroup()
							.addGap(169)
							.addComponent(lblLineModify))
						.addGroup(gl_pnlCenter.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblStartPointY))
						.addGroup(gl_pnlCenter.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblEndPointX))
						.addGroup(gl_pnlCenter.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblEndPointY))
						.addGroup(gl_pnlCenter.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnChooseColor)))
					.addPreferredGap(ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
						.addComponent(txtEndPointX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_pnlCenter.createSequentialGroup()
								.addComponent(txtStartPointY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGroup(Alignment.TRAILING, gl_pnlCenter.createSequentialGroup()
								.addComponent(txtStartPointX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGap(65)))
						.addComponent(txtEndPointY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtColorLine, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(260))
		);
		gl_pnlCenter.setVerticalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblLineModify)
					.addGap(18)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStartPointX)
						.addComponent(txtStartPointX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStartPointY)
						.addComponent(txtStartPointY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEndPointX)
						.addComponent(txtEndPointX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEndPointY)
						.addComponent(txtEndPointY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnChooseColor)
						.addComponent(txtColorLine, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(25, Short.MAX_VALUE))
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
						if(txtStartPointX.getText().trim().equals("") || txtStartPointY.getText().trim().equals("")
								|| txtEndPointX.getText().trim().equals("") || txtEndPointY.getText().trim().equals("")){
							JOptionPane.showMessageDialog(null, "All fields must be filled in!", "Error", JOptionPane.ERROR_MESSAGE, null);
							return;
						}
						try {
							int startPointX = Integer.parseInt(txtStartPointX.getText());
							int startPointY = Integer.parseInt(txtStartPointY.getText());
							int endPointX = Integer.parseInt(txtEndPointX.getText());
							int endPointY = Integer.parseInt(txtEndPointY.getText());
							
							line.setStartPoint(new Point(startPointX, startPointY));
							line.setEndPoint(new Point(endPointX, endPointY));
							line.setColor(colorLine);
							dispose();
							
						} catch (NumberFormatException exc) {
							JOptionPane.showMessageDialog(null, "Please insert a valid data type!", "Error", JOptionPane.ERROR_MESSAGE, null);
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
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
				cancelButton.setActionCommand("btnCancel");
			}
			GroupLayout gl_pnlSouth = new GroupLayout(pnlSouth);
			gl_pnlSouth.setHorizontalGroup(
				gl_pnlSouth.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnlSouth.createSequentialGroup()
						.addGap(146)
						.addComponent(btnModify)
						.addGap(27)
						.addComponent(cancelButton)
						.addGap(159))
			);
			gl_pnlSouth.setVerticalGroup(
				gl_pnlSouth.createParallelGroup(Alignment.LEADING)
					.addGroup(Alignment.TRAILING, gl_pnlSouth.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_pnlSouth.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnModify)
							.addComponent(cancelButton))
						.addContainerGap())
			);
			pnlSouth.setLayout(gl_pnlSouth);
		}
	}
	public void fillAll(Line lineModify) {
		this.line = lineModify;
		txtStartPointX.setText(String.valueOf(line.getStartPoint().getX()));
		txtStartPointY.setText(String.valueOf(line.getStartPoint().getY()));
		txtEndPointX.setText(String.valueOf(line.getEndPoint().getX()));
		txtEndPointY.setText(String.valueOf(line.getEndPoint().getY()));
		colorLine = line.getColor();
		txtColorLine.setBackground(line.getColor());
	}
}
