package co.com.hyunsedaProduct.domain.entity;

import jakarta.persistence.*;

/**Librerias de Lombok*/
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "Categories") //JPA->Java persistense API->iverneit motor
public class Category implements Serializable {

    private static final long serialVersionUID = 1L; //se utiliza para garantizar la compatibilidad entre diferentes
    // versiones de la clase cuando se serializa y deserializa.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="category_Id")
    private long categoryId;

    @Column(name="category_Name")
    private String categoryName;

   @ManyToMany(mappedBy = "categories")
   private List<Product> products = new ArrayList<>();

    public Category(){
        this.products = new ArrayList<>();
    }
}
