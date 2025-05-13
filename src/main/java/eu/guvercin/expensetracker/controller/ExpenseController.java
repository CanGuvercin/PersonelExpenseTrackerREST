package eu.guvercin.expensetracker.controller;

import eu.guvercin.expensetracker.model.Expense;
import eu.guvercin.expensetracker.utils.ExpenseDataLoader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ExpenseController {

    @GetMapping("/expenses/day/{date}")
    public List<Expense> getExpensesByDay(@PathVariable String date) {
        return ExpenseDataLoader.getExpenses().stream()
                .filter(expense -> expense.getDate().equals(date))
                .collect(Collectors.toList());
            }

    @GetMapping("/expenses/category/{category}/month")
    public List<Expense> getExpenseByCategoryAndMonth(@PathVariable String category, @RequestParam String month){
        return ExpenseDataLoader.getExpenses().stream()
                .filter(expense -> expense.getCategory()
                        .equalsIgnoreCase(category) && expense.getDate().startsWith(month))
                .collect(Collectors.toList());
    }

    @GetMapping("/expenses/categories")
    public List<String> getAllExpenseCategories() {
        return ExpenseDataLoader.getExpenses().stream()
                .map(Expense::getCategory)
                .distinct()
                .collect(Collectors.toList());
    }



}

