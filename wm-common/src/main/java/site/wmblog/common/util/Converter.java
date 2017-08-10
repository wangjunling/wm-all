package site.wmblog.common.util;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by panwang.chengpw on 1/20/15.
 */
public class Converter {

    private final static Logger logger = LoggerFactory.getLogger(Converter.class);

    /**
     * 类型转换, 使用 #ConvertUtils.convert 方法, 增加了泛型
     * @param obj
     * @param clazz
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T convert(Object obj, Class<T> clazz) {
        if (obj == null) {
            return null;
        }

        return (T) ConvertUtils.convert(obj, clazz);
    }

    /**
     * 类型转换, 使用 #ConvertUtils.convert 方法, 增加了泛型
     * @param obj
     * @param clazz
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T convert(Object obj, Class<T> clazz, T defaultValue) {
        if (obj == null) {
            return defaultValue;
        }

        try {
            return (T) ConvertUtils.convert(obj, clazz);
        } catch (Exception e) {
            logger.warn("convert error", e.getMessage());
            return defaultValue;
        }
    }

    /**
     * 转换为String , 如果为null 返回 空字符串
     * @param obj
     * @return
     */
    public static String convert(Object obj) {
        if (obj == null) {
            return StringUtils.EMPTY;
        }

        return ConvertUtils.convert(obj);
    }

}
