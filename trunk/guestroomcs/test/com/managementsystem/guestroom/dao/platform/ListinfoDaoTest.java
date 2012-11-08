package com.managementsystem.guestroom.dao.platform;

import static org.junit.Assert.*;

import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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

import com.managementsystem.guestroom.domain.hibernate.Listinfo;


@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class })
@Transactional
@ContextConfiguration(locations = { "file:./webapp/WEB-INF/guestroomcs-servlet.xml" })
public class ListinfoDaoTest {

	private final Log logger = LogFactory.getLog(ListinfoDaoTest.class);
	
	@Autowired
	private ListinfoDao listinfoDao;
	
	@Rollback(false)
	@Test
	public void getListinfoDictionary() {
		Set<Listinfo> listDictironary = listinfoDao.getListinfoDictionary();
		assertNotNull("size is no null !",listDictironary.size());   

	}
	
	
}
