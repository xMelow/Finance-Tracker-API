package org.acme.controller;

import java.util.List;

import org.acme.DTO.ExpenseBody;
import org.acme.domain.entity.Expense;
import org.acme.service.ExpenseService;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;

@Path("/expenses")
public class ExpenseController {

    @Inject
    ExpenseService expenseService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Expense> getAllExpenses(
        @QueryParam("category") Integer categoryId,
        @QueryParam("minAmount") Double minAmount,
        @QueryParam("maxAmount") Double maxAmount,
        @QueryParam("description") String description
    ) {
        return expenseService.getFilteredExpenses(categoryId, minAmount, maxAmount, description);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Expense getExpenseById(@PathParam("id") int id) {
        return expenseService.getExpenseById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Expense addExpense(ExpenseBody body) {
        return expenseService.addExpense(body);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Expense updateExpense(@PathParam("id") int id, ExpenseBody body) {
        return expenseService.updateExpense(id, body);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Expense removeExpense(@PathParam("id") int id) {
        return expenseService.removeExpense(id);
    }
}
