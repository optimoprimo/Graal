package ecna.endpoints;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.jaxrs.PathParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ecna.model.Product;
import ecna.repository.ProductRepository;

@ApplicationScoped
@Path("/products")
public class ProductResource {

    private ProductRepository repository;

    private Logger log;

    @Inject
    public ProductResource(ProductRepository repository) {
        this.repository = repository;
        log = LoggerFactory.getLogger(ProductResource.class.getName());
    }

    @GET
    public Response getProducts() {
        log.info("getProducts");
        return Response.ok(repository.listAll()).build();
    }

    @POST
    @Transactional
    public Response createProduct(Product pord) {
        log.info("createProduct");
        repository.persist(pord);
        return Response.ok().build();
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Response deleteProduct(@PathParam Long id) {
        log.info("deleteProduct");
        repository.deleteById(id);
        return Response.ok().build();
    }
}
