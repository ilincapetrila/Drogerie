package Model;

import Controller.RepositoryJpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="Product")
@Inheritance(strategy=InheritanceType.JOINED)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToMany(mappedBy = "products")
    private List<Order> orders= new ArrayList<>();
    ProductStatus status;

    public Product(int quantity, String name, String expirationDate,
            int price) {
        this.quantity = quantity;
        this.name = name;
        this.expirationDate = expirationDate;
        this.price = price;
        this.status= ProductStatus.AVAILABLE;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Makeup makeup;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Skincare skincare;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Perfume perfume;



    private int quantity;
    private String name;
    private String expirationDate;
    private int price;

    public Product() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Makeup getMakeup() {
        return makeup;
    }

    public void setMakeup(Makeup makeup) {
        this.makeup = makeup;
    }


    public Skincare getSkincare() {
        return skincare;
    }

    public void setSkincare(Skincare skincare) {
        this.skincare = skincare;
    }

    public Perfume getPerfume() {
        return perfume;
    }

    public void setPerfume(Perfume perfume) {
        this.perfume = perfume;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ProductStatus getStatusProduct() {
        return status;
    }

    public void setStatusProduct(ProductStatus status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return name;
    }
    public static RepositoryJpa RepoJpa = new RepositoryJpa();

}
