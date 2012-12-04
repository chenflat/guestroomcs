package com.managementsystem.guestroom.service.biz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;

import org.apache.http.client.methods.HttpGet;

import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.TypeFactory;
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

import com.managementsystem.guestroom.domain.platform.Histroylog;
import com.managementsystem.guestroom.domain.platform.Roomcounter;
import com.managementsystem.guestroom.domain.platform.Roomview;

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class })
@Transactional
@ContextConfiguration(locations = { "file:./webapp/WEB-INF/guestroomcs-servlet.xml" })
public class RequestServiceTest {

	@Autowired
	private RequestService requestService;

	@Test
	public void getRoomcounter() {
		Roomcounter rc;
		try {
			rc = requestService.getRoomcounter();
			System.out.println(rc.toString());
		} catch (MalformedURLException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	@Test
	public void getRoomviews() {
		List<Map<String, String>> list;
		try {
			list = requestService.getRoomviews(12);
			/*for (Roomview rv : list) {
				System.out.println(rv.toString());
			}*/
		} catch (MalformedURLException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	@Test
	public void clearService() {
		List<Map<String, String>> list = null;
		try {
			list = requestService.clearService("3A15", 65535);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void query() {
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("roomNo", "0112");
		parameters.put("p", "1");
		parameters.put("tfrom", "2011-5-6T00:00:00");
		parameters.put("tto", "2011-5-7T0:00:00");
		parameters.put("tspan", "3600");
		List<Histroylog> list;
		try {
			list = requestService.query(parameters);
			for (Histroylog log : list) {
				System.out.println(log.toString());
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void queryHistory() {
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("roomNo", "0112");
		parameters.put("p", "1");
		parameters.put("tfrom", "2011-5-6T00:00:00");
		parameters.put("tcount", "100");
		List<Histroylog> list;
		try {
			list = requestService.queryHistory(parameters);
			for (Histroylog log : list) {
				System.out.println(log.toString());
			}
		} catch (MalformedURLException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		/*
		 * RequestServiceTest test = new RequestServiceTest(); for (int i = 0; i
		 * < 10; i++) { new Thread(test.new TestGet2(i + "")).start(); }
		 */
	}

	public void get() {
		// 核心应用类
		HttpClient httpClient = new DefaultHttpClient();

		// HTTP请求
		String url = "http://localhost:8082/rd/roomview?type=12";
		HttpUriRequest request = new HttpGet(url);
		request.addHeader("Connection", "Keep-Alive");

		// 打印请求信息
		System.out.println(request.getRequestLine());

		try {
			// 发送请求，返回响应
			HttpResponse response = httpClient.execute(request);

			// 打印响应信息
			System.out.println(response.getStatusLine());
			HttpEntity resEntity = response.getEntity();

			System.out.println("----------------------------------------");
			// System.out.println(response.getStatusLine());

			if (resEntity != null) {
				System.out.println("Response content length: "
						+ resEntity.getContentLength());
				InputStream is = resEntity.getContent();
				int len = 0;
				byte[] b = new byte[2000];
				while (true) {
					if ((len = is.read(b)) > 0) {
						String s = new String(b, 0, len);
						System.out.println(s);
					}
				}
			}

			EntityUtils.getContentCharSet(resEntity);

		} catch (ClientProtocolException e) {
			// 协议错误
			e.printStackTrace();
		} catch (IOException e) {
			// 网络异常
			e.printStackTrace();
		}
	}

	class TestGet2 implements Runnable {

		private String userId;
		private int count;

		public TestGet2(String userId) {
			this.userId = userId;
		}

		@Override
		public void run() {

			List<Roomview> list = new ArrayList<Roomview>();
			Set<Roomview> listset = new HashSet<Roomview>();
			URL url = null;
			try {
				url = new URL("http://localhost:8082/rd/roomview?type=12");
			} catch (MalformedURLException e) {
				e.printStackTrace();

			}
			StringBuilder sb = new StringBuilder();
			URLConnection URLconnection = null;
			try {
				URLconnection = url.openConnection();
				HttpURLConnection httpConnection = (HttpURLConnection) URLconnection;
				int responseCode = httpConnection.getResponseCode();
				if (responseCode == HttpURLConnection.HTTP_OK) {
					System.out.println(url);
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
					listset = mapper
							.readValue(sb.toString(), typeFactory
									.constructCollectionType(Set.class,
											Roomview.class));

					System.out
							.println("----------------------------------------");
					for (Roomview rv : listset) {
						System.out.println(rv.toString());
					}

				} else {
					System.out.println("HttpURLConnection StatusCode:"
							+ responseCode);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	class TestGet implements Runnable {
		private String userId;
		private int count;

		public TestGet(String userId) {
			this.userId = userId;
		}

		@Override
		public void run() {

			// 核心应用类
			HttpClient httpClient = new DefaultHttpClient();

			// HTTP请求
			String url = "http://localhost:8082/rd/roomview?type=12";
			HttpGet httpget = new HttpGet(url);
			httpget.setHeader("Connection", "keep-alive");

			// 打印请求信息
			System.out.println(httpget.getRequestLine());

			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			nvps.add(new BasicNameValuePair("userId", userId));

			try {
				// httpget.setEntity(new UrlEncodedFormEntity(nvps,
				// HTTP.UTF_8));
				// 发送请求，返回响应
				HttpResponse response = httpClient.execute(httpget);

				// 打印响应信息
				System.out.println(response.getStatusLine());
				HttpEntity resEntity = response.getEntity();

				System.out.println("----------------------------------------");
				// System.out.println(response.getStatusLine());

				if (resEntity != null) {
					System.out.println("Response content length: "
							+ resEntity.getContentLength());
					InputStream is = resEntity.getContent();
					int len = 0;
					byte[] b = new byte[4096];

					while (true) {
						try {
							if ((len = is.read(b)) > 0) {
								String s = new String(b, 0, len);
								// JSONObject.fromObject(s);
								// JSONObject jsonObject = new JSONObject();
								System.out.println(s);
								// JSONObject jsonObj=JSONObject.fromObject(s);

								ObjectMapper mapper = new ObjectMapper();
								TypeFactory typeFactory = TypeFactory
										.defaultInstance();

								// System.out.println(jsonObj
								// + "      " + count++
								// +"    "+Thread.currentThread().getName());
								// if(jsonObj.getLong("userId")==-1){
								// is.close();
								// break;
								// }

							}
						} catch (Exception e) {
							e.printStackTrace();
							try {
								is.close();
							} catch (Exception ee) {
								ee.printStackTrace();
							}
							break;
						}

					}

				}

				EntityUtils.getContentCharSet(resEntity);

			} catch (ClientProtocolException e) {
				// 协议错误
				e.printStackTrace();

			} catch (IOException e) {
				// 网络异常
				e.printStackTrace();
			}
		}

	}
}
