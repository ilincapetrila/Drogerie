package Model;//import java.util.Date;
import Model.Product;

import javax.persistence.*;

@Entity
@Table(name="Skincare")

public class Skincare {
    @Id
    @Column(name="product_id")
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "product_id")
    private Product product;
    private String skinType;

    public Skincare(String skinType) {
        this.skinType=skinType;
    }
    public Skincare(){};

    public String getSkinType() {
        return skinType;
    }

    public void setSkinType(String skinType) {
        this.skinType = skinType;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Skincare{" +
                "id=" + id +
                ", product=" + product +
                ", skinType='" + skinType + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

