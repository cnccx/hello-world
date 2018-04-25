//import com.ztwl.TestApplication;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.test.context.junit4.SpringRunner;

/**
 * @program: ztwl-parent-demo
 * @description: 服务测试
 * @author: huangxu
 * @Copyright: Copyright (c)  厦门神州鹰软件科技有限公司
 * @version:
 * @create: 2018-03-03 16:43
 **/
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = TestApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
////@EnableAutoConfiguration
//public class ServerTest {
//
//    @Autowired
//    private TestRestTemplate restTemplate;
//
//    @Test
//    public void exampleTest() {
//        String body = this.restTemplate.getForObject("/name", String.class);
//        assert(body.equals("12"));
//    }

//    @Test
//    public void get() throws Exception {
//        Map<String,String> multiValueMap = new HashMap<>();
//        multiValueMap.put("username","lake");//传值，但要在url上配置相应的参数
//        ActResult result = testRestTemplate.getForObject("/test/get?username={username}",ActResult.class,multiValueMap);
//        Assert.assertEquals(result.getCode(),0);
//    }
//    
//}
