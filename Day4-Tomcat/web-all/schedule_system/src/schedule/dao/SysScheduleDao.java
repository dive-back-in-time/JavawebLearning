package schedule.dao;

import schedule.pojo.SysSchedule;

import java.util.List;

public interface SysScheduleDao {
    int addSchedule(SysSchedule sch);

    /**
     * 查询用户所有日程
     * @return 日程
     */
    List<SysSchedule> findAll();
}

