package Model;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Perfume")

public class Perfume {

    @Id
    @Column(name="product_id")
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "product_id")
    private Product product;

    private String scent;

    public Perfume( String scent) {
        this.scent=scent;
    }
    public Perfume() {

    }
    public String getScent() {
        return scent;
    }

    public void setScent(String scent) {
        this.scent = scent;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Perfume{" +
                "id=" + id +
                ", product=" + product +
                ", scent='" + scent + '\'' +
                '}';
    }
}
