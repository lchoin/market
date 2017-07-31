package com.jzf.market.common.utils;

import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.Format;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

import org.apache.log4j.Logger;

public class VerificationCode {
	/** .log */
	private static final Logger logger = Logger
			.getLogger(VerificationCode.class);

	/** The FieldPosition. */
	private static final FieldPosition HELPER_POSITION = new FieldPosition(0);

	private final static Format dateFormat = new SimpleDateFormat("MMddHHmmssS");

	/** This Format for format the number to special format. */
	private final static NumberFormat numberFormat1 = new DecimalFormat(
			"000000");

	private final static NumberFormat numberFormat2 = new DecimalFormat("0000");

	/** This int is the sequence number ,the default value is 0. */
	private static int seq = 0;

	private static final int MAX = 9999;

	/**
	 * 手机验证码 6位随机数生成
	 * 
	 * @return String
	 */
	public static synchronized Integer generateByPhone() {
		StringBuffer sb = new StringBuffer();

		numberFormat1
				.format(new Random().nextInt(1000000), sb, HELPER_POSITION);

		logger.info("手机验证码为:" + sb.toString());

		return Integer.parseInt(sb.toString());
	}

	/**
	 * 图形验证码 4位随机数生成
	 * 
	 * @return String
	 */
	public static synchronized String generateByImage() {
		StringBuffer sb = new StringBuffer();

		numberFormat2.format(new Random().nextInt(10000), sb, HELPER_POSITION);

		logger.info("图形验证码为:" + sb.toString());

		return sb.toString();
	}

	/**
	 * 随机数(根据时间) 17位随机数生成
	 * 
	 * @return String
	 */
	public static synchronized String generateByDate() {
		Calendar rightNow = Calendar.getInstance();

		StringBuffer sb = new StringBuffer();

		dateFormat.format(rightNow.getTime(), sb, HELPER_POSITION);

		numberFormat2.format(seq, sb, HELPER_POSITION);

		if (seq == MAX) {
			seq = 0;
		} else {
			seq++;
		}

		logger.info("17位随机数 :" + sb.toString());

		return sb.toString();
	}

	/**
	 * 随机生成32位随机数
	 * 
	 * @return
	 */
	public static String generateByRandom32() {
		char[] number = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
				'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
				'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
				'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
				'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5',
				'6', '7', '8', '9' };
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < 32; i++) {
			sb.append(number[random.nextInt(62)]);
		}

		return sb.toString();
	}

//	 public static void main(String[] args) {
//	 // for(int i = 0; i<10000;i++){
//	 // System.out.println(generateByDate());
//	 // }
//	 // String str = "aaaaaaaa";
//	 // System.out.println(StringUtils.isEmpty(str));
//	
//		 for(int i = 0; i<10000;i++){
//			 String str = generateByRandom32();
//			 System.out.println(str + " ; " + str.length());
//		 }
//		
//	 }
}
