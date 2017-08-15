package site.wmblog.mapper;

import site.wmblog.entity.Tag;

import java.util.List;

public interface TagMapper extends BaseMapper<Tag> {

    List<Tag> listAll();
}