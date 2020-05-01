package com.czk.SpringMybatis.Service.Impl;

import com.czk.SpringMybatis.Mapper.MyRoleMapper;
import com.czk.SpringMybatis.POJO.MyRole;
import com.czk.SpringMybatis.Service.MyRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/*
* 采用事务
* */
@Service
public class MyRoleServiceImpl implements MyRoleService {

    @Autowired
    private MyRoleMapper myRoleMapper;

    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
    /*
     *事务管理器：
     * 设置隔离级别和传播行为
     * 传播行为：REQUIRES_NEW：无论是否存在当前事务，方法都会在新的事务中运行
     * 隔离级别：READ_COMMITTED 读/写提交
     *
     * */
    public int insert(MyRole role) {
        int i = myRoleMapper.insertRole(role);
        System.out.println("y");  //故意报错，看会不会回滚事务
        return i;
    }
}
