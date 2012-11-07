package com.managementsystem.guestroom.dao.biz.impl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.managementsystem.guestroom.dao.biz.RoomDao;
import com.managementsystem.guestroom.domain.hibernate.Room;
import com.managementsystem.util.dao.AbstractDaoSupport;

@Repository
public class RoomDaoImpl extends AbstractDaoSupport implements RoomDao {

	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(
			Arrays.asList(new Class<?>[] { Room.class }));

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public Set<Room> getRoomsByFloorId(String floorId) throws DataAccessException {
		final String sql = "from Room where floor.floorId=? order by roomNo";
		Query query = createQuery(sql, 0, -1, floorId);
		return new HashSet<Room>(query.list());
	}

	@Override
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Set<Class<?>> getTypes() {
		return dataTypes;
	}

	@Override
	public boolean canBeMerged(Object o) {
		return true;
	}

}
