package com.example.demomvc.controller;

import com.example.demomvc.model.Game;
import com.example.demomvc.model.GoodBye;
import com.example.demomvc.model.Hello;
import com.example.demomvc.model.MenuItem;
import com.example.demomvc.utils.Contant;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class HelloController {
//    cac url
    private List<Game> lstGame = new ArrayList<>();
    private List<MenuItem> menuItems = new ArrayList<>();
    @PostConstruct
    public void mockData() {
        lstGame.add(new Game("https://i.pinimg.com/236x/f8/15/bd/f815bdbe19afa7128cadc1e0ba41cf4e.jpg",10,1000000,2000,"Test 1"));
        lstGame.add(new Game("https://i.pinimg.com/236x/f8/15/bd/f815bdbe19afa7128cadc1e0ba41cf4e.jpg",10,1000000,1000,"Test 2"));
        lstGame.add(new Game("https://i.pinimg.com/236x/f8/15/bd/f815bdbe19afa7128cadc1e0ba41cf4e.jpg",10,1000000,2000000,"Test 3"));
        lstGame.add(new Game("https://i.pinimg.com/236x/f8/15/bd/f815bdbe19afa7128cadc1e0ba41cf4e.jpg",10,1000000,20,"Test 4"));
        lstGame.add(new Game("https://i.pinimg.com/236x/f8/15/bd/f815bdbe19afa7128cadc1e0ba41cf4e.jpg",10,1000000,2000000,"Test 5"));
        lstGame.add(new Game("https://i.pinimg.com/236x/f8/15/bd/f815bdbe19afa7128cadc1e0ba41cf4e.jpg",10,1000000,2000000,"Test 6"));
        lstGame.add(new Game("https://i.pinimg.com/236x/f8/15/bd/f815bdbe19afa7128cadc1e0ba41cf4e.jpg",10,1000000,200000,"Test 7"));
        lstGame.add(new Game("https://i.pinimg.com/236x/f8/15/bd/f815bdbe19afa7128cadc1e0ba41cf4e.jpg",10,1000000,2000000,"Test 8"));
        lstGame.add(new Game("https://i.pinimg.com/236x/f8/15/bd/f815bdbe19afa7128cadc1e0ba41cf4e.jpg",10,1000000,2000000,"Test 9"));
        lstGame.add(new Game("https://i.pinimg.com/236x/f8/15/bd/f815bdbe19afa7128cadc1e0ba41cf4e.jpg",10,1000000,2000000,"Test 10"));
        lstGame.add(new Game("https://i.pinimg.com/236x/f8/15/bd/f815bdbe19afa7128cadc1e0ba41cf4e.jpg",10,1000000,20000,"Test 11"));
        lstGame.add(new Game("https://i.pinimg.com/236x/f8/15/bd/f815bdbe19afa7128cadc1e0ba41cf4e.jpg",10,1000000,3000000,"Test 12"));
        lstGame.add(new Game("https://i.pinimg.com/236x/f8/15/bd/f815bdbe19afa7128cadc1e0ba41cf4e.jpg",10,1000000,2000000,"Test 13"));
        lstGame.add(new Game("https://i.pinimg.com/236x/f8/15/bd/f815bdbe19afa7128cadc1e0ba41cf4e.jpg",10,1000000,2000000,"Test 14"));
        lstGame.add(new Game("https://i.pinimg.com/236x/f8/15/bd/f815bdbe19afa7128cadc1e0ba41cf4e.jpg",10,1000000,2000000,"Test 15"));
        lstGame.add(new Game("https://i.pinimg.com/236x/f8/15/bd/f815bdbe19afa7128cadc1e0ba41cf4e.jpg",10,1000000,5000000,"Test 16"));
        lstGame.add(new Game("https://i.pinimg.com/236x/f8/15/bd/f815bdbe19afa7128cadc1e0ba41cf4e.jpg",10,1000000,200000,"Test 17"));
        lstGame.add(new Game("https://i.pinimg.com/236x/f8/15/bd/f815bdbe19afa7128cadc1e0ba41cf4e.jpg",10,1000000,2000000,"Test 18"));
        lstGame.add(new Game("https://i.pinimg.com/236x/f8/15/bd/f815bdbe19afa7128cadc1e0ba41cf4e.jpg",10,1000000,2000000,"Test 19"));
        lstGame.add(new Game("https://i.pinimg.com/236x/f8/15/bd/f815bdbe19afa7128cadc1e0ba41cf4e.jpg",10,1000000,20000,"Test 20"));
        lstGame.add(new Game("https://i.pinimg.com/236x/f8/15/bd/f815bdbe19afa7128cadc1e0ba41cf4e.jpg",10,1000000,2000000,"Test 20"));
        menuItems.add(new MenuItem("Home", "https://cdn4.iconfinder.com/data/icons/basic-interface-overcolor/512/menu-512.png"));
        menuItems.add(new MenuItem("Home", "https://cdn4.iconfinder.com/data/icons/basic-interface-overcolor/512/menu-512.png"));
        menuItems.add(new MenuItem("Home", "https://cdn4.iconfinder.com/data/icons/basic-interface-overcolor/512/menu-512.png"));
        menuItems.add(new MenuItem("Home", "https://cdn4.iconfinder.com/data/icons/basic-interface-overcolor/512/menu-512.png"));
        menuItems.add(new MenuItem("Home", "https://cdn4.iconfinder.com/data/icons/basic-interface-overcolor/512/menu-512.png"));
        menuItems.add(new MenuItem("Home", "https://cdn4.iconfinder.com/data/icons/basic-interface-overcolor/512/menu-512.png"));
    }

    @RequestMapping("/hello")
    public String hello(Model model, @RequestParam("name") String name,
                        @RequestParam("number1") int number1, @RequestParam("number2") int number2){
        int sum = number1 + number2;
        Hello hello = new Hello();
        model.addAttribute("sum", sum);
        model.addAttribute("user", name);
        model.addAttribute("hello", hello.getHello());
        return "Hello";
    }

    @RequestMapping("/bye")
    public String bye(Model model) {
        GoodBye goodBye = new GoodBye();
        model.addAttribute("bye", goodBye.getGoodBye());
        model.addAttribute("test", "Test Data");
        return "goodBye";
    }

    @RequestMapping("/blog")
    public String blog(Model model) {
        return "blog";
    }

    @RequestMapping("/sum")
//    tra gia tri trực tiếp luôn ko cần qua trang html
    @ResponseBody
    public int sumNumber(@RequestParam("number1") int number1, @RequestParam("number2") int number2){
        return (number1 + number2);
    }

    @RequestMapping("/home")
    public String home(Model model, @RequestParam(value = "Page", defaultValue = "0") int page,
                       @RequestParam(value = "filter", defaultValue = "0") int filter){
        List<Game> gameOfPage = new ArrayList<>();
        int index = page * Contant.PAGE_SIZE;
        int lengthGame = page * Contant.PAGE_SIZE + Contant.PAGE_SIZE > lstGame.size() ? lstGame.size() :
                page * Contant.PAGE_SIZE + Contant.PAGE_SIZE;

        for(int i = index; i< lengthGame; i++) {
            Game game = lstGame.get(i);
            if (filter == 1) {
                if (game.getPriceNew() < 5000000) {
                    gameOfPage.add(game);
                }
            } else {
                gameOfPage.add(game);
            }
        }

        int totalPage = lstGame.size() % Contant.PAGE_SIZE != 0
                ? (lstGame.size()/Contant.PAGE_SIZE )
                : (lstGame.size()/Contant.PAGE_SIZE -1);
        model.addAttribute("listMenu", menuItems );
        model.addAttribute("listGame", gameOfPage);
//        sau sẽ ko dùng size nưa sẽ dùng hàm đếm số phần tử trong database
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("currentPage", page);
        return "Home";
    }
    @RequestMapping("/detail")
    public String detal(Model model){
        return "detail";
    }
}
