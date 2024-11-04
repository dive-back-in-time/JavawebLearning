package schedule.service;

import schedule.pojo.SysUser;

/**
 * 定义以sys_user表格为核心的业务逻辑
 */
public interface SysUserService {
    /**
     * 注册用户方法
     * @param user 注册用户名与密码
     * @return 成功返回true,失败返回false
     */
    boolean register(SysUser user);

    boolean login(SysUser user);

    /**
     * 根据用户名称获得用户完整信息
     * @param username
     * @return
     */
    SysUser findbyUser(String username);
}
