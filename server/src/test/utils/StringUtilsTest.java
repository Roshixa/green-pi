package test.utils;

import main.beans.User;
import main.utils.StringUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class StringUtilsTest {

    @Test
    public void encrypt() {
        String md5 = StringUtils.encrypt("test");
        assertNotNull(md5);
        assertEquals("098F6BCD4621D373CADE4E832627B4F6", md5.toUpperCase());
    }

    @Test
    public void toJson() {
        User user = new User();
        assertEquals("{}", StringUtils.toJSON(user));

        user = new User(1, null, null, null);
        assertEquals("{\"id\":1}", StringUtils.toJSON(user));
    }
}
