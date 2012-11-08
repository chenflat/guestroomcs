package com.managementsystem.guestroom.service.biz;

import java.util.Set;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.managementsystem.guestroom.domain.hibernate.Build;

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class })
@Transactional
@ContextConfiguration(locations = { "file:./webapp/WEB-INF/guestroomcs-servlet.xml" })
public class BuildServiceTest {

	@Autowired
	private BuildService buildService;

	@Test
	public void getBuilds() {
		Set<Build> builds =  buildService.getBuilds();
		Assert.assertEquals(builds.size()>0, true);
	}

	@Test
	public void getBuildsByHotelId() {
		String hotelId = "1";
		buildService.getBuildsByHotelId(hotelId);
	}
}
