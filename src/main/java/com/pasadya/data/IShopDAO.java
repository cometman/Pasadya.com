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
}
