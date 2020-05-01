package com.czk.SpringMybatis.Mapper;

import com.czk.SpringMybatis.POJO.MyRole;
import org.springframework.stereotype.Repository;

@Repository  // 注明是Mapper，采用mapper接口编程
public interface MyRoleMapper {
    int insertRole(MyRole role);
}
