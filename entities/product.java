package entities;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class product {
    String Name = null;
    BigDecimal Price = new BigDecimal(0);
    String Category = null;
    int ProductID = -1;
    Connection conn = null;

    public product(Connection conn) {
        this.conn = conn;
    }

    public product(Connection conn, String Name, String Category) {
        this.Name = Name;
        this.Category = Category;
    }

    public product(Connection conn, String Name, String Category, Double Price) {
        this.Name = Name;
        this.Category = Category;
        this.Price = new BigDecimal(Price).setScale(2, RoundingMode.HALF_UP);
        this.conn = conn;
    }

    public void createProduct() {
        try {
            String sql = "INSERT INTO product (name, category, price) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, Name);
            pstmt.setString(2, Category);
            pstmt.setBigDecimal(3, Price);
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("product added successfully!");
            } else {
                System.out.println("Failed to add the product.");
            }

        } catch (Exception e) {
            System.out.println(
                    "Error createProduct(): Name: " + e.getClass().getName() + " , Message: " + e.getMessage());
        }
    }

    public double getProductPriceByID(int ProductID) {
        try {
            double product_price = 0;
            this.ProductID = ProductID;
            String price_query = "SELECT price FROM product WHERE product_id = ?";
            PreparedStatement pstmtPrice = conn.prepareStatement(price_query);
            pstmtPrice.setInt(1, ProductID);
            ResultSet resultSet = pstmtPrice.executeQuery();
            if (resultSet.next()) {
                product_price = resultSet.getDouble("price");
            }
            return product_price;
        } catch (Exception e) {
            System.out.println(
                    "Error getProductPriceByID(): Name: " + e.getClass().getName() + " , Message: " + e.getMessage());
        }
        return -1;
    }

    public ArrayList<String> getProductByCategory(String Category) {
        ArrayList<String> productsByCategory = new ArrayList<String>();
        try {
            String categoryQuery = "SELECT name FROM product WHERE category = ?";
            PreparedStatement pstmtCategory = this.conn.prepareStatement(categoryQuery);
            pstmtCategory.setString(1, Category);
            ResultSet resultSet = pstmtCategory.executeQuery();
            if (resultSet.next()) {
                productsByCategory.add(resultSet.getString("name"));
            }
            return productsByCategory;
        } catch (Exception e) {
            System.out.println("Error");
        }
        return productsByCategory;
    }

}
