package schedule.service.impl;

import schedule.dao.SysUserDao;
import schedule.dao.inplementation.SysUserDaoImple;
import schedule.pojo.SysUser;
import schedule.service.SysUserService;
import schedule.util.MD5Util;

public class SysUserServiceImpl implements SysUserService {
    private SysUserDao sysuserdao = new SysUserDaoImple();

    @Override
    public boolean register(SysUser user) {
        //将明文密码转换成密文密码
        String userPwd = user.getUserpwd();
        String userPwdResult = MD5Util.encrypt(userPwd);
        user.setUserpwd(userPwdResult);


        //将user信息存入数据库
        //调用dao层方法
        int rows = sysuserdao.addSysUser(user);
        if (rows > 0) {
            return true;
        }


        return false;
    }

    @Override
    public boolean login(SysUser user) {
        return false;
    }

    @Override
    public SysUser findbyUser(String username) {
        //调用dao层方法
        SysUser sysUser = sysuserdao.findbyUser(username);
        return sysUser;
    }
}
