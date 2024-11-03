package testing;

import schedule.SysUser;

public class Testlombok {

    public void testAnnotation() {
        SysUser user = new SysUser();
        user.getUid();
    }
}
