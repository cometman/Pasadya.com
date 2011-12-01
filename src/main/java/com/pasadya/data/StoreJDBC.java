package com.pasadya.data;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.pasadya.data.util.PropertiesLoader;

public abstract class StoreJDBC implements IShopDAO, Serializable {

	protected Properties dbProperties;

	private static final long serialVersionUID = 7047510507515434310L;

	static List<ItemVO> itemInventory = new ArrayList<ItemVO>();

	private static ItemVO item1 = new ItemVO();
	private static ItemVO item2 = new ItemVO();
	private static ItemVO item3 = new ItemVO();
	private static ItemVO item4 = new ItemVO();
	private static ItemVO item5 = new ItemVO();
	private static ItemVO item6 = new ItemVO();
	private static ItemVO item7 = new ItemVO();

	public StoreJDBC() {
		Properties config = PropertiesLoader.loadProperties(PropertiesLoader.CONFIGURATION_PROPERTIES_FILE);
		String dbPropsFile = config.getProperty(PropertiesLoader.CONFIG_KEY_DAO_PROPS_FILE);
		
		this.dbProperties = PropertiesLoader.loadProperties(dbPropsFile);		
	}

	public static void setTestShopItems() {
		item1.itemName = "test item 1";
		item1.itemId = 1;
		item2.itemName = "test item 2";
		item2.itemId = 2;
		itemInventory.add(item1);
		itemInventory.add(item2);

		item3.itemName = "test item 1";
		item3.itemId = 3;
		item4.itemName = "test item 2";
		item4.itemId = 4;
		itemInventory.add(item3);
		itemInventory.add(item4);

		item5.itemName = "test item 1";
		item5.itemId = 5;
		item6.itemName = "test item 2";
		item6.itemId = 6;
		itemInventory.add(item5);
		itemInventory.add(item6);

		item7.itemName = "test item 2";
		item7.itemId = 7;
		itemInventory.add(item7);

	}

	public static List<ItemVO> getTestItems() {
		setTestShopItems();
		return itemInventory;
	}
	public List<ItemVO> getShopItems() {

		return itemInventory;
	}

	// Production Implementation Code

	public List<CategoryVO> getTopCategories() throws SQLException {
		List<CategoryVO> topCategories = new ArrayList<CategoryVO>();

		Connection connection = null;

		try {
			connection = this.getConnection();
			final String query = "SELECT * FROM Categories WHERE parent_category IS NULL";
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			resultSet.next();

			resultSet.beforeFirst();

			while (resultSet.next()) {
				CategoryVO category = new CategoryVO();

				category.setCategoryID(resultSet.getInt(1));
				category.setCategoryName(resultSet.getString(2));
				category.setParentCategory(resultSet.getInt(3));
				category.setCategoryDescription(resultSet.getString(4));

				topCategories.add(category);
				System.out.println(resultSet.getString(2));
			}
			resultSet.close();

		} catch (SQLException e) {

		} finally {
			catchAndClose(connection);
		}
		return topCategories;
	}

	public List<CategoryVO> getChildrenCategoriesByParentID(int id) {
		List<CategoryVO> childrenCategories = null;
		CategoryVO category = null;

		childrenCategories.add(category);

		return childrenCategories;

	}

	public List<ItemVO> getAllShopItems() {
		List<ItemVO> shopItems = new ArrayList<ItemVO>();
		
		Connection connection = null;

		try {
			connection = this.getConnection();
			System.out.println("Connection Successful");
			final String query = "SELECT * FROM Inventory";
			PreparedStatement preparedStatement = connection
					.prepareStatement(query);

			ResultSet resultSet = preparedStatement.executeQuery();

			resultSet.beforeFirst();

			while (resultSet.next()) {
				System.out.println("Fetching...\n");
				shopItems.add(this.mapItem(resultSet));
			}
			resultSet.close();

		} catch (SQLException e) {
			System.out.println("MySQL error in getting All items");
			e.printStackTrace();
		} finally {
			catchAndClose(connection);
		}
		return shopItems;
	}

	public List<ItemVO> getShopItemsByCategoryID(int id) {

		List<ItemVO> inventory = new ArrayList<ItemVO>();
		Connection connection = null;
		try {
			connection = this.getConnection();
			final String query = "SELECT * FROM Inventory WHERE category = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			resultSet.next();

			resultSet.beforeFirst();

			while (resultSet.next()) {
				ItemVO item = new ItemVO();
				item.setItemName(resultSet.getString(2));
				item.setItemDescription(resultSet.getString(3));
				item.setItemPrice(resultSet.getString(4));
				inventory.add(item);
			}
			resultSet.close();
		} catch (SQLException e) {

		} finally {
			catchAndClose(connection);
		}
		return inventory;
	}

	public ItemVO getShopItemByID(int id) {
		ItemVO item = null;

		return item;
	}

	// Convenience method for closing the database and throwing errors

	private void catchAndClose(Connection conn) {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			// Swallow the connection
		}
	}

	// Abstract method for getting the database Conneciton
	protected abstract Connection getConnection() throws SQLException;

	// Map the result set of the db query to the VO
	private ItemVO mapItem(ResultSet resultSet) throws SQLException {
		final ItemVO item = new ItemVO();
		item.setItemCategory(resultSet.getString("category"));
		item.setItemDescription(resultSet.getString("description"));
		item.setItemName(resultSet.getString("name"));
		item.setItemPrice(resultSet.getString("price"));

		return item;
	}

}
