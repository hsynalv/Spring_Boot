package kodlamaio.northwind.dataAccess.abstracts;

import kodlamaio.northwind.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDao extends JpaRepository<Product,Integer> {

    Product getByProductName(String productName);
    Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);
    List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);
    List<Product> getByCategory_CategoryIdIn(List<Integer> categories);
    List<Product> getByProductNameContains(String ProductName);
    List<Product> getByProductNameStartsWith(String ProductName);
    List<Product> getByProductNameEndingWith(String ProductName);

    @Query("From Product where productName=:productName and category_id=:categoryId")
    List<Product> getByNameAndCategory(String productName, int categoryId);



}
