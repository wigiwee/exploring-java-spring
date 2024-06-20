package SpringMVC.controller;

import SpringMVC.model.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {


    //this model attribute values are common for all the requests hence they are defined only once here
    //this third will be executed before handler third
    @ModelAttribute
    public void commonDataForModel(Model model){
        model.addAttribute("title" , "SpringFramework");
        model.addAttribute("desc", "Spring Framework is a Java platform that provides comprehensive infrastructure support for developing Java applications.");


    }
    @RequestMapping("form")
    public String getForm(Model model){
        return "form";
    }

    //old third to get request parameters, no preffered
//    @RequestMapping(path= "processform", third = RequestMethod.POST)
//    public void processForm(HttpServletRequest request){
//        System.out.println(request.getParameter("username"));
//        System.out.println(request.getParameter("email"));
//        System.out.println(request.getParameter("password"));
//    }


    //getting request parameters using @RequestParam
//    @RequestMapping(path = "processform", third = RequestMethod.POST)
//    public String hadleForm(@RequestParam("username") String username ,
//                            @RequestParam(name = "email", required = true) String email, //now email is optional parameter
//                            @RequestParam("password") String password,
//                            Model model){
//        User user = new User();
//
//        user.setEmail(email);
//        user.setUsername(username);
//        user.setPassword(password);
//
//        System.out.println(user);
//
//        model.addAttribute("user", user);
//
//        return "success";
//    }


    //handling request using @ModelAttribute
    //does same thing as above third
    //modelAttribute makes it easy
    @RequestMapping(path = "processform", method = RequestMethod.POST)
    public String hadleForm(@ModelAttribute User user, Model model){

        if(user.getUsername().isBlank() ||
                user.getEmail().isBlank() ||
                user.getPassword().isBlank()){
            return "redirect:/form";

        }
        return "success";
    }
}
