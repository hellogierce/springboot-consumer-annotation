package com.richfit.ccbFront;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.richfit.ccbFront.util.HttpUtils;



public class CCBTest {
		@Test
		public void queryMySecretKey() throws Exception {
			try {
				Map<String, String> param=new HashMap<>();
				param.put("chanl_cust_no","SZ49042798004248401");
				param.put("type","pub");
				String result = HttpUtils.post("http://10.3.3.66:8080/ccb/mypubkey", param);
				System.out.println(result);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
}
