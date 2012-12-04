package com.managementsystem.guestroom.service.biz;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;

import com.managementsystem.guestroom.domain.platform.Histroylog;
import com.managementsystem.guestroom.domain.platform.Roomcounter;
import com.managementsystem.guestroom.domain.platform.Roomview;

/**
 * 客房服务请求
 * 
 * @author ping.chen
 * */
public interface RequestService {

	public static final String PROPERTYFILE = "requestservice.properties";
	public static final String HOSTURL = "hosturl";
	public static final String ROOMCOUNTER = "roomcounter";
	public static final String ROOMVIEW = "roomview";
	public static final String CLEARSERVICE = "clearservice";
	public static final String SETVALUE = "setvalue";
	public static final String QUERYPROCESS = "queryprocess";
	public static final String QUERYRECORDSET = "queryrecordset";
	public static final String SYNCTIME = "synctime";

	/**
	 * 获取服务请求总数
	 * */
	public Roomcounter getRoomcounter() throws MalformedURLException,IOException;

	/**
	 * 获取客房视图
	 * <p>
	 * (可任意组合 1=服务请求 2=SOS 4=出租状态 8=HVAC 16=通讯故障 32=能耗)
	 * </p>
	 * 
	 * @param type
	 *            服务类型
	 * */
	public List<Map<String, String>> getRoomviews(int type) throws MalformedURLException,IOException;

	/**
	 * 清除服务请求
	 * <p>
	 * 清除服务请求(可任意组合 1=订餐 2=收餐盘 4=管家 8=叫服务员 16=叫经理 32=擦鞋 64=毛巾 128=浴巾 256=纸巾
	 * 512=遥控器 1024=插线板) <br />
	 * for example: /rd/clearservice?roomNo=233&type=65535
	 * </p>
	 * 
	 * @param roomNo
	 *            房间编号
	 * @param type
	 *            服务类型
	 * */
	public List<Map<String, String>> clearService(String roomNo, int type) throws MalformedURLException,IOException;

	/**
	 * 修改客房的设定参数
	 * 
	 * <p>
	 * for example:/rd/setvalue?roomNo=233&p=1&value=23.0
	 * </p>
	 * 
	 * @param roomNo
	 *            房间号
	 * @param value
	 *            设置值
	 * 
	 * */
	public void setValue(String roomNo, String value) throws MalformedURLException,IOException;

	/**
	 * 查询过程曲线数据
	 * <p>
	 * (p是参数序号 0=设定温度 1=温度 2=风扇转速 3=阀门...) <br>
	 * for example: {@link
	 * /hd/query/p?roomNo=0112&p=1&tfrom=2011-5-6T00:00:00&tto=2011-5-7T0:00:00&
	 * tspan=3600}
	 * </p>
	 * 
	 * @param parameters
	 *            查询参数
	 * */
	public List<Histroylog> query(Map<String,String> parameters) throws MalformedURLException,IOException;

	/**
	 * 查询记录数据
	 * <p>
	 * (p是参数序号 0=设定温度 1=温度 2=风扇转速 3=阀门...) <br>
	 * for
	 * example：/hd/query/r?roomNo=0112&p=1&tfrom=2011-5-6T00:00:00&tcount=1000
	 * </p>
	 * 
	 * @param parameters
	 *            查询参数
	 * */
	public List<Histroylog> queryHistory(Map<String,String> parameters) throws MalformedURLException,IOException;

	/**
	 * 同步服务器时间
	 * */
	public  List<Map<String, String>> synctime() throws MalformedURLException,IOException;
	
}
