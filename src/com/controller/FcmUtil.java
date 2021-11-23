package com.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.annotation.Resource;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.frame.Service;
import com.vo.Product;

@Controller
public class FcmUtil {
	public final static String API_KEY = "AAAAYvjDfYA:APA91bEQrannKWcMFgyJgxMx5nZskLDkCoW2o_aIssy_ZEkuI-9i4DXQ2uHtRGITV96IceQXazRyeHHdZpK2I7cZiBUPO7LTAQp_iOxCs0SEaog-yFnV8GHFGAAYlRVc0d8BqHlnJaG_";
	public final static String URL = "https://fcm.googleapis.com/fcm/send";

	public static void sendServer(
			int f_temp, int f_humi) throws Exception{
		URL url = new URL(URL);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/json");
		conn.setRequestProperty("Authorization", "key=" + API_KEY);
		conn.setDoOutput(true);

		JSONObject notification = new JSONObject();

		notification.put("title", "타이틀입니다.");
		notification.put("body", "바디입니다.");
		
		JSONObject sdata = new JSONObject();
		sdata.put("c1", f_temp+"");
		sdata.put("c2", f_humi+"");
		
		JSONObject body = new JSONObject();
		body.put("notification", notification);
		body.put("data",sdata);
		body.put("to", "fw2d-EPKT0acq5z-AqcIn7:APA91bHJBHpV-dDyvAIQNufIxx1Rp6bJ1Wwey77hfqbSogFYIwBubXgdWmKjr3sWQOi2JwHbxDlgRehfqi_3nMHSog8LPPOD2GQKgMiPdHfNpREpXd-yr9wnh_KMAACK661SnLcBMgiE");

		OutputStream os = conn.getOutputStream();

		// 서버에서 날려서 한글 깨지는 사람은 아래처럼 UTF-8로 인코딩
		os.write(body.toJSONString().getBytes("UTF-8"));
		os.flush();
		os.close();

		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

	}

}
