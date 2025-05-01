package org.acme.controller;

import org.acme.domain.entity.Category;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import org.acme.service.CategoryService;
import java.util.List;
import jakarta.ws.rs.PathParam;

@Path("/category")
public class CategoryController {
    
    @Inject
    CategoryService categoryService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GET
    @Path("/{id:\\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public Category getCategoryById(@PathParam("id") int id) {
        return categoryService.getCategoryById(id);
    }

    @GET
    @Path("/{name:[a-zA-Z]+}")
    @Produces(MediaType.APPLICATION_JSON)
    public Category getCategoryByName(@PathParam("name") String name) {
        return categoryService.getCategoryByName(name);
    }
}
