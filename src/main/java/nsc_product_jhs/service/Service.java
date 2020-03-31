package nsc_product_jhs.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import nsc_product_jhs.ds.MySqlDataSource;
import nsc_product_jhs.dto.Product;
import nsc_product_jhs.dto.Sale;

public class Service {

	public List<Product> selectProductList() {
		String sql = "select product_code from product";
		List<Product> list = new ArrayList<Product>();

		try (Connection conn = MySqlDataSource.getConnection(); 
			PreparedStatement pstmt = conn.prepareStatement(sql);) {

			try (ResultSet rs = pstmt.executeQuery();) {
				while (rs.next()) {
					list.add(getProduct(rs));

				}
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	private Product getProduct(ResultSet rs) throws SQLException {
		String productCode = rs.getString("product_code");
		return new Product(productCode);
	}
	
	public Product selectProductName(String productCode){
		String sql = "select product_name from product where product_code = ?";
	    Product product= new Product();

		try (Connection conn = MySqlDataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {
			  pstmt.setString(1, productCode);

			try (ResultSet rs = pstmt.executeQuery();) {
				if (rs.next()) {
					return getProductName(rs);

				}
	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
		
	}

	private Product getProductName(ResultSet rs) throws SQLException {
		String productName = rs.getString("product_name");
		return new Product(productName);
	}

	public int insertProduct(Product product) {
		String sql="insert into product values(?,?)";
		try(Connection con = MySqlDataSource.getConnection();
				PreparedStatement pstmt= con.prepareStatement(sql)){
			pstmt.setString(1, product.getProductCode());
			pstmt.setString(2, product.getProductName());
			
			
			
			return pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int insertSale(Sale sale) {
		String sql="insert into sale (no,product_code,price,sale_cnt,margin_rate) values(null,?,?,?,?)";
		try(Connection con = MySqlDataSource.getConnection();
				PreparedStatement pstmt= con.prepareStatement(sql)){
			pstmt.setString(1, sale.getCode());
			pstmt.setInt(2, sale.getPrice());
			pstmt.setInt(3, sale.getSaleCnt());
			pstmt.setInt(4, sale.getMarginRate());
			
			return pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}



}
