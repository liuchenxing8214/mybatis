package com.itheima.dao;

import com.itheima.domain.QueryVo;
import com.itheima.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 *
 *
 * 用户的持久层接口
 */
public interface IUserDao {

    /**
     * 查询所有操作
     * @return
     */
    List<User> findAll();


    User findById(Integer userId);

    /**
     * 保存用户
     * @param user
     * @return 影响数据库记录的行数
     */
    int saveUser(User user);

    /**
     * @title  批量保存
     * @description
     * @author lc
 * @param: users
     * @updateTime 2020/12/6 12:21
 * @return: int
     * @throws
     */
    int batchInsert(List<User> users);

    /**
     * 更新用户
     * @param user
     * @return 影响数据库记录的行数
     */
    int updateUser(User user);

    /**
     * 根据用户信息，查询用户列表
     * @param user
     * @return
     */
    List<User> findByUser(User user);


    /**
     * 根据 id 集合查询用户
     * @param vo
     * @return
     */
    List<User> findInIds(QueryVo vo);


    List<User> betweenBy(@Param("minId") Integer minId,@Param("maxId") Integer maxId);


    int queryCount();

    List<User> twoFindInIds(@Param("ids") List<Integer> ids);


    List<Date> getDate();


    List<Map<String,String>> queryUser(@Param("columns") String columns,
                                       @Param("userName") String userName);

}

