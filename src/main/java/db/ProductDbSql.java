package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import domain.Product;

public class ProductDbSql implements ProductDB {
	//private Properties properties = new Properties();
	private Connection connection;
	private Statement statement;
	public ProductDbSql(Properties properties) {
        String url;
		try {
			Class.forName("org.postgresql.Driver");
			url = properties.getProperty("url");
		} catch (ClassNotFoundException e) {
			throw new DbException("failed");
		}
		try {
			connection = DriverManager.getConnection(url, properties);
		} catch (SQLException e) {
			throw new DbException("connection failed");
		}
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			throw new DbException("createStatement failed");
		}
    }
		
	@Override
	public Product get(int id) {
		ResultSet result;
		PreparedStatement statement;
		Product product = null;
		String sql = "SELECT * FROM product WHERE id=?";
		
		try {
			statement = connection.prepareStatement(sql);
		} catch (SQLException e1) {
			throw new DbException("get product: PreparedStatement failed");
		}
		
		try {
			statement.setInt(1, id);
		} catch (SQLException e1) {
			throw new DbException("get product: setInt 1 => id failed");
		}
		
		try {
			result = statement.executeQuery();
		} catch (SQLException e1) {
			throw new DbException("get product: executeQuery failed");
		}
		
		try {
			if(result.next()){
				int prdId = Integer.parseInt(result.getString("id"));
				String name = result.getString("name");
				String description = result.getString("description");
				double prijs = result.getDouble("prijs");
				int quantity = result.getInt("quantity");
				
				product = new Product(prdId, name, description, prijs, quantity );
			} 
		} catch (NumberFormatException | SQLException e) {
			throw new DbException();
		}

        return product;
	}

	@Override
	public List<Product> getAll() {
		ResultSet result;
		PreparedStatement statement;
		List<Product> productList = new ArrayList<>();
		String sql = "SELECT * FROM product";
		
		try {
			statement = connection.prepareStatement(sql);
		} catch (SQLException e1) {
			throw new DbException("get product: PreparedStatement failed");
		}
		
		try {
			result = statement.executeQuery();
		} catch (SQLException e1) {
			throw new DbException("get product: executeQuery failed");
		}
		
		try {
			while (result.next()) {
				int id = Integer.parseInt(result.getString("id"));
				String name = result.getString("name");
				String description = result.getString("description");
				double prijs = result.getDouble("prijs");
				int quantity = result.getInt("quantity");
				
				Product p = new Product(id, name, description, prijs, quantity );
				productList.add(p);
			}
		} catch (NumberFormatException | SQLException e) {
			throw new DbException();
		}

        return productList;
	}

	@Override
	public void add(Product p) {
		PreparedStatement statement;
		String sql = "INSERT INTO product (name, description, prijs, quantity) VALUES (?,?,?, ?)";
		
		try {
			statement = connection.prepareStatement(sql);
		} catch (SQLException e1) {
			throw new DbException("add product: PreparedStatement failed");
		}
		
		try {
			statement.setString(1, p.getName());
		} catch (SQLException e1) {
			throw new DbException("add product: setString 1 => p.getName() failed");
		}
		
		try {
			statement.setString(2, p.getDescription());
		} catch (SQLException e1) {
			throw new DbException("add product: setString 2 => p.getDescription() failed");
		}
		
		try {
			statement.setDouble(3, p.getPrice());
		} catch (SQLException e1) {
			throw new DbException("add product: setDouble 3 => p.getPrice() failed");
		}
        try {
            statement.setInt(4, p.getQuantity());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
			statement.execute();
		} catch (SQLException e1) {
			throw new DbException("add product: execute failed " + e1.toString());
		}
	}

	@Override
	public void update(Product p) {
		PreparedStatement statement;
		String sql = "UPDATE product SET name=?, description=?, prijs=?, quantity=? WHERE id=?";
		
		try {
			statement = connection.prepareStatement(sql);
		} catch (SQLException e1) {
			throw new DbException("add product: PreparedStatement failed");
		}
		
		try {
			statement.setString(1, p.getName());
		} catch (SQLException e1) {
			throw new DbException("add product: setString 1 => p.getName() failed");
		}
		
		try {
			statement.setString(2, p.getDescription());
		} catch (SQLException e1) {
			throw new DbException("add product: setString 2 => p.getDescription() failed");
		}
		
		try {
			statement.setDouble(3, p.getPrice());
		} catch (SQLException e1) {
			throw new DbException("add product: setDouble 3 => p.getPrice() failed");
		}

        try {
            statement.setDouble(4, p.getQuantity());
        } catch (SQLException e1) {
            throw new DbException("add product: setDouble 3 => p.getPrice() failed");
        }

		try {
			statement.setInt(5, p.getProductId());
		} catch (SQLException e1) {
			throw new DbException("add product: setDouble 3 => p.getPrice() failed");
		}
		
		try {
			statement.executeUpdate();
		} catch (SQLException e1) {
			throw new DbException("add product: execute failed " + e1.toString());
		}
	}

	@Override
	public void delete(int id) {
		PreparedStatement statement;
		String sql = "DELETE FROM product WHERE id=?";
		
		try {
			statement = connection.prepareStatement(sql);
		} catch (SQLException e1) {
			throw new DbException("get product: PreparedStatement failed");
		}
		
		try {
			statement.setInt(1, id);
		} catch (SQLException e1) {
			throw new DbException("get product: setInt 1 => id failed");
		}
		
		try {
			statement.execute();
		} catch (SQLException e1) {
			throw new DbException("get product: executeQuery failed");
		}
	}
	
	public void destroy(){
		try {
			statement.close();
		} catch (SQLException e) {
			throw new DbException();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			throw new DbException();
		}
	}
}
