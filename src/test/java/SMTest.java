import com.czk.SpringMybatis.Configuration.MyConfiguration;
import com.czk.SpringMybatis.Mapper.MyRoleMapper;
import com.czk.SpringMybatis.POJO.MyRole;
import com.czk.SpringMybatis.Service.MyRoleService;
import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

public class SMTest {


    /*
    * XML实现Spring-Mybatis
    * */
    @Test
    public void test1(){
        ApplicationContext context =new ClassPathXmlApplicationContext("Spring-Mybatis/MyBatis_Spring.xml");
        MyRoleMapper mapper = context.getBean(MyRoleMapper.class);
        int i = mapper.insertRole(new MyRole(1, "czk", "asd"));
        System.out.println(i);
    }
    /*
    * Java装配实现Spring-Mybatis
    * */
    @Test
    public void test2(){
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class);
        MyRoleMapper mapper = context.getBean(MyRoleMapper.class);
        int i = mapper.insertRole(new MyRole(3, "czk3", "asd3"));
        System.out.println(i);
    }
    /*
    * 事务
    * */
    @Test
    public void test3(){
        // 注解
//        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class);
        // XML
        ApplicationContext context =new ClassPathXmlApplicationContext("Spring-Mybatis/MyBatis_Spring.xml");
        MyRoleService service = context.getBean(MyRoleService.class);
        int insert = service.insert(new MyRole(5, "czk5", "asd5"));
        System.out.println(insert);

    }

}
