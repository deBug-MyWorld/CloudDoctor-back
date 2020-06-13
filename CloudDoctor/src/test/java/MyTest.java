import com.ccsu.clouddoctor.service.UserService;
import com.ccsu.clouddoctor.utils.Md5;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    static Logger logger = Logger.getLogger(MyTest.class);
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userServiceImpl = (UserService) context.getBean("UserServiceImpl");
    }
    @Test
    public void testLog4j(){
        logger.info("info:进入了testLog4j");
    }

    public static void main(String[] args) {
        System.out.println(Md5.generate("admin"));
    }

}
