package kodlamaio.northwind.entities.abstracts;

import kodlamaio.northwind.entities.conretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product,Integer> {


}
