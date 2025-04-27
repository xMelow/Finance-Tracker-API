package org.acme.controller;

import java.util.List;

import org.acme.domain.Expense;
import org.acme.service.ExpenseService;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/expenses")
public class ExpenseController {

    @Inject
    ExpenseService expenseService;

    // add parameter filters
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public List<Expense> getAllExpenses() {
        return expenseService.getAllExpenses();
    }

    @GET
    @Path("/{id}")
    public Expense getExpenseById(@PathParam("id") int id) {
        return expenseService.getExpenseById(id);
    }

    @POST
    public String addExpense() {
        return expenseService.addExpense();
    }

    @DELETE
    @Path("/{id}")
    public String removeExpense(@PathParam("id") int id) {
        return expenseService.removeExpense(id);
    }
}
