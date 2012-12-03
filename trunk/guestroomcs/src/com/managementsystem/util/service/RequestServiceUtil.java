package com.managementsystem.util.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

/**
 * 请求服务接口
 * */
public interface RequestServiceUtil<T> {
	
	List<T> getRequestResult(String reqUrl) throws MalformedURLException, IOException;
}
