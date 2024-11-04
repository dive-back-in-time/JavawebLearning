package schedule.dao.inplementation;

import schedule.dao.BaseDao;
import schedule.dao.SysUserDao;
import schedule.pojo.SysUser;

import java.util.List;

public class SysUserDaoImple extends BaseDao implements SysUserDao {
    @Override
    public int addSysUser(SysUser user) {
        String sql = "insert into sys_user values(DEFAULT,?,?)";
        int rows = baseUpdate(sql,user.getUsername(),user.getUserpwd());

        return rows;
    }

    @Override
    public SysUser findbyUser(String username) {
        String sql = "select uid,username,user_pwd as userpwd from sys_user where username = ?";
        List<SysUser> users = baseQuery(SysUser.class,sql,username);
        return (users!=null && users.size() > 0) ? users.get(0) : null;
    }
}
