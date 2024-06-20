package SpringMVC.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;

@Controller
public class RedirectController {

    //methods of redirecting


    //this is old method and not preferred
    @RequestMapping("zero")
    public String zero(HttpServletResponse response){
        System.out.println("This is first handler");
        try{
            response.sendRedirect("home");
        }catch (IOException e){
            e.printStackTrace();
        }
        return "";
    }

    //redirecting using prefix
    @RequestMapping("first")
    public String first(){
        System.out.println("This is first handler");
        return "redirect:/home";            //redirecting to /home (relative url)
    }

    //index page getting rendered at /second, no redirecting
    @RequestMapping("second")
    public String second(){
        System.out.println("This is second handler");
        return "index";
    }


    @RequestMapping("third")
    public RedirectView third(){
        System.out.println("This is third handler");
        RedirectView redirectView = new RedirectView();
//        redirectView.setUrl("about"); //to call relative url don't use /about,
        redirectView.setUrl("https://www.google.com"); // can redirect to any url
        return redirectView;
    }
}
