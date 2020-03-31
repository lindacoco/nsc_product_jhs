package nsc_product_jhs.dto;

public class Sale {
	private int no;
	private String code;
	private int price;
	private int saleCnt;
	private int marginRate;

	public Sale() {
		// TODO Auto-generated constructor stub
	}

	public Sale(int no, String code, int price, int saleCnt, int marginRate) {
		super();
		this.no = no;
		this.code = code;
		this.price = price;
		this.saleCnt = saleCnt;
		this.marginRate = marginRate;
	}
	
	
	

	public Sale(String code, int price, int saleCnt, int marginRate) {
		super();
		this.code = code;
		this.price = price;
		this.saleCnt = saleCnt;
		this.marginRate = marginRate;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getSaleCnt() {
		return saleCnt;
	}

	public void setSaleCnt(int saleCnt) {
		this.saleCnt = saleCnt;
	}

	public int getMarginRate() {
		return marginRate;
	}

	public void setMarginRate(int marginRate) {
		this.marginRate = marginRate;
	}

	@Override
	public String toString() {
		return "Sale [no=" + no + ", code=" + code + ", price=" + price + ", saleCnt=" + saleCnt + ", marginRate="
				+ marginRate + "]";
	}

}
