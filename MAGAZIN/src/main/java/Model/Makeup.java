package Model;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="Makeup")
public class Makeup {
    @Id
    @Column(name = "product_id")
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "product_id")
    private Product product;

    private String category;

    public Makeup(String category) {

        this.category = category;
    }

    public Makeup() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Makeup{" +
                "id=" + id +
                ", product=" + product +
                ", category='" + category + '\'' +
                '}';
    }
}

