package com.example.cookieshop.controllers;

import com.example.cookieshop.models.Game;
import com.example.cookieshop.repositories.GameRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class GameShopController
{
    private GameRepository repo = new GameRepository();

    @GetMapping("/")
    public ModelAndView index(HttpSession session){
        return new ModelAndView("index");
    }

    @GetMapping("/basket")
    public ModelAndView basket(HttpSession session)
    {
        ModelAndView mav = new ModelAndView("basket");
        List<Game> games = (List<Game>) session.getAttribute("basket");
        if (games == null)
        {
            games = new ArrayList<>();
        }
        mav.addObject("games", games);
        int total = 0;
        for (Game game : games)
        {
            total += game.getPrice();
        }
        mav.addObject("total",total);
        return mav;
    }

    @GetMapping("/shop")
    public ModelAndView basket(HttpSession session, Model cookieModel){
        ModelAndView mav = new ModelAndView("shop");
        cookieModel.addAttribute("games", repo.getAllGames());
        return mav;
    }

    @GetMapping("/addToBasket")
    public String add(@RequestParam String id, HttpSession session)
    {
        Game game = repo.getCookieById(Integer.parseInt(id));
        List<Game> basket = (List<Game>) session.getAttribute("basket");
        if (basket == null)
        {
            basket = new ArrayList<>();
        }
        basket.add(game);
        session.setAttribute("basket", basket);
        System.out.println(basket.size());
        return "redirect:/shop";
    }

    @GetMapping("/removeFromBasket")
    public String remove(@RequestParam int id, HttpSession session)
    {
        List<Game> games = (List<Game>) session.getAttribute("basket");
        if (!games.isEmpty())
        {
            for (int i = 0; i < games.size(); i++)
            {
                Game game = games.get(i);
                if (game.getId() == id)
                {
                    games.remove(i);
                    break;
                }
            }
        }
        return "redirect:/basket";
    }

    @GetMapping("/emptyBasket")
    public String emptyBasket(HttpSession session)
    {
        session.removeAttribute("basket");
        return "redirect:/basket";
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
