package site.wmblog.site.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import site.wmblog.common.result.AjaxResult;
import site.wmblog.entity.Tag;
import site.wmblog.service.TagService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/8/14.
 */
@Controller
public class TagController
{
    @Resource
    private TagService tagService;

    @RequestMapping(value = "/tags",method = RequestMethod.GET)
    @ResponseBody
    public AjaxResult get()
    {
        List<Tag> tagList = tagService.listAll();
        return new AjaxResult(tagList);
    }
}
