package site.wmblog.common.spider;

//import org.apache.commons.io.IOUtils;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
//import us.codecraft.webmagic.Page;
//import us.codecraft.webmagic.Site;
//import us.codecraft.webmagic.Spider;
//import us.codecraft.webmagic.pipeline.ConsolePipeline;
//import us.codecraft.webmagic.processor.PageProcessor;
//import us.codecraft.xsoup.Xsoup;

/**
 * Created by Fe on 15/1/16.
 */
public class HouXuePageProcesser {//implements PageProcessor {
//
//    private Site site = Site.me().setDomain("http://www.houxue.com/");
//
//    @Override
//    public void process(Page page) {
//        page.addTargetRequest("http://www.houxue.com");
//        page.putField("one-category", page.getHtml().xpath("//li[@id=tabpanel2] //div[@class=tab_two and @class=ml10] //ul[@class=tablist and @class=bbd ] //li[@class=tab]").all());
//       // page.putField("daohang", page.getHtml().xpath("//li[@id=tabpanel2] //div[@class=tab_two and @class=ml10] //ul[@class=tablist and @class=bbd ] //li[@class=tab]/a/@clickid").all());
//       // page.putField("content", page.getHtml().xpath("//li[@id=tabpanel2] //div[@class=tab_two and @class=ml10] //ul[@class=tablist and @class=bbd ] //li[@class=tab]/a/text()").all());
//
//
//        StringBuffer oneSb = new StringBuffer();
//        StringBuffer twoSb = new StringBuffer();
//        StringBuffer threeSb = new StringBuffer();
//
//        List<String> oneCategoryHtml = (List)page.getResultItems().get("one-category");
//
//
//       // insert into category (id,create_time,update_time,name,sort,parent_id)
//        //values
//        //(SEQ_CATEGORY.NEXTVAL,sysdate,sysdate,'a',1,(select id from category where name = 'a'));//
//
//
//        for (String html : oneCategoryHtml) {
//            System.out.println(html);
//            //TODO 1级类目
//            String clickId = Xsoup.select(html,"//a/@clickid").get();
//            String content = Xsoup.select(html,"//a/text()").get();
//            String dataRel = Xsoup.select(html,"//a/@data-rel").get();
//            System.out.println(clickId + " | " + content + " | " + dataRel);
//
//            oneSb.append("insert into category (id,create_time,update_time,name,sort,parent_id)  values ");
//            oneSb.append("(SEQ_CATEGORY.NEXTVAL,sysdate,sysdate,'" + content + "',1,null); \n");
//
//
//
//            //TODO 2级类目
//            String twoCategoryHtml = Xsoup.select(page.getHtml().get(),"//ul[@class=tab_content and @class=pt10 and @class=type_con1] //li[@id="+ dataRel +"]").get();
//
//            Elements elements =Xsoup.select(twoCategoryHtml,"//li[@id="+ dataRel + "] //div[@class=fix]").getElements();
//            for (Iterator<Element> iterator = elements.iterator(); iterator.hasNext();) {
//                   Element element = iterator.next();
//
//                   String towCategoryName = Xsoup.select(element.html(),"//span/text()").get();
//
//                   twoSb.append("insert into category (id,create_time,update_time,name,sort,parent_id)  values ");
//                   twoSb.append("(SEQ_CATEGORY.NEXTVAL,sysdate,sysdate,'" + towCategoryName + "',1,(select id from category where name = '" + content + "')); \n");
//
//                   Elements threelements = Xsoup.select(element.html(),"//p[@class=r_con and @class=cell]/a/text()").getElements();
//
//                   for (Iterator<Element> threeItr = threelements.iterator(); threeItr.hasNext();) {
//                       String threeCategoryName = threeItr.next().text();
//
//                        threeSb.append("insert into category (id,create_time,update_time,name,sort,parent_id)  values ");
//                        threeSb.append("(SEQ_CATEGORY.NEXTVAL,sysdate,sysdate,'" + threeCategoryName + "',1,(select id from category where name = '" + towCategoryName + "')); \n");
//                   }
//            }
//        }
//
//        try {
//             File file = new File("/Users/Fe/Desktop/category.sql");
//            if (!file.exists()) {
//                 file.createNewFile();
//            }
//             IOUtils.write(oneSb.append(twoSb).append(threeSb).toString(),new FileOutputStream(file));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//
//
//    }
//
//    @Override//li[@id=tabpanel2]
//    public Site getSite() {
//        return site;
//    }
//
//    public static void main(String[] args) {
//        Spider.create(new HouXuePageProcesser()).addUrl("http://www.houxue.com")
//                .addPipeline(new ConsolePipeline()).run();
//
//
//    }
}
