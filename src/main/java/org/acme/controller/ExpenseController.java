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
import jakarta.ws.rs.core.Response;
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
    @Produces(MediaType.APPLICATION_JSON)
    public Response addExpense(ExpenseBody body) {
        expenseService.addExpense(body);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateExpense(@PathParam("id") int id, ExpenseBody body) {
        expenseService.updateExpense(id, body);
    }

    @DELETE
    @Path("/{id}")
    public void removeExpense(@PathParam("id") int id) {
        expenseService.removeExpense(id);
    }
}
