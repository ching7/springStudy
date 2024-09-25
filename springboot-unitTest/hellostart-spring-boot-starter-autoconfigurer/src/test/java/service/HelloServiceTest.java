package service;

import bean.HelloProperties;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.powermock.api.mockito.PowerMockito.*;

@PowerMockIgnore("javax.management.*")
@PrepareForTest({})
@RunWith(PowerMockRunner.class)
public class HelloServiceTest {
    @Mock
    HelloProperties helloProperties;
    @InjectMocks
    HelloService helloService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * 以下代码由iFlyCode生成
     * 测试sayHello方法，输入一个常规的名字，预期返回带有前缀和后缀的问候语。
     * 输入：
     * name = John
     * 输出：	Hello-John-World
     */
    @Test
    public void testSayHelloWithNormalName() {
        when(helloProperties.getPrefix()).thenReturn("Hello");
        when(helloProperties.getSuffix()).thenReturn("World");
        /* 调用被测方法 */
        String result = helloService.sayHello("John");
        Assert.assertEquals("测试sayHello方法，输入一个常规的名字，预期返回带有前缀和后缀的问候语。", "Hello-John-World", result);

    }

    /**
     * 以下代码由iFlyCode生成
     * 测试sayHello方法，输入空字符串作为名字，预期返回只有前缀和后缀的问候语。
     * 输入：
     * name = null
     * 输出：	Hello--World
     */
    @Test
    public void testSayHelloWithEmptyName() {
        when(helloProperties.getPrefix()).thenReturn("Hello");
        when(helloProperties.getSuffix()).thenReturn("World");
        /* 调用被测方法 */
        String result = helloService.sayHello((String) null);
        Assert.assertEquals("测试sayHello方法，输入空字符串作为名字，预期返回只有前缀和后缀的问候语。", "Hello--World", result);

    }

    /**
     * 以下代码由iFlyCode生成
     * 测试sayHello方法，输入null作为名字，预期抛出NullPointerException异常。
     * 输入：
     * name = null
     * 输出：无
     */
    @Test
    public void testSayHelloWithNullName() {
        when(helloProperties.getPrefix()).thenReturn("Hello");
        when(helloProperties.getSuffix()).thenReturn("World");
        /* 调用被测方法 */
        String result = helloService.sayHello((String) null);
        Assert.assertEquals("测试sayHello方法，输入null作为名字，预期抛出NullPointerException异常。", null, result);

    }
}