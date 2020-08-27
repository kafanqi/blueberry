package com.jiafly.blueberry.common.utils;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 时间工具类
 *
 * @author liuyi
 */
@Component
public class DateUtils {

    /**
     * 时间格式
     */
    public final static String DATE_PATTERN_STAMP = "yyyyMMddHHmmssSSS";
    public final static String DATE_PATTERN_LONG = "yyyy-MM-dd HH:mm:ss";
    public final static String DATE_PATTERN_SHORT = "yyyy-MM-dd";
    public final static Long ONE_DAY_MILLISECOND = 86400000L;

    /**
     * 获取当前时间的格式
     *
     * @param format 时间格式
     * @return 时间
     */
    public static String getCurrentDatePattern(String format) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern(format);
        LocalDateTime now = LocalDateTime.now();
        return df.format(now);
    }

}
