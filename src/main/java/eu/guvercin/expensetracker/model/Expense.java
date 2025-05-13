package eu.guvercin.expensetracker.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Expense {

    @JsonProperty
    private int expenseType;

    @JsonProperty("date")
    private String date; // Format: YYYY-MM-DD

    @JsonProperty("amount")
    private double amount;

    @JsonProperty("category")
    private String category;

    @JsonProperty("account")
    private String account;

    @JsonProperty("note")
    private String note; // Optional

}
