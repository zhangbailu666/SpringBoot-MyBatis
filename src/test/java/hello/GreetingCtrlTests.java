//package hello;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import com.qbian.blog.controller.GreetingCtrl;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
///**
// * Created by dell on 2017/3/22.
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = GreetingCtrl.class)
//@AutoConfigureMockMvc
//public class GreetingCtrlTests {
//
//    @Autowired
//    MockMvc mockMvc;
//
//    @Test
//    public void noParamGreetingShouldReturnDefaultMessage() throws Exception{
//        this.mockMvc.perform(get("/greeting")).andDo(print()).andExpect(status().isOk())
//                .andExpect(jsonPath("$.content").value("Hello, lily!"));
//    }
//
//    @Test
//    public void paramGreetingShouldReturnTailoredMessage() throws Exception{
//        this.mockMvc.perform(get("/greeting").param("name", "jacky")).andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.content").value("Hello, jacky!"));
//    }
//}
