package drawing;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import dialogues.DlgDrawCircle;
import dialogues.DlgDrawDonut;
import dialogues.DlgDrawRectangle;
import geometry.Circle;
import geometry.Donut;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;
import modifyDlg.DlgCircleModify;
import modifyDlg.DlgDonutModify;
import modifyDlg.DlgLineModify;
import modifyDlg.DlgPointModify;
import modifyDlg.DlgRectangleModify;

import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.BoxLayout;

@SuppressWarnings("serial")
public class FrmDrawing extends JFrame {

	private JPanel contentPane;
	PnlDrawing pnlDrawing = new PnlDrawing();
	private Color edgeColor = Color.black;
	private Color innerColor = Color.white;
	private final ButtonGroup btnGroupShapes = new ButtonGroup();
	private final ButtonGroup btnGroupMode = new ButtonGroup();
	private int lastSelected = -1;
	private Point click1;
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmDrawing frame = new FrmDrawing();
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
	public FrmDrawing() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1120, 650);
		setTitle("IT 57-2020 Lu\u010Di\u0107 Jana");
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 160, 122));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		pnlDrawing.setBackground(Color.WHITE);
		
		
		
		JPanel panelShapes = new JPanel();
		panelShapes.setBackground(new Color(255, 228, 181));
		panelShapes.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JPanel panelActions = new JPanel();
		panelActions.setBackground(new Color(255, 222, 173));
		panelActions.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JPanel panelEdgeColor = new JPanel();
		panelEdgeColor.setBackground(new Color(255, 228, 181));
		panelEdgeColor.setBorder(new CompoundBorder());
		
		JPanel panelInnerColor = new JPanel();
		panelInnerColor.setBackground(new Color(255, 228, 181));
		panelInnerColor.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JRadioButton rdbtnDraw = new JRadioButton("Draw");
		rdbtnDraw.setBackground(new Color(255, 222, 173));
		rdbtnDraw.setForeground(new Color(0, 0, 0));
		rdbtnDraw.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnGroupMode.add(rdbtnDraw);
		
		
		rdbtnDraw.setSelected(true);
		
		JRadioButton rdbtnSelect = new JRadioButton("Select");
		rdbtnSelect.setBackground(new Color(255, 218, 185));
		rdbtnSelect.setForeground(new Color(0, 0, 0));
		rdbtnSelect.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		rdbtnSelect.addItemListener(new ItemListener(){
			@SuppressWarnings("deprecation")
			public void itemStateChanged(ItemEvent e){
				if(e.getStateChange() == ItemEvent.SELECTED){
					pnlDrawing.setCursor(new Cursor(HAND_CURSOR));
				}else{
					pnlDrawing.setCursor(new Cursor(DEFAULT_CURSOR));
				}
			}
		});
		
		btnGroupMode.add(rdbtnSelect);
		GroupLayout gl_pnlDrawing = new GroupLayout(pnlDrawing);
		gl_pnlDrawing.setHorizontalGroup(
			gl_pnlDrawing.createParallelGroup(Alignment.LEADING)
				.addGap(0, 10, Short.MAX_VALUE)
		);
		gl_pnlDrawing.setVerticalGroup(
			gl_pnlDrawing.createParallelGroup(Alignment.LEADING)
				.addGap(0, 10, Short.MAX_VALUE)
		);
		pnlDrawing.setLayout(gl_pnlDrawing);
		
		
		JButton btnChooselnnerColor = new JButton("Choose inner color");
		btnChooselnnerColor.setBackground(new Color(248, 248, 255));
		btnChooselnnerColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				innerColor=JColorChooser.showDialog(null, "FILL COLOR", innerColor);
				if(innerColor==null){
					innerColor = Color.WHITE;
				//	txtInnerColor.setBackground(Color.WHITE);
				}else{
					//txtInnerColor.setBackground(innerColor);
				}
			}
		});
		btnChooselnnerColor.setFont(new Font("Tahoma", Font.BOLD, 15));
		GroupLayout gl_panelInnerColor = new GroupLayout(panelInnerColor);
		gl_panelInnerColor.setHorizontalGroup(
			gl_panelInnerColor.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelInnerColor.createSequentialGroup()
					.addGap(10)
					.addComponent(btnChooselnnerColor, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE))
		);
		gl_panelInnerColor.setVerticalGroup(
			gl_panelInnerColor.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelInnerColor.createSequentialGroup()
					.addGap(50)
					.addComponent(btnChooselnnerColor, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
		);
		panelInnerColor.setLayout(gl_panelInnerColor);
		
		JButton btnChooseEdgeColor = new JButton("Choose edge color");
		btnChooseEdgeColor.setBackground(new Color(248, 248, 255));
		btnChooseEdgeColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				edgeColor=JColorChooser.showDialog(null, "BACKGROUND COLOR", edgeColor);
				if(edgeColor==null){
					edgeColor=Color.BLACK;
					//txtEdgeColor.setBackground(Color.BLACK);
				}else{
					//txtEdgeColor.setBackground(edgeColor);
				}
				
			}
		});
		btnChooseEdgeColor.setFont(new Font("Tahoma", Font.BOLD, 15));
		GroupLayout gl_panelEdgeColor = new GroupLayout(panelEdgeColor);
		gl_panelEdgeColor.setHorizontalGroup(
			gl_panelEdgeColor.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelEdgeColor.createSequentialGroup()
					.addGap(10)
					.addComponent(btnChooseEdgeColor, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE))
		);
		gl_panelEdgeColor.setVerticalGroup(
			gl_panelEdgeColor.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelEdgeColor.createSequentialGroup()
					.addGap(48)
					.addComponent(btnChooseEdgeColor, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
		);
		panelEdgeColor.setLayout(gl_panelEdgeColor);
		
		JButton btnModify = new JButton("Modify");
		btnModify.setBackground(new Color(248, 248, 255));
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(lastSelected == -1){
					getToolkit().beep();
					JOptionPane.showMessageDialog(null, "Nothing is selected!","INFO!", JOptionPane.ERROR_MESSAGE, null);
					return;
				}
				Shape modifyShape = pnlDrawing.getShapes().get(lastSelected);
				if(modifyShape instanceof Point){
					DlgPointModify pointModify = new DlgPointModify();
					pointModify.fillAll((Point)modifyShape);
					pointModify.setVisible(true);
				}else if(modifyShape instanceof Line){
					DlgLineModify lineModify = new DlgLineModify();
					lineModify.fillAll((Line)modifyShape);
					lineModify.setVisible(true);
				}else if(modifyShape instanceof Rectangle){
					DlgRectangleModify rectangleModify = new DlgRectangleModify();
					rectangleModify.fillAll((Rectangle)modifyShape);
					rectangleModify.setVisible(true);
				}else if(modifyShape instanceof Donut){
					DlgDonutModify donutModify = new DlgDonutModify();
					donutModify.fillAll((Donut)modifyShape);
					donutModify.setVisible(true);
				}else if(modifyShape instanceof Circle){
					DlgCircleModify circleModify = new DlgCircleModify();
					circleModify.fillAll((Circle)modifyShape);
					circleModify.setVisible(true);
				}
				pnlDrawing.repaint();
			}
		});
		btnModify.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBackground(new Color(248, 248, 255));
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(lastSelected==-1){
					getToolkit().beep();
					JOptionPane.showMessageDialog(null, "Nothing is selected!","INFO!", JOptionPane.ERROR_MESSAGE, null);
					return;
				}
				int question = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this shape?", "CONFIRM", JOptionPane.YES_NO_OPTION);
				if(question==0 & pnlDrawing.getShapes().size() > lastSelected){
					pnlDrawing.getShapes().remove(lastSelected);
					pnlDrawing.repaint();
					lastSelected=-1;
				}
			}
		});
		
		JButton btnDeleteAll = new JButton("Delete all");
		btnDeleteAll.setBackground(new Color(248, 248, 255));
		btnDeleteAll.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDeleteAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(pnlDrawing.getShapes().isEmpty()){
					getToolkit().beep();
					JOptionPane.showMessageDialog(null, "There is nothing on the PANEL!","INFO!", JOptionPane.ERROR_MESSAGE, null);
					return;
				}else{
					pnlDrawing.getShapes().clear();
					pnlDrawing.repaint();
				}
			
			}
		});
		GroupLayout gl_panelActions = new GroupLayout(panelActions);
		gl_panelActions.setHorizontalGroup(
			gl_panelActions.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelActions.createSequentialGroup()
					.addComponent(btnDelete)
					.addComponent(btnModify)
					.addComponent(btnDeleteAll))
		);
		gl_panelActions.setVerticalGroup(
			gl_panelActions.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelActions.createSequentialGroup()
					.addGap(16)
					.addGroup(gl_panelActions.createParallelGroup(Alignment.LEADING)
						.addComponent(btnDelete)
						.addComponent(btnModify)
						.addComponent(btnDeleteAll)))
		);
		panelActions.setLayout(gl_panelActions);
		
		JToggleButton tglbtnPoint = new JToggleButton("Point");
		tglbtnPoint.setBackground(new Color(248, 248, 255));
		tglbtnPoint.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JToggleButton tglbtnRectangle = new JToggleButton("Rectangle");
		tglbtnRectangle.setBackground(new Color(248, 248, 255));
		tglbtnRectangle.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JToggleButton tglbtnCircle = new JToggleButton("Circle");
		tglbtnCircle.setBackground(new Color(248, 248, 255));
		tglbtnCircle.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JToggleButton tglbtnDonut = new JToggleButton("Donut");
		tglbtnDonut.setBackground(new Color(248, 248, 255));
		tglbtnDonut.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JToggleButton tglbtnLine = new JToggleButton("Line");
		tglbtnLine.setBackground(new Color(248, 248, 255));
		tglbtnLine.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnGroupShapes.add(tglbtnLine);
		
		btnGroupShapes.add(tglbtnPoint);
		btnGroupShapes.add(tglbtnRectangle);
		btnGroupShapes.add(tglbtnCircle);
		btnGroupShapes.add(tglbtnDonut);
		GroupLayout gl_panelShapes = new GroupLayout(panelShapes);
		gl_panelShapes.setHorizontalGroup(
			gl_panelShapes.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelShapes.createSequentialGroup()
					.addGap(10)
					.addComponent(tglbtnPoint, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(tglbtnLine, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(tglbtnRectangle, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(tglbtnCircle, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(tglbtnDonut, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
		);
		gl_panelShapes.setVerticalGroup(
			gl_panelShapes.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelShapes.createSequentialGroup()
					.addGap(2)
					.addComponent(tglbtnPoint, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
				.addComponent(tglbtnLine, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
				.addGroup(gl_panelShapes.createSequentialGroup()
					.addGap(1)
					.addComponent(tglbtnRectangle, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
				.addComponent(tglbtnCircle, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
				.addComponent(tglbtnDonut, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
		);
		panelShapes.setLayout(gl_panelShapes);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panelActions, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(panelShapes, GroupLayout.PREFERRED_SIZE, 591, GroupLayout.PREFERRED_SIZE))
						.addComponent(pnlDrawing, GroupLayout.PREFERRED_SIZE, 777, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panelEdgeColor, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelInnerColor, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(194)
							.addComponent(rdbtnDraw, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(1080)
					.addComponent(rdbtnSelect))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(33)
									.addComponent(panelActions, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
								.addComponent(panelShapes, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
							.addGap(10)
							.addComponent(pnlDrawing, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(65)
							.addComponent(panelEdgeColor, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
							.addGap(48)
							.addComponent(panelInnerColor, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
							.addGap(81)
							.addComponent(rdbtnDraw)))
					.addGap(2)
					.addComponent(rdbtnSelect))
		);
		contentPane.setLayout(gl_contentPane);
		
		pnlDrawing.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				super.mouseClicked(e);
				Point mouseClick1 = new Point(e.getX(), e.getY());
				for(int i =0; i<pnlDrawing.getShapes().size();i++){
					lastSelected=-1;
					pnlDrawing.getShapes().get(i).setSelected(false);
					pnlDrawing.repaint();
				}
				if(rdbtnSelect.isSelected()){
					for(int i =0; i<pnlDrawing.getShapes().size(); i++){
						if(pnlDrawing.getShapes().get(i).contains(e.getX(), e.getY())){
							lastSelected=i;
						}
						if(lastSelected!=-1) {
							pnlDrawing.getShapes().get(lastSelected).setSelected(true);
						}
					}
				}else{
					if(tglbtnPoint.isSelected()){
						Point p = new Point(e.getX(), e.getY());
						p.setColor(edgeColor);
						pnlDrawing.getShapes().add(p);
					}else if(tglbtnLine.isSelected()){
						if(click1==null){
							click1 = new Point(e.getX(), e.getY());
							return;
						}
						Point mouseClick2 = new Point(e.getX(), e.getY());
						Line l = new Line(click1, mouseClick2, false);
						pnlDrawing.getShapes().add(l);
						click1=null;
					}else if(tglbtnRectangle.isSelected()){
						DlgDrawRectangle drawRectangle = new DlgDrawRectangle();
						drawRectangle.setVisible(true);
						
						if(drawRectangle.isOk()){
							Rectangle r=new Rectangle(mouseClick1,Integer.parseInt(drawRectangle.getTxtHeightRectangle().getText()), Integer.parseInt(drawRectangle.getTxtWidthRectangle().getText()));
							r.setColor(edgeColor);
							r.setInnerColor(innerColor);
							pnlDrawing.getShapes().add(r);
						}
					}else if(tglbtnCircle.isSelected()){
						DlgDrawCircle drawCircle = new DlgDrawCircle();
						drawCircle.setVisible(true);
						
						if(drawCircle.isOk()){
							Circle c = new Circle(mouseClick1, Integer.parseInt(drawCircle.getTxtRadius().getText()));
							c.setColor(edgeColor);
							c.setInnerColor(innerColor);
							pnlDrawing.getShapes().add(c);
						}
					}else if(tglbtnDonut.isSelected()){
						DlgDrawDonut drawDonut = new DlgDrawDonut();
						drawDonut.setVisible(true);
						
						if(drawDonut.isOk()){
							Donut d = new Donut(mouseClick1,Integer.parseInt(drawDonut.getTxtDonutRadius().getText()),Integer.parseInt(drawDonut.getTxtDonutInnerRadius().getText()));
							d.setColor(edgeColor);
							d.setInnerColor(innerColor);
							pnlDrawing.getShapes().add(d);
						}
					}
				}
				pnlDrawing.repaint();
			}
		});	
	}
}
