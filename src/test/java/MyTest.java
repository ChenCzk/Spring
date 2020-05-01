
import com.czk.Spring.POJO.MyCollection;
import com.czk.Spring.POJO.Person;
import com.czk.Spring.POJO.Role;
import com.czk.Spring.annotation.MyConfiguration.PojoConfig;
import com.czk.Spring.annotation.Myinterface.asdService;
import com.czk.Spring.annotation.ZJPOJO.ZJRole;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    ApplicationContext context;
    /*
     * XML
     * */
    @Test
    public void test1() {
        // 加载配置文件
        context = new ClassPathXmlApplicationContext("Spring.xml");
        Person person1 = (Person) context.getBean("person1"); //setter注入
        Person person2 = (Person) context.getBean("person2"); //构造器注入
        Object role4 = context.getBean("role4");
        System.out.println(role4);
        //集合注入
        MyCollection c = (MyCollection) context.getBean("myCollection");
    }

    /*
     * 注解
     * */
    @Test
    public void test2() {
        context = new AnnotationConfigApplicationContext(PojoConfig.class);
        ZJRole zjRole = (ZJRole) context.getBean("zjRole");
        System.out.println(zjRole);
    }

    /*
     * 切面
     * */
    @Test
    public void test3() {
        context = new AnnotationConfigApplicationContext(PojoConfig.class);
//        RoleService bean = context.getBean(RoleService.class);
//        ZJRole role = bean.getRole();
//        System.out.println(role);
        asdService bean = context.getBean(asdService.class);
        bean.get(new Role(1, "asd", "sd", "sd"), 110);
    }
}
