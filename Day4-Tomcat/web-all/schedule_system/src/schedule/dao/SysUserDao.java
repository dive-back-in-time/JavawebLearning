package schedule.dao;

import schedule.pojo.SysUser;

/**
 * 数据访问对象
 * 定义增删改查操作
 * 定义接口与实现类
 * 接口要写好文档
 */
public interface SysUserDao {
    /**
     * 向数据库中增加一条用户记录的方法
     * @param user 接收对应实现类
     * @return 返回增加的函数
     */
    int addSysUser(SysUser user);

    /**
     * 查询数据库中对应名字的对象信息
     * @param username
     * @return
     */
    SysUser findbyUser(String username);

}
