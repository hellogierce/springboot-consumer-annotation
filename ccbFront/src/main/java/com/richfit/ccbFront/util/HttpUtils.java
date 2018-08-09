package com.richfit.ccbFront.util;

import okhttp3.*;
import okhttp3.FormBody.Builder;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhanglu on 2018/2/24.
 */
public class HttpUtils {
	public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

	public static String post(String url, String json) throws IOException {
		OkHttpClient client = new OkHttpClient().newBuilder().connectTimeout(5, TimeUnit.SECONDS)
				.readTimeout(10, TimeUnit.SECONDS).build();
		RequestBody body = RequestBody.create(JSON, json);
		Request request = new Request.Builder().url(url).post(body).build();
		Response response = client.newCall(request).execute();
		return response.body().string();
	}

	public static String post(String url, String key, String value) throws IOException {
		OkHttpClient client = new OkHttpClient().newBuilder().connectTimeout(5, TimeUnit.SECONDS)
				.readTimeout(5, TimeUnit.SECONDS).build();
		RequestBody body = new FormBody.Builder().add(key, value).build();
		Request request = new Request.Builder().url(url).post(body).build();
		Response response = client.newCall(request).execute();
		return response.body().string();
	}

	public static String post(String url, Map<String, String> param) throws IOException {
		OkHttpClient client = new OkHttpClient().newBuilder().connectTimeout(20, TimeUnit.SECONDS)
				.readTimeout(300, TimeUnit.SECONDS).build();
		Builder builder = new FormBody.Builder();
		if (param != null) {
			for (Entry<String, String> entry : param.entrySet()) {
				builder.add(entry.getKey(), entry.getValue());
			}
		}
		RequestBody body = builder.build();
		Request request = new Request.Builder().url(url).post(body).build();
		Response response = client.newCall(request).execute();
		return response.body().string();
	}

	public static String shut(String url) throws IOException {
		OkHttpClient httpClient = new OkHttpClient();
		Request request = new Request.Builder().url(url).build();
		Response response = httpClient.newCall(request).execute();
		return response.body().string();
	}
}
