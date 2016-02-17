package gyoung.dubbo.demo.provider;

/**
 * Created by zengjiyang on 2016/2/16.
 */
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.io.IOException;

public class DemoProvider {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:dubbo-demo-provider.xml");
        context.start();
        System.out.println("服务已经启动...");
        System.in.read();
    }
}