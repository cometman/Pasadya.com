package com.pasadya.unitTest;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pasadya.HomePage;
import com.pasadya.WicketApplication;
import com.pasadya.data.ConnectionDAO;
import com.pasadya.data.IShopDAO;
import com.pasadya.data.ItemVO;
import com.pasadya.data.MemberVO;
import com.pasadya.data.ShopFactory;

public class BaseUnitTest {
	Logger log = LoggerFactory.getLogger(BaseUnitTest.class);
	IShopDAO dao = ShopFactory.getInstance();

	@Test
	public void application_CanLoad() {
		WicketApplication app = new WicketApplication();
		assertNotNull(app);
	}

	@Test
	public void dao_didGetCreated() {
		assertNotNull(dao);
	}

	@Test
	public void application_canFetchItems() {
		assertNotNull(dao.getAllShopItems());
		for (ItemVO item : dao.getAllShopItems()) {
			log.info("Fetching [" + item.getItemName() + "]");
		}
	}

	@Test
	public void application_canFetchMembers() {
		MemberVO test = dao.getMemberInformation("cometman", true);
		assertTrue(test.getFname().equalsIgnoreCase("clay"));
		log.info("Fetched User [" + test.getFname() + "]");
	}

	@Test
	public void storejdbc_canAccessNewMember_whenMemberIsAddedToDatabase() {
		MemberVO testMember = new MemberVO();
		testMember.setUsername("Bob87");
		testMember.setFname("Krispy");

		dao.setMemberInformation(testMember);
		assertNotNull(dao.getMemberInformation("Bob87", true).getFname());
	}

}
