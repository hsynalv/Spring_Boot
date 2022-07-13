package kodlamaio.northwind.business.concretes;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.core.utilities.results.SuccessResult;
import kodlamaio.northwind.dataAccess.abstracts.ProductDao;
import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager implements ProductService {

    private ProductDao productDao;
    private int pageSize;

    @Autowired
    public ProductManager(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public DataResult<List<Product>> getAll() {
        return new SuccessDataResult<List<Product>>("Data listelendi",productDao.findAll());
    }

    @Override
    public DataResult<List<Product>> getAll(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber-1,pageSize);
        return new SuccessDataResult<List<Product>>(productDao.findAll(pageable).getContent());
    }

    @Override
    public DataResult<List<Product>> getAllSorted() {
        Sort sort = Sort.by(Sort.Direction.DESC,"productName");
        return new SuccessDataResult<List<Product>>(productDao.findAll(sort));
    }

    @Override
    public Result addProduct(Product product) {
        productDao.save(product);
        return new SuccessResult("Product başarıyla eklendi");
    }

    @Override
    public DataResult<Product> getByProductName(String productName) {
        return new SuccessDataResult<Product>("Data listelendi",productDao.getByProductName(productName));
    }

    @Override
    public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
        return new SuccessDataResult<Product>("Data listelendi",productDao.getByProductNameAndCategory_CategoryId(productName,categoryId));
    }

    @Override
    public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>("Data listelendi",productDao.getByProductNameOrCategory_CategoryId(productName,categoryId));
    }

    @Override
    public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories) {
        return new SuccessDataResult<List<Product>>("Data listelendi",productDao.getByCategory_CategoryIdIn(categories));
    }

    @Override
    public DataResult<List<Product>> getByProductNameContains(String ProductName) {
        return new SuccessDataResult<List<Product>>("Data listelendi",productDao.getByProductNameContains(ProductName));
    }

    @Override
    public DataResult<List<Product>> getByProductNameStartsWith(String ProductName) {
        return new SuccessDataResult<List<Product>>("Data listelendi",productDao.getByProductNameStartsWith(ProductName));
    }

    @Override
    public DataResult<List<Product>> getByProductNameEndingWith(String ProductName) {
        return new SuccessDataResult<List<Product>>("Data listelendi",productDao.getByProductNameEndingWith(ProductName));
    }

    @Override
    public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>("Data listelendi",productDao.getByNameAndCategory(productName,categoryId));
    }

    @Override
    public DataResult<List<ProductWithCategoryDto>> getProductDetails() {
        return new SuccessDataResult<List<ProductWithCategoryDto>>(productDao.getProductDetails());
    }
}
