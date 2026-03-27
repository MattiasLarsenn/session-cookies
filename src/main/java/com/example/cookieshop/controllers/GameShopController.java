package com.example.cookieshop.controllers;

import com.example.cookieshop.repositories.GameRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class GameShopController {
    private GameRepository repo = new GameRepository();

    @GetMapping("/")
    public ModelAndView index(HttpSession session){
        return new ModelAndView("index");
    }

    @GetMapping("/basket")
    public ModelAndView basket(HttpSession session){
        return new ModelAndView("basket");
    }

    @GetMapping("/shop")
    public ModelAndView basket(HttpSession session, Model cookieModel){
        ModelAndView mav = new ModelAndView("shop");
        cookieModel.addAttribute("games", repo.getAllGames());
        return mav;
    }

    @GetMapping("/addToBasket")
    public String add(@RequestParam String id){
        /*Something should happen here*/
        return "redirect:/shop";
    }

    //End-points for demonstration purposes
    @GetMapping("/session-set")
    public ModelAndView setSession(HttpSession session){
        return new ModelAndView("session");
    }

    @PostMapping("/session-set")
    public ModelAndView setSession(HttpSession session, @RequestParam String message){
        session.setAttribute("message", message);
        return new ModelAndView("redirect:/session-get");
    }

    @GetMapping("/session-get")
    public ModelAndView getSession(HttpSession session){
        return new ModelAndView("session");
    }
}
