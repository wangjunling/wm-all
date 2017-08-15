package site.wmblog.service.impl;

import org.springframework.stereotype.Service;
import site.wmblog.entity.Tag;
import site.wmblog.mapper.TagMapper;
import site.wmblog.service.TagService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/8/15.
 */
@Service
public class TagServiceImpl implements TagService {
    @Resource
    private TagMapper tagMapper;
    @Override
    public List<Tag> listAll() {
        return tagMapper.listAll();
    }
}
