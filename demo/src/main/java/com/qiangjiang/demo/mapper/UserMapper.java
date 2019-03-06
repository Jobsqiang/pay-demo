package com.qiangjiang.demo.mapper;

import com.qiangjiang.demo.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    int insert(User user);
}
