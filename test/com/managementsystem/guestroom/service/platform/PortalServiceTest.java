package com.managementsystem.guestroom.service.platform;

import java.util.UUID;

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

import com.managementsystem.guestroom.domain.hibernate.Portal;


@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class })
@Transactional
@ContextConfiguration(locations = { "file:./webapp/WEB-INF/guestroomcs-servlet.xml" })
public class PortalServiceTest {

	@Autowired
	private PortalService portalService;
	
	@Rollback(false)
	@Test
	public void getDefaultPortalinfo() {
		portalService.getDefaultPortalinfo();
	}
	
	@Rollback(false)
	@Test
	public void savePortal() {
		Portal portalinfo = new Portal();
		portalinfo.setPortalId(UUID.randomUUID().toString());
		portalinfo.setPortalName("客房控制系统");
		portalinfo.setPortalEnname("GRCS");
		portalService.save(portalinfo);
	}
	
}
