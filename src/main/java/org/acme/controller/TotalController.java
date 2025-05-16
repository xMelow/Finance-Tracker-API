package org.acme.controller;

import javax.print.attribute.standard.Media;

import org.jboss.logging.annotations.Producer;

import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.GET;


@Path("/total")
public class TotalController {

    @Inject
    TotalService totalService;

    @GET
    @Path("/overall")
    @Produces(MediaType.APPLICATION_JSON)
    public int getTotalSpending() {
        return totalService.getTotalSpending();
    }

    @GET
    @Path("/month")
    @Produces(MediaType.APPLICATION_JSON)
    public int getTotalSpendingMonth() {
        return totalService.getTotalSpendingMonth();
    }
}
