import com.cyn.Application;
import com.cyn.OrderSender;
import com.cyn.ProductSender;
import com.cyn.UserSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author chenyn
 * @version 1.0
 * @date 2019/10/22 23:34
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class QueueTest {
    @Autowired
    private UserSender userSender;
    @Autowired
    private ProductSender productSender;
    @Autowired
    private OrderSender orderSender;
    /**
     * 测试消息队列
     */
    @Test
    public void test() {
        this.userSender.send("UserSender.......");
        this.productSender.send("ProductSender.......");
        this.orderSender.send("OrderSender.......");
    }
}
