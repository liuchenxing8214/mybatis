package com.itheima.test;

import com.itheima.dao.IUserDao;
import com.itheima.domain.QueryVo;
import com.itheima.domain.Student;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * mybatis的入门案例
 */
public class MybatisTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /* */
    /**
     * 入门案例
     *
     * @param args
     *//*
    public static void main(String[] args) throws Exception {
        //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂生产SqlSession对象
        SqlSession session = factory.openSession();
        //4.使用SqlSession创建Dao接口的代理对象
        IUserDao userDao = session.getMapper(IUserDao.class);
        //5.使用代理对象执行方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
        //6.释放资源
        session.close();
        in.close();
    }*/


    private InputStream in;
    private SqlSession sqlSession;
    private IUserDao userDao;


    @Before//用于在测试方法执行之前执行
    public void init() throws Exception {
        //1.读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.获取SqlSession对象
        sqlSession = factory.openSession();
        //4.获取dao的代理对象
        userDao = sqlSession.getMapper(IUserDao.class);
    }

    @After//用于在测试方法执行之后执行
    public void destroy() throws Exception {
        //提交事务
        sqlSession.commit();
        //6.释放资源
        sqlSession.close();
        in.close();
    }

    /**
     * 测试查询所有
     */
    @Test
    public void testFindAll() {
        //5.执行查询所有方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }

    }


    @Test
    public void testFindOne() {
        User user = userDao.findById(60);
        System.out.println(user);
    }

    /**
     * 测试保存操作
     */
    @Test
    public void testSave() {
        User user = new User();
        user.setUserName("modify User property");
        user.setUserAddress("北京市顺义区");
        user.setUserSex("女");
        user.setUserBirthday(new Date());
        System.out.println("保存操作之前：" + user);
        //5.执行保存方法
        userDao.saveUser(user);

        System.out.println("保存操作之后：" + user);
    }

    @Test
    public void batchSave() {
        List<User> users = new ArrayList<User>();
        for (int i = 11; i < 2000; i++) {
            User user = new User();
            user.setUserName("modify User property"+i);
            user.setUserAddress("北京市顺义区"+i);
            user.setUserSex("女");
            user.setUserBirthday(new Date());
            users.add(user);
        }
        long startTime = System.currentTimeMillis();   //获取开始时间
        userDao.batchInsert(users);
        long endTime = System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");

    }

@Test
public void betweenQuery(){
    List<User> users = userDao.betweenBy(1,100);
    for(User obj:users){
        System.out.println(obj);
    }
}


    /**
     * 测试更新操作
     */
    @Test
    public void testUpdate() {
        User user = new User();
        user.setUserId(61);
        user.setUserName("mybastis update user");
        user.setUserAddress("花果山睡莲洞");
        user.setUserSex("女");
        user.setUserBirthday(new Date());

        //5.执行保存方法
        userDao.updateUser(user);
    }


    @Test
    public void testFindByUser() {
        User u = new User();
        //u.setUserName("%王%");
        u.setUserAddress("%顺义%");
        // u.setUserSex("女");
        //6.执行操作
        List<User> users = userDao.findByUser(u);
        for (User user : users) {
            System.out.println(user);
        }
    }


    @Test
    public void testFindInIds() {
        QueryVo vo = new QueryVo();
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(41);
        ids.add(42);
        ids.add(43);
        ids.add(46);
        ids.add(1);
        vo.setIds(ids);
//6.执行操作
        List<User> users = userDao.findInIds(vo);
        for (User user : users) {
            System.out.println(user);
        }
    }


    @Test
    public void twoFindIds(){
        List<Integer> ids = new ArrayList<Integer>();
       ids.add(41);
        ids.add(42);
        ids.add(43);
        ids.add(46);
        ids.add(1);
        List<User> users =userDao.twoFindInIds(ids);
        for (User user : users) {
            System.out.println(user);
        }
    }


    @Test
    public void testFindAll1() {
//6.执行操作
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println("-------每个用户的内容---------");
            System.out.println(user);
            System.out.println(user.getAccounts());
        }
    }
    @Test
    public void queryCount(){
        int  a =  userDao.queryCount();
        System.out.println("a="+a);
    }

    @Test
    public void getUserList() {
        List<Student> studentList = jdbcTemplate.query("select * from student", new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet resultSet, int i) throws SQLException {
                Student user = new Student();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setAge(resultSet.getInt("age"));
                user.setCreate(resultSet.getInt("create"));
                return user;
            }
        });
        for(Student stu:studentList){
            System.out.println(stu.toString());
        }
    }

    @Test
    public void getDate_test(){
        List<Date> list = userDao.getDate();
        System.out.println(list.get(0));
        System.out.println(list);
    }


}

