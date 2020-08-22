package com.jiafly.blueberry.domain.repository;

import com.jiafly.blueberry.domain.model.User;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author liuyi
 */
@org.apache.ibatis.annotations.Mapper
public interface UserRepository extends Mapper<User> {
}
