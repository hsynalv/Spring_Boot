package kodlamaio.northwind.entities.conretes;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="products")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Product{

    @Id
    @GeneratedValue
    @Column(name="product_id")
    private int id;

    @Column(name="category_id")
    private int categoryId;

    @Column(name="product_name")
    private String productName;

    @Column(name="unit_price")
    private double unitPrice;

    @Column(name="units_in_stock")
    private short unitsInStock;

    @Column(name="quantity_per_unit")
    private String quantityPerUnit;



}

