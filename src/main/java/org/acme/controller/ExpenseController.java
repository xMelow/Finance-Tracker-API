package org.acme.controller;

import java.util.List;

import org.acme.domain.Expense;
import org.acme.service.ExpenseService;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

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
    @Consumes(MediaType.APPLICATION_JSON)
    public String addExpense(MyBody body) {
        return expenseService.addExpense(body);
    }

    @DELETE
    @Path("/{id}")
    public String removeExpense(@PathParam("id") int id) {
        return expenseService.removeExpense(id);
    }
}
