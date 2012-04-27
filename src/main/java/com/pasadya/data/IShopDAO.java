package com.pasadya.data;

import java.sql.SQLException;
import java.util.List;

public interface IShopDAO {
	public List<CategoryVO> getTopCategories() throws SQLException;
	public List<CategoryVO> getChildrenCategoriesByParentID(int id);
	public List<ItemVO> getShopItemsByCategoryID(int id);
	public ItemVO getShopItemByID(int id);
	public List<ItemVO> getAllShopItems();
	public MemberVO getMemberInformation(String id, Boolean auth);
	public void setMemberInformation(MemberVO member);
	public boolean checkMemberEmail(String email);
	public boolean checkMemberUsername(String username);
	public boolean authenticateUser(String username, String password);
	public boolean updateShopItem(ItemVO updates);
	public boolean addShopItem(String name, double price, double salePrice, String description, String category, String publishStatus);
}
