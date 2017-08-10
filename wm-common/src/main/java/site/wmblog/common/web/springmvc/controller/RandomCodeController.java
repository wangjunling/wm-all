package site.wmblog.common.web.springmvc.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import site.wmblog.common.http.RandomValidateCode;
import site.wmblog.common.result.AjaxResult;
import site.wmblog.common.web.RequestContext;
import site.wmblog.common.web.xuser.XUserSession;

/**
 * Created by panwang.chengpw on 7/2/15.
 */
@Controller
@RequestMapping("/common")
public class RandomCodeController extends BaseUserController {

    private RandomValidateCode randomValidateCode = new RandomValidateCode();

    @RequestMapping("/randCode.htm")
    @ResponseBody
    public void randomCode() {
        randomValidateCode.randCode(RequestContext.getRequest(), RequestContext.getResponse());
        logger.info(XUserSession.getCurrent().getRandomCode());

    }

    @RequestMapping("/checkCode.json")
    @ResponseBody
    public AjaxResult checkCode(String reqCode){
        String innerCode=XUserSession.getCurrent().getRandomCode();
        AjaxResult ajaxResult=newAjaxResult();
        if(!StringUtils.equals(reqCode,innerCode )){
            ajaxResult.setStatus(AjaxResult.STATUS_ERROR);
        }
        return ajaxResult;
    }
}
