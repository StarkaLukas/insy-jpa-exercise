package at.htl.api;

import at.htl.model.store.StoreDTO;
import at.htl.workloads.store.Store;
import at.htl.workloads.store.StoreService;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/api/store")
public class StoreResource {

    private final StoreService storeService;

    public StoreResource(StoreService storeService) {
        this.storeService = storeService;
    }

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAllStores() {
        List<Store> stores = storeService.getAllStores();

        return Response.ok(stores).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getStore(@PathParam("id") Long id) {
        Store foundStore = storeService.getStoreById(id);
        boolean storeWasFound = foundStore != null;

        return (storeWasFound ? Response.ok(foundStore) : Response.status(Response.Status.BAD_REQUEST)).build();
    }

    @Transactional
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addStore(StoreDTO newStore) {
        boolean result = storeService.addStore(newStore);
        return (result ? Response.ok(newStore) : Response.status(Response.Status.BAD_REQUEST)).build();
    }
}
