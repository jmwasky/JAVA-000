package homework;

import com.isaac.scan.Student2;
import com.isaac.scan.Student3;
import io.isaac.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class Homework {

    @Resource
    private ApplicationContext context;

    @Resource
    private Student2 student2;


    /**
     *
     */
    @Test
    public void applicationContextTest () {
        Student student = (Student) context.getBean("student");
        System.out.println("bean加载方式一，xml setter装配：" + student.toString());


        Student studentCons = (Student) context.getBean("studentCons");
        System.out.println("bean加载方式二，xml 构造器 装配：" + studentCons.toString());


        /**
         * 扫描方式： 通过@Component/@Server/@Controller等方式注入
         */
        student2.setId(1231);
        student2.setAddress("function2");
        student2.setName("student2");
        System.out.println("bean加载方式三，Component等注解直接扫描：" + student2.toString());


        Student3 student3 = (Student3) context.getBean("student3");
        System.out.println("bean加载方式四，bean注解注入：" + student3.toString());

    }



}
