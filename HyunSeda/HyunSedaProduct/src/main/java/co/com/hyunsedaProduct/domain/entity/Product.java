package co.com.hyunsedaProduct.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "products") //JPA->Java persistense API->iverneit motor
public class Product implements Serializable //Para serializar lo objetos y mandarlos en Json
{
    private static final long serialVersionUID = 1L; //se utiliza para garantizar la compatibilidad entre diferentes
    // versiones de la clase cuando se serializa y deserializa.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Identity es que sea unico y se debe ingresar manualmente
    private long productId;

    @Column (name="product_name")
    private String productName;

    @Column (name="product_Descripcion")
    private String productDescripcion;

    @Column (name="product_price")
    private double productPrice;

    @Column (name="product_stock")
    private long productStock;

    @Column (name="keywords")
    private String keywords;
    @Column (name="product_caracteristc")
    private String productCaracteristc;


    @ManyToMany()
    @JoinTable(name = "productCategory",
            joinColumns = {@JoinColumn(name = "product_id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id")})
    private List<Category> categories;


}