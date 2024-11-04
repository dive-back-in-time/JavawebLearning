package schedule.testing;

import org.junit.Test;
import schedule.util.MD5Util;


public class TestEncrypt {
    @Test
    public void testEncrypting() {
        String md = MD5Util.encrypt("660906");
        System.out.println(md);
    }
}
