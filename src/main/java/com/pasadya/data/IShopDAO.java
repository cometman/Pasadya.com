package com.pasadya.data;

import java.sql.SQLException;
import java.util.List;

public interface IShopDAO {
	List<CategoryVO> getTopCategories() throws SQLException;
	List<CategoryVO> getChildrenCategoriesByParentID(int id);
	List<ItemVO> getShopItemsByCategoryID(int id);
	ItemVO getShopItemByID(int id);
	List<ItemVO> getAllShopItems();
}
