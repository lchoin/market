package com.jzf.market.common.utils;

import org.apache.log4j.Logger;

import java.text.*;
import java.util.Calendar;

/**
 * 酒店主键生成
 * @author feng
 *
 * 2016年12月23日 上午9:11:26
 */
public class IndentPKUtil {
	/** .log */
    private static final Logger logger = Logger.getLogger(IndentPKUtil.class);
 
    /** The FieldPosition. */
    private static final FieldPosition HELPER_POSITION = new FieldPosition(0);
 
    /** This Format for format the data to special format. */
    private final static Format dateFormat = new SimpleDateFormat("MMddHHmmssS");
 
    /** This Format for format the number to special format. */
    private final static NumberFormat numberFormat = new DecimalFormat("000");
 
    /** This int is the sequence number ,the default value is 0. */
    private static int seq = 0;
 
    private static final int MAX = 999;
 
    /**
     * 时间格式生成序列
     * @return String
     */
    public static synchronized String generateSequenceNo() {
 
        Calendar rightNow = Calendar.getInstance();
 
        StringBuffer sb = new StringBuffer();
 
        dateFormat.format(rightNow.getTime(), sb, HELPER_POSITION);
 
        numberFormat.format(seq, sb, HELPER_POSITION);
 
        if (seq == MAX) {
            seq = 0;
        } else {
            seq++;
        }
 
//        logger.info("THE SQUENCE IS :" + sb.toString());
 
        return sb.toString();
    }

    /*public static void main(String ...args){
        int i = 0;
        String str = null;
        while (i < 100){
            str = generateSequenceNo();
            System.out.println(str + " ; " + str.length());
            i++;
        }

    }*/
	
}
