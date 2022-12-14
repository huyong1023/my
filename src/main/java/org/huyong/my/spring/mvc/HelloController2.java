package org.huyong.my.spring.mvc;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController2{


    @ModelAttribute
    public void model(Model model) {
        model.addAttribute("message", "注解成功");
    }

    @RequestMapping("/value")
    public String handleRequest() {
        return "test1";
    }

    @RequestMapping("/hello")
    public ModelAndView handleRequest(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("message", "Hello Spring MVC");
        return mav;
    }



    @RequestMapping("/param")
    public ModelAndView getParam(@RequestParam("username1") String userName,
                                 String password) {
        System.out.println(userName);
        System.out.println(password);
        return null;
    }
}
