package kodlamaio.northwind.business.abstracts;

import kodlamaio.northwind.entities.conretes.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAll();

}
