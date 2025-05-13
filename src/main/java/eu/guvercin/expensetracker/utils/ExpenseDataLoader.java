package eu.guvercin.expensetracker.utils;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import eu.guvercin.expensetracker.model.Expense;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

@Component
public class ExpenseDataLoader {

    private static List<Expense> expenses;

    @PostConstruct
    public void init(){
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream is = getClass().getResourceAsStream("/expenses.json");
            expenses = mapper.readValue(is, new TypeReference<List<Expense>>() {
            });
            System.out.println("Expense data: " + expenses);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @SuppressWarnings("LombokGetterMayBeUsed") //beni bir sal be ide
    public static List<Expense> getExpenses() {
        return expenses;
    }



}
