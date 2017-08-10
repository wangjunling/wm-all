package site.wmblog.common.util;

import java.util.Map;

import org.apache.commons.collections4.MapUtils;

import com.google.common.collect.Maps;

/**
 * Created by chengpanwang on 8/17/15.
 */
public class Counter {

    private Map<String, Long> countMap = Maps.newHashMap();

    public Long incr(String key) {
        Long num = MapUtils.getLong(countMap, key);
        if (num == null) {
            num = Long.valueOf(0l);
            countMap.put(key, num);
        }
        return ++num;
    }

    public Long decr(String key) {
        Long num = MapUtils.getLong(countMap, key);
        if (num == null) {
            num = Long.valueOf(0l);
            countMap.put(key, num);
        }

        return --num;
    }

    public void reset(String key) {
        countMap.put(key, Long.valueOf(0l));
    }

}
