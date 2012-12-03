package com.managementsystem.util.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.TypeFactory;

public class RequestServiceProcess<T> implements RequestServiceUtil<T>,
		java.io.Serializable {
	private static final long serialVersionUID = 995794702050738216L;

	private T obj;

	public RequestServiceProcess(T t) {
		this.obj = t;
	}

	@Override
	public List<T> getRequestResult(String reqUrl)
			throws MalformedURLException, IOException {
		List<T> result = new ArrayList<T>();
		URL url = new URL(reqUrl);

		StringBuilder sb = new StringBuilder();
		URLConnection URLconnection = url.openConnection();
		HttpURLConnection httpConnection = (HttpURLConnection) URLconnection;
		int responseCode = httpConnection.getResponseCode();
		if (responseCode == HttpURLConnection.HTTP_OK) {
			System.out.println("Http Request Url:" + url);
			// 获取查询结果
			InputStream urlStream = httpConnection.getInputStream();
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(urlStream));
			String currentLine = "";
			while ((currentLine = bufferedReader.readLine()) != null) {
				sb.append(currentLine);
			}
			// 转换JSON字符为LIST列表
			ObjectMapper mapper = new ObjectMapper();
			TypeFactory typeFactory = TypeFactory.defaultInstance();
			result = mapper.readValue(
					sb.toString(),
					typeFactory.constructCollectionType(List.class,
							obj.getClass()));
		} else {
			System.out.println("HttpURLConnection StatusCode:" + responseCode);
		}
		return result;
	}

}
