package schedule.testing;

import org.junit.BeforeClass;
import org.junit.Test;
import schedule.dao.SysScheduleDao;
import schedule.dao.inplementation.SysScheduleDaoImpl;
import schedule.pojo.SysSchedule;

import java.util.List;

public class TestSysScheduleDao {
    private static SysScheduleDao sys ;

    @BeforeClass
    public static void initSysScheduleDao() {
        sys = new SysScheduleDaoImpl();
    }

    @Test
    public void testAddSchedule() {
        int rows = sys.addSchedule(new SysSchedule(null,2,"playing",1));
        System.out.println(rows);
    }

    @Test
    public void testFindALL() {
        List<SysSchedule> s =  sys.findAll();
        System.out.println(s);
    }
}
