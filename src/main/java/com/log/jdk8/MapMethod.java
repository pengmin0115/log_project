package com.log.jdk8;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author pengmin
 * @date 2021/3/3 20:16
 */

public class MapMethod {

    /**
     * 测试Map中的values方法;
     * <p>
     * values(): 获取map集合中的值的集合;
     */
    public static void valuesMethod() {
        Map<String, String> map = new HashMap<>(16);
        map.put("1", "apple");
        map.put("2", "orange");
        map.put("3", "banana");
        Collection<String> values = map.values();
        for (String value : values) {
            System.out.println(value);
        }
    }



    public static void main(String[] args) {
        valuesMethod();
    }
}
