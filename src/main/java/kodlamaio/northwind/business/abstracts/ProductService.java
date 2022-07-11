package kodlamaio.northwind.business.abstracts;

import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.conretes.Product;

import java.util.List;

public interface ProductService {

    DataResult<List<Product>> getAll();
    Result addProduct(Product product);

}
