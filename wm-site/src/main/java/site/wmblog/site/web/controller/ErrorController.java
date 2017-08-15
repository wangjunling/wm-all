package site.wmblog.site.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import site.wmblog.common.web.springmvc.controller.BaseController;


@Controller
@RequestMapping("/error")
public class ErrorController extends BaseController {

    @RequestMapping("/404.htm")
    public String none() {
        return "error/404";
    }

    @RequestMapping("/500.htm")
    public String error() {
        return "error/500";
    }
}
