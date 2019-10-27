import com.cyn.Application;
import com.cyn.Sender;
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
    private Sender sender;
    /**
     * 测试消息队列
     */
    @Test
    public void test() throws InterruptedException {
        while (true){
            Thread.sleep(1000);
            this.sender.send("Hello RabbitMQ");
        }
    }
}
