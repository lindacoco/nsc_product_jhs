package nsc_product_jhs.ui;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import nsc_product_jhs.dto.Product;
import nsc_product_jhs.dto.Sale;
import nsc_product_jhs.service.Service;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class MainFrame extends JFrame implements ActionListener, KeyListener {

	private JPanel contentPane;
	private JTextField tfPrice;
	private JTextField tfCnt;
	private JTextField tfMargin;
	private JButton btnOutput;
	private JButton btnInput;
	private JPanel pProduct;
	private JButton btnOutput2;
	
	private Service service;
	private String pCode;
	private JTextField tfPname;
	private JTextField tfCode;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		service = new Service();
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		pProduct = new JPanel();
		contentPane.add(pProduct);
		pProduct.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblProductCode = new JLabel("제품코드");
		lblProductCode.setHorizontalAlignment(SwingConstants.CENTER);
		pProduct.add(lblProductCode);
		
		tfCode = new JTextField();
		tfCode.addKeyListener(this);
		pProduct.add(tfCode);
		tfCode.setColumns(10);
		
		JLabel lblProductName = new JLabel("제품명");
		lblProductName.setHorizontalAlignment(SwingConstants.CENTER);
		pProduct.add(lblProductName);
		
		tfPname = new JTextField();
		pProduct.add(tfPname);
		tfPname.setColumns(10);
		
		JPanel pSale = new JPanel();
		contentPane.add(pSale);
		pSale.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblSalePrice = new JLabel("제품단가");
		lblSalePrice.setHorizontalAlignment(SwingConstants.LEFT);
		pSale.add(lblSalePrice);
		
		tfPrice = new JTextField();
		pSale.add(tfPrice);
		tfPrice.setColumns(10);
		
		JLabel lblSaleCnt = new JLabel("판매수량");
		pSale.add(lblSaleCnt);
		
		tfCnt = new JTextField();
		pSale.add(tfCnt);
		tfCnt.setColumns(10);
		
		JLabel lblSaleMargin = new JLabel("마진율");
		pSale.add(lblSaleMargin);
		
		tfMargin = new JTextField();
		pSale.add(tfMargin);
		tfMargin.setColumns(10);
		
		JPanel pBtns = new JPanel();
		contentPane.add(pBtns);
		
		btnInput = new JButton("입력");
		btnInput.addActionListener(this);
		pBtns.add(btnInput);
		
		btnOutput = new JButton("출력1");
		btnOutput.addActionListener(this);
		pBtns.add(btnOutput);
		
		btnOutput2 = new JButton("출력2");
		pBtns.add(btnOutput2);
		
		//cmbCode.(setCmpCodeList(service.showProductCodeList()));
		
		//setCmbProductList(service.selectProductList());
		//setProductName(pCode);
		
		
	}
	


	

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnInput) {
			btnInputActionPerformed(e);
		}
		if (e.getSource() == btnOutput) {
			btnOutputActionPerformed(e);
		}
	}
	protected void btnOutputActionPerformed(ActionEvent e) {
		//출력버튼 누르면 테이블 소환

		
		
	}
	protected void btnInputActionPerformed(ActionEvent e) {
		//입력버튼 누르면 데이터에 정보들 입력
		try{Sale sale = getItem();
		Product product = getItem1();
		//JOptionPane.showMessageDialog(null, sale);
		service.insertProduct(product);
		service.insertSale(sale);
		
		}catch (Exception e1) {
			e1.printStackTrace();
		}
		
		JOptionPane.showMessageDialog(null, "입력완료");
        cleartf();
		
	}
	
	public Product getItem1() {

		String productCode = tfCode.getText().trim();
		String productName = tfPname.getText().trim();
		return new Product(productCode, productName);
	}
	
	
	public Sale getItem() {

		String code = tfCode.getText().trim();
		int price = Integer.parseInt(tfPrice.getText().trim());
		int saleCnt = Integer.parseInt(tfCnt.getText().trim());
		int marginRate = Integer.parseInt(tfMargin.getText().trim());
		return new Sale(code, price, saleCnt, marginRate);
	}
	
	public void cleartf() {
		tfCode.setText("");
		tfPname.setText("");
		tfPrice.setText("");
		tfCnt.setText("");
		tfMargin.setText("");
		
	}
	
//	
//	public void setCmbProductList(List<Product> productList) {
//		DefaultComboBoxModel<Product> model = new DefaultComboBoxModel<>(new Vector<>(productList));
//	}
    
	
	public void setProductName(String pCode) {
		Product product = service.selectProductName(pCode);
	//	System.out.println(product);
		tfPname.setText(product+"");
	}
	public void keyPressed(KeyEvent e) {
		if (e.getSource() == tfCode) {
			tfCodeKeyPressed(e);
		}
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
	}
	protected void tfCodeKeyPressed(KeyEvent e) {
		setProductName(tfCode.getText().trim());
		if(tfPname.getText().equals("null")) {
			tfPname.setText("");
		}

	}
}
