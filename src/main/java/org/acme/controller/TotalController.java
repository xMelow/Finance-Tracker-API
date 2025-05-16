package org.acme.controller;

import java.util.List;
import java.util.Map;
import org.acme.service.TotalService;
import org.acme.DTO.MonthlySpending;
import jakarta.inject.Inject;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;

@Path("/total")
public class TotalController {

    @Inject
    TotalService totalService;

    @GET
    @Path("/overall")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Double> getTotalSpending() {
        double total = totalService.getTotalSpending();
        return Map.of("totalSpending", total);
    }

    @GET
    @Path("/month")
    @Produces(MediaType.APPLICATION_JSON)
    public List<MonthlySpending> getTotalSpendingPerMonth() {
        return totalService.getTotalSpendingPerMonth();
    }
}
