package com.managementsystem.guestroom.dao.biz.impl;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.managementsystem.guestroom.dao.biz.HotelDao;
import com.managementsystem.guestroom.dao.biz.RoomDao;
import com.managementsystem.guestroom.domain.hibernate.Hotel;
import com.managementsystem.guestroom.domain.hibernate.Room;
import com.managementsystem.util.dao.AbstractDaoSupport;

@Repository
public class RoomDaoImpl extends AbstractDaoSupport implements RoomDao {

	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(
			Arrays.asList(new Class<?>[] { Room.class }));

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private HotelDao hotelDao;

	@SuppressWarnings("unchecked")
	@Override
	public Set<Room> getRoomsByFloorId(String floorId)
			throws DataAccessException {
		final String sql = "from Room where floor.floorId=? order by roomNo*1";
		Query query = createQuery(sql, 0, -1, floorId);
		return new LinkedHashSet<Room>(query.list());
	}

	@Override
	public Set<Room> getRoomsByDefHotel() throws DataAccessException {
		Hotel defHotel = hotelDao.getDefaultHotel();
		final String sql = "from Room as room inner join room.floor floor inner join floor.build build where build.hotel.hotelId=? order by room.roomNo*1";
		Query query = createQuery(sql, 0, -1, defHotel.getHotelId());
		return new HashSet<Room>(query.list());
	}

	@Override
	public Set<Room> getRoomsByBuildId(String buildId)
			throws DataAccessException {
		final String sql = "select room.* from room join floor on room.floor_id=floor.floor_id where build_id=? order by room_no";
		SQLQuery query = createSQLQuery(sql, 0, -1, buildId);
		query.addEntity(Room.class);
		return new HashSet<Room>(query.list());
	}

	@Override
	public long getCountRoomsByBuildId(String buildId)
			throws DataAccessException {
		final String queryString = "select count(*) as count from room r inner join floor f on r.floor_id=f.floor_id where f.build_id=?";
		SQLQuery query = createSQLQuery(queryString, 0, -1, buildId);
		if (query.list() != null && query.list().size() > 0) {
			return ((BigInteger) query.list().get(0)).longValue();
		} else {
			return 0;
		}
	}

	@Override
	public long getCountRoomsByDefHotel() throws DataAccessException {
		Hotel defHotel = hotelDao.getDefaultHotel();
		final String queryString = "select count(r.room_no) from room r inner join floor f on r.floor_id=f.floor_id inner join build b on f.build_id=b.build_id where hotel_id=?";
		if (defHotel != null) {
			SQLQuery query = createSQLQuery(queryString, 0, -1,
					defHotel.getHotelId());
			if (query.list() != null && query.list().size() > 0) {
				return ((BigInteger) query.list().get(0)).longValue();
			}
		}
		return 0;
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
