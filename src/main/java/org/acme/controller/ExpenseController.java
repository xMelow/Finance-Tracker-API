package org.acme.controller;

import java.util.List;

import org.acme.domain.Expense;
import org.acme.service.ExpenseService;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/expenses")
public class ExpenseController {

    @Inject
    ExpenseService expenseService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public List<Expense> getAllExpenses() {
        return expenseService.getAllExpenses();
    }
}
