package site.wmblog.site.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/8/14.
 */
@Controller("/index")
public class IndexController
{
    @RequestMapping("/index.htm")
    public String index()
    {
        return "index";
    }
}
