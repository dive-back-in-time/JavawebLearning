package schedule.testing;

import org.junit.BeforeClass;
import org.junit.Test;
import schedule.dao.BaseDao;
import schedule.pojo.SysUser;

import java.util.List;

public class TestBaseDao {
    private static BaseDao base;

    @BeforeClass
    public static void initBaseDao() {
        base = new BaseDao();
    }

    @Test
    public void testBaseQueryObject() {
        //查询用户数量
        String sql = "select count(*) from sys_user";
        Long l = base.baseQueryObject(Long.class, sql);
        System.out.println(l);
    }

    @Test
    public void testBaseQuery() {
        String sql = "select uid, username,user_pwd as userpwd from sys_user";
        List<SysUser> o = base.baseQuery(SysUser.class, sql);
        o.forEach(System.out :: println);

    }

    @Test
    public void testBaseUpdate() {
        String sql = "insert into sys_schedule values(DEFAULT,?,?,?)";
        int rows = base.baseUpdate(sql,1,"学习java",0);
        System.out.println(rows);
    }


}
