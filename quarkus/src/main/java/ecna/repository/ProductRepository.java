package ecna.repository;

import javax.enterprise.context.ApplicationScoped;

import ecna.model.Product;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class ProductRepository implements PanacheRepository<Product> {
}
