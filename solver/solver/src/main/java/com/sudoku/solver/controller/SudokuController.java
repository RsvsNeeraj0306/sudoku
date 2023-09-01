package com.sudoku.solver.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;

import ch.qos.logback.core.model.Model;

@Controller
public class SudokuController {

    @GetMapping("/")
    public String showInputForm(Model model) {
        // Prepare the model with necessary data if needed
        return "sudoku-input"; // Thymeleaf template name
    }

    @PostMapping("/solve")
    public String solveSudoku(@RequestAttribute Map<String, String> cellValues, Model model) {
        // Parse the user input, solve the Sudoku puzzle
        // Update the model with the solved puzzle or error message
        return "sudoku-solution"; // Thymeleaf template name
    }
}
