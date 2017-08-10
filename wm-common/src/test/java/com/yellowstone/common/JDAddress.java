package com.yellowstone.common;

import site.wmblog.common.http.HttpWebClient;
import org.apache.commons.lang3.StringUtils;
import org.htmlparser.Parser;
import org.htmlparser.tags.OptionTag;
import org.htmlparser.tags.SelectTag;
import org.htmlparser.util.NodeIterator;
import org.htmlparser.util.ParserException;


/**
 * Created by panwang.chengpw on 1/19/15.
 */
public class JDAddress {

    static String provinceUrl = "http://trade.jd.com/dynamic/consignee/getProvinces.action";
    static String cityUrl     = "http://trade.jd.com/dynamic/consignee/getCitys.action?consigneeParam.provinceId=";
    static String areaUrl     = "http://trade.jd.com/dynamic/consignee/getCountys.action?consigneeParam.cityId=";

    public static void main(String[] args) {

//        createAllCitySql();
        createCitySql("31");
    }

    public static void createProvinceSql() {
        String provinceHtml = HttpWebClient.get(provinceUrl);

        try {
            Parser parser = new Parser(provinceHtml);
            for (NodeIterator iterator = parser.elements(); iterator.hasMoreNodes(); ) {
                SelectTag selectTag = (SelectTag) iterator.nextNode();
                for (OptionTag optionTag : selectTag.getOptionTags()) {
                    System.out.println("insert into province (create_time, update_time, code, name) values (now(), now(), " +
                                       optionTag.getValue() + ", '" + optionTag.getOptionText().replace("*", "") + "');");
                }

            }
        } catch (ParserException e) {
            e.printStackTrace();
        }
    }

    public static void createAllCitySql() {
        String provinceHtml = HttpWebClient.get(provinceUrl);

        try {
            Parser parser = new Parser(provinceHtml);
            for (NodeIterator iterator = parser.elements(); iterator.hasMoreNodes(); ) {
                SelectTag selectTag = (SelectTag) iterator.nextNode();
                for (OptionTag optionTag : selectTag.getOptionTags()) {
                    if (optionTag.getOptionText().contains("请选择")) {
                        continue;
                    }

                    System.out.println("-- " + optionTag.getOptionText());
                    createCitySql(optionTag.getValue());
                }

            }
        } catch (ParserException e) {
            e.printStackTrace();
        }
    }

    public  static void createCitySql(String provinceId){
        String provinceHtml = HttpWebClient.get(cityUrl+provinceId);

        try {
            Parser parser = new Parser(provinceHtml);
            for (NodeIterator iterator = parser.elements(); iterator.hasMoreNodes(); ) {
                SelectTag selectTag = (SelectTag) iterator.nextNode();
                for (OptionTag optionTag : selectTag.getOptionTags()) {
                    if (optionTag.getOptionText().contains("请选择") || optionTag.getOptionText().contains("钓鱼岛")) {
                        continue;
                    }

                    System.out.println(
                            "insert into t_city (create_time, update_time, code, name, province_code) values (now(), now(), " +
                            optionTag.getValue() + ", '" + optionTag.getOptionText().replace("*", "") + "', '"+ provinceId + "');");

                    createAreaSql(optionTag.getValue());
                    Thread.sleep(200);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createAreaSql(String cityId) {
        String provinceHtml = HttpWebClient.get(areaUrl+cityId);

        try {
            if (StringUtils.isBlank(provinceHtml)) {
                return;
            }
            Parser parser = new Parser(provinceHtml);
            for (NodeIterator iterator = parser.elements(); iterator.hasMoreNodes(); ) {
                SelectTag selectTag = (SelectTag) iterator.nextNode();
                for (OptionTag optionTag : selectTag.getOptionTags()) {
                    if (optionTag.getOptionText().contains("请选择")) {
                        continue;
                    }

                    System.out.println(
                            "insert into t_area (create_time, update_time, code, name, city_code) values (now(), now(), " +
                            optionTag.getValue() + ", '" + optionTag.getOptionText().replace("*", "") + "', '" + cityId + "');");
                }

            }
        } catch (ParserException e) {
            e.printStackTrace();
        }
    }
}
