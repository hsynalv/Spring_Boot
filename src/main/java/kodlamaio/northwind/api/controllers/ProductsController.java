package kodlamaio.northwind.api.controllers;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    private ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getall")
    public DataResult<List<Product>> getAll(){
        return productService.getAll();
    }

    @GetMapping("/gelAllByPage")
    public DataResult<List<Product>> getAll(@RequestParam int pageNo,@RequestParam int pageSize){
        return productService.getAll(pageNo,pageSize);
    }

    @GetMapping("/gelAllSorted")
    public DataResult<List<Product>> getAllSorted(){
        return productService.getAllSorted();
    }

    @PostMapping("/addProduct")
    public Result addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @GetMapping("/getByProductName")
    public DataResult<Product> getByProductName(@RequestParam String productName){
        return productService.getByProductName(productName);
    }

    @GetMapping("/getByNameAndCategory")
    public DataResult<List<Product>> getByNameAndCategory(@RequestParam String productName, @RequestParam int categoryId){
        return productService.getByNameAndCategory(productName,categoryId);
    }

    @GetMapping("/getByProductNameAndCategoryId")
    public DataResult<Product> getByProductNameAndCategoryId(@RequestParam String productName,@RequestParam int categoryId) {
        return productService.getByProductNameAndCategoryId(productName,categoryId);
    }

    @GetMapping("/getByProductNameContains")
    public DataResult<List<Product>> getByProductNameContains(@RequestParam String ProductName) {
        return productService.getByProductNameContains(ProductName);
    }

    @GetMapping("/getProductDetails")
    public DataResult<List<ProductWithCategoryDto>> getProductDetails() {
        return productService.getProductDetails();
    }


}
