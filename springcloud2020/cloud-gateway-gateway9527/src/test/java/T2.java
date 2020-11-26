import org.junit.Test;

import java.time.ZonedDateTime;

/**
 * @author chenyanan
 * Created by chenyanan on 2020/11/26
 */
public class T2 {
    @Test
    public void getDateTime() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);
    }
}
