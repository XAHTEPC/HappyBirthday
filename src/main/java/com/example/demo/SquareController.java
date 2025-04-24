package com.example.demo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class SquareController {
    private static final Map<Integer, String> squares = new HashMap<>();

    static {
        // Инициализация 30 красных квадратов
        for (int i = 1; i <= 30; i++) {
            squares.put(i, "red");
        }
    }

    @GetMapping("/")
    public String showSquares(Model model) {
        model.addAttribute("squares", squares);
        return "index";
    }

    @PostMapping("/changeColor")
    public String changeColor(@RequestParam int squareNumber) {
        if (squares.containsKey(squareNumber)) {
            squares.put(squareNumber, "green");
        }
        return "redirect:/";
    }

    public static void changeColorFromConsole(int squareNumber) {
        if (squares.containsKey(squareNumber)) {
            squares.put(squareNumber, "green");
            System.out.println("Квадрат " + squareNumber + " изменен на зеленый");
        } else {
            System.out.println("Квадрат с номером " + squareNumber + " не найден");
        }
    }
}