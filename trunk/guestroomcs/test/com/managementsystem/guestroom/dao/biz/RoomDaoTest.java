package com.managementsystem.guestroom.dao.biz;

import java.math.BigInteger;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.managementsystem.guestroom.domain.hibernate.Room;

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class })
@Transactional
@ContextConfiguration(locations = { "file:./webapp/WEB-INF/guestroomcs-servlet.xml" })
public class RoomDaoTest {

	@Autowired
	private RoomDao roomDao;

	@Rollback(false)
	@Test
	public void getRoomsByDefHotel() {
		Set<Room> rooms = roomDao.getRoomsByDefHotel();
		Assert.assertTrue("Has Length", rooms.size() > 0);
	}

	@Rollback(false)
	@Test
	public void getCountRoomsByBuildId() {
		long totals = roomDao.getCountRoomsByBuildId("1");
		Assert.assertTrue("Has Length", totals>0);
		
	}
}
