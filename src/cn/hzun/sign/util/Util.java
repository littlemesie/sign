package cn.hzun.sign.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * 通用工具类
 * @author mesie
 * 2016年5月8日 下午3:42:54
 */
public class Util {

	/**
	 * 判断字符串是否为空
	 * 
	 * @param str
	 *            字符串
	 * @return true：为空； false：非空
	 */
	public static boolean isNull(String str) {
		if (str != null && !str.trim().equals("")) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * MD5 加密
	 */
	public static String encryptMD5(String str) {
		MessageDigest messageDigest = null;

		try {
			messageDigest = MessageDigest.getInstance("MD5");

			messageDigest.reset();

			messageDigest.update(str.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException e) {
			System.out.println("NoSuchAlgorithmException caught!");
			System.exit(-1);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		byte[] byteArray = messageDigest.digest();

		StringBuffer md5StrBuff = new StringBuffer();

		for (int i = 0; i < byteArray.length; i++) {
			if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
				md5StrBuff.append("0").append(
						Integer.toHexString(0xFF & byteArray[i]));
			else
				md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
		}

		return md5StrBuff.toString();
	}

	/**
	 * 得到抛异常的信息
	 * 
	 * @param t
	 * @return
	 */
	public static String getTrace(Throwable t) {
		StringWriter stringWriter = new StringWriter();
		PrintWriter writer = new PrintWriter(stringWriter);
		t.printStackTrace(writer);
		StringBuffer buffer = stringWriter.getBuffer();
		return buffer.toString();
	}

	/**
	 * 随机产生一个9位的数字
	 * @return
	 */
	public static int randId(){
		StringBuilder str=new StringBuilder();
		Random random = new Random();
		for(int i = 0;i < 9;i++){
			str.append(random.nextInt(10));
		}
		int num = Integer.parseInt(str.toString());
		return num;
	}
	
	public static void main(String[] args) {
		System.out.println(Util.randId());
	}
}
