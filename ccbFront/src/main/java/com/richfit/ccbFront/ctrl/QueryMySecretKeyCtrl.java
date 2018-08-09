package com.richfit.ccbFront.ctrl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.richfit.ccbFront.service.QueryMySecretKeyServiceImpl;

import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping(value = "/ccb")
public class QueryMySecretKeyCtrl {
	private static final Logger logger = LoggerFactory.getLogger(QueryMySecretKeyCtrl.class);
	@Autowired
	QueryMySecretKeyServiceImpl service;

	@SuppressWarnings("restriction")
	@RequestMapping(value = "/mypubkey")
	public void excute(HttpServletResponse response, Map<String, String> map) throws Exception {
		logger.info("ccb查看我的秘钥：" + map.toString());
		String chanl_cust_no = map.get("chanl_cust_no");
		String type = map.get("type");
		if (isBlank(chanl_cust_no)) {
			chanl_cust_no = "SZ49042798004248401";
		}
		if (isBlank(type)) {
			type = "pub";
		}
		Map<String, String> param = new HashMap<>();
		param.put("chanl_cust_no", chanl_cust_no);
		param.put("type", type);
		byte[] result = service.execute(param);
		String result2 = bytesToHexString(result);
		logger.info("核心返给ccb的秘钥：" + result2);
		response.getOutputStream().write(result);
	}

	/**
	 * 把字节数组转换成16进制字符串
	 * 
	 * @param bArray
	 * @return
	 */
	public static final String bytesToHexString(byte[] bArray) {
		StringBuffer sb = new StringBuffer(bArray.length);
		String sTemp;
		for (int i = 0; i < bArray.length; i++) {
			sTemp = Integer.toHexString(0xFF & bArray[i]);
			if (sTemp.length() < 2)
				sb.append(0);
			sb.append(sTemp.toUpperCase());
		}
		return sb.toString();
	}

	public static boolean isBlank(String str) {
		int strLen;
		if (str == null || (strLen = str.length()) == 0) {
			return true;
		}
		for (int i = 0; i < strLen; i++) {
			if ((Character.isWhitespace(str.charAt(i)) == false)) {
				return false;
			}
		}
		return true;
	}
}
