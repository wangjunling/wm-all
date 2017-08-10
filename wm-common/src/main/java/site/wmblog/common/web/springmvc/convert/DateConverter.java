package site.wmblog.common.web.springmvc.convert;

import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

/**
 * Created by Fe on 15/6/25.
 */
public class DateConverter implements Converter<String, Date> {

    private static final Logger log = LoggerFactory.getLogger(DateConverter.class);


    @Override
    public Date convert(String source) {

        if (StringUtils.isBlank(source)) {
            return null;
        }

        Date result = null;
        try {
            result = DateUtils.parseDate(source, "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd");
        } catch (ParseException e) {

        }
        if (result == null) {
            log.error("日期转换错误！");
        }
        return result;
    }
}
