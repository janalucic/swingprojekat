package stack;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Point;
import geometry.Rectangle;
import sort.DlgRectangle;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.Stack;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class FrmStack extends JFrame {

	private JPanel contentPane;
	
	DefaultListModel<Rectangle> dlm = new DefaultListModel<Rectangle>();
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmStack frame = new FrmStack();
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
	public FrmStack() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("IT57-2020 Lu\u010Di\u0107 Jana");
		setBounds(100, 100, 500, 333);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 218, 185));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlCenter = new JPanel();
		pnlCenter.setBackground(new Color(255, 218, 185));
		contentPane.add(pnlCenter, BorderLayout.CENTER);
		
		JScrollPane scrollPaneStack = new JScrollPane();
		GroupLayout gl_pnlCenter = new GroupLayout(pnlCenter);
		gl_pnlCenter.setHorizontalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPaneStack, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_pnlCenter.setVerticalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPaneStack, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
		);
		
		JList listStack = new JList();
		scrollPaneStack.setViewportView(listStack);
		listStack.setModel(dlm);
		
		JPanel pnlNorth = new JPanel();
		pnlNorth.setBackground(new Color(250, 128, 114));
		scrollPaneStack.setColumnHeaderView(pnlNorth);
		
		JButton btnAddToStack = new JButton("Add to Stack");
		btnAddToStack.setBackground(new Color(248, 248, 255));
		btnAddToStack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgRectangle addToStack = new DlgRectangle();
				
				addToStack.setVisible(true);
				
				if(addToStack.isOk) {
					try {
						String[] option = { "OK" };
						int x = Integer.parseInt(addToStack.getTxtCoordinateX().getText());
						int y = Integer.parseInt(addToStack.getTxtCoordinateY().getText());
						int width = Integer.parseInt(addToStack.getTxtWidth().getText());
						int height = Integer.parseInt(addToStack.getTxtHeight().getText());
						if(x<1 || y<1 || width<1 || height <1){
							getToolkit().beep();
							JOptionPane.showOptionDialog(null, "Values can't be negative!", "Error", JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE, null, option, option[0]);
							return;
						}
						Rectangle rec = new Rectangle(new Point(x,y), width, height);
						dlm.add(0, rec);	
						} catch (Exception NumberFormatException) {
							getToolkit().beep();
							JOptionPane.showMessageDialog(null, "Insert Numbers!");		
					}
					
				}
				
			}
		});
		btnAddToStack.setFont(new Font("Arial", Font.BOLD, 18));
		pnlNorth.add(btnAddToStack);
		
		JButton btnRemoveFromStack = new JButton("Remove from Stack");
		btnRemoveFromStack.setBackground(new Color(248, 248, 255));
		btnRemoveFromStack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dlm.isEmpty()){
					getToolkit().beep();
					JOptionPane.showMessageDialog(null, "Stack is empty!");	
				}else{
					DlgRectangle addToStack = new DlgRectangle();
					
					Point p = dlm.getElementAt(0).getUpperLeftPoint();
					int width = dlm.getElementAt(0).getWidth();
					int height = dlm.getElementAt(0).getHeight();
					
					addToStack.getTxtCoordinateX().setText(Integer.toString(p.getX()));
					addToStack.getTxtCoordinateY().setText(Integer.toString(p.getY()));
					addToStack.getTxtWidth().setText(Integer.toString(width));
					addToStack.getTxtHeight().setText(Integer.toString(height));
					addToStack.setVisible(true);
					
					if(addToStack.isOk){
						dlm.removeElementAt(0);
					}		
				}
			}
		});
		btnRemoveFromStack.setFont(new Font("Arial", Font.BOLD, 18));
		pnlNorth.add(btnRemoveFromStack);
		pnlCenter.setLayout(gl_pnlCenter);
		
		JPanel pnlSouth = new JPanel();
		contentPane.add(pnlSouth, BorderLayout.SOUTH);
	}

	public DefaultListModel<Rectangle> getDlm() {
		return dlm;
	}

	public void setDlm(DefaultListModel<Rectangle> dlm) {
		this.dlm = dlm;
	}
}
