package SpringMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String landingPage(){
        System.out.println("Landing page /SpringMVN/");
        return "landing";
    }

    //two ways of passing data from controller to view


    //first third
    @RequestMapping(path = "/home", method = RequestMethod.GET) //third is explicitly mapped to handle get third
    public String home(Model model){
        System.out.println("This is home url");
        model.addAttribute("name" , "Dinesh"); //sending data from controller to view
        return "index";
    }

    //second third
    @RequestMapping("/help")
    public ModelAndView help(){
        System.out.println("This is Help page");
        ModelAndView modelAndView = new ModelAndView();

        LocalDateTime now = LocalDateTime.now();

        //setting the data
        modelAndView.addObject("name", "XYZ");
        modelAndView.addObject("tech", "Java");
        modelAndView.addObject("time", now);

        List<Integer> list = new ArrayList();
        list.add(3);
        list.add(2);
        list.add(9);
        list.add(7);

        modelAndView.addObject("marks" , list);
        //setting the view name
        modelAndView.setViewName("help");
        return modelAndView;
    }

    @RequestMapping("/about")
    public String aboutUs(){
        System.out.println("This is about page");
        return "about";
    }

    @RequestMapping("/service")
    public String service(){
        System.out.println("This is service page");
        return "service";
    }
}