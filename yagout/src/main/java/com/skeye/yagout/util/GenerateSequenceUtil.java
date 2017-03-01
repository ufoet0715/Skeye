package com.skeye.yagout.util;
import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.Format;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;


public class GenerateSequenceUtil {

    /** .log */
    private static final Logger logger = Logger.getLogger(GenerateSequenceUtil.class);

    /** The FieldPosition. */
    private static final FieldPosition HELPER_POSITION = new FieldPosition(0);

    /** This Format for format the data to special format. */
    private final static Format dateFormat = new SimpleDateFormat("MMddHHmmssS");

    /** This Format for format the number to special format. */
    private final static NumberFormat numberFormat = new DecimalFormat("0000");

    /** This int is the sequence number ,the default value is 0. */
    private static int seq = 0;

    private static final int MAX = 9999;
    
    
    private static Date date = new Date();  
      //  private static StringBuilder buf = new StringBuilder();  
          private static final int ROTATION = 99999;  
          public static synchronized long next(){  
         if (seq > ROTATION) seq = 0;  
    //    buf.delete(0, buf.length());  
          date.setTime(System.currentTimeMillis());  
         String str = String.format("%1$tY%1$tm%1$td%1$tk%1$tM%1$tS%2$05d", date, seq++);  
         return Long.parseLong(str);  
     }  


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

        logger.info("THE SQUENCE IS :" + sb.toString());

        return sb.toString();
    }
}