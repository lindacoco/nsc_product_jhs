package nsc_product_jhs.dto;

public class Product {
	private String productCode;
	private String productName;

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(String productCode, String productName) {
		super();
		this.productCode = productCode;
		this.productName = productName;
	}

	public String getProductCode() {
		return productCode;
	}
	
	

	public Product(String productCode) {
		super();
		this.productCode = productCode;
	}
	
	

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Override
	public String toString() {
		return String.format("%s", productCode);
	}
	
	public String forName() {
		return String.format("%s", productName);
	}

	
	public String toString1() {
		return "Product [productCode=" + productCode + ", productName=" + productName + "]";
	}
	
	
	
	

}
