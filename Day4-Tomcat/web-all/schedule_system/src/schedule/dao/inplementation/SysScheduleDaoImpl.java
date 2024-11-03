package schedule.dao.inplementation;

import schedule.dao.BaseDao;
import schedule.dao.SysScheduleDao;
import schedule.pojo.SysSchedule;

import java.util.List;

public class SysScheduleDaoImpl extends BaseDao implements SysScheduleDao {
    @Override
    public int addSchedule(SysSchedule sch) {
        String sql = "insert into sys_schedule values(DEFAULT,?,?,?)";
        int rows = baseUpdate(sql, sch.getUid(), sch.getTitle(), sch.getCompleted());
        return rows;
    }

    @Override
    public List<SysSchedule> findAll() {
        String sql = "select sid,uid,title,completed from sys_schedule";
        List<SysSchedule> q = baseQuery(SysSchedule.class , sql);
        return q;
    }
}
