package Controller;

import Model.*;
import net.bytebuddy.asm.Advice;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static Model.ProductStatus.AVAILABLE;
import static Model.ProductStatus.NOT_AVAILABLE;
import static View.Main.RepoJpa;

public class RepositoryJpa implements RepoInterface {
    private final EntityManagerFactory factory;
    final EntityManager manager;

    public RepositoryJpa(){
        factory= Persistence.createEntityManagerFactory("default");
        manager = factory.createEntityManager();
    }


    @Override
    public Product findIdProduct(Long id) {

        try {return manager.find(Product.class, id);}
        catch (Exception e) {
            System.out.println("Nu exista id-ul respectiv");
    };
        return null;
    }


    @Override
    public void remove(Long id) {
        Product product = findIdProduct((long) Math.toIntExact(id));
        if (product != null) {
            manager.getTransaction().begin();
            product.setStatusProduct(NOT_AVAILABLE);
            manager.getTransaction().commit();
            product.setStatusProduct(NOT_AVAILABLE);
        }

    }


    public void addMakeup(Product product, Makeup makeup){
        makeup.setProduct(product);
        manager.getTransaction().begin();
        manager.persist(product);
        manager.persist(makeup);
        manager.getTransaction().commit();
        RepoJpa.checkExpiration(product);
    }

    public void addSkincare(Product product, Skincare skincare){
        skincare.setProduct(product);
        manager.getTransaction().begin();
        manager.persist(product);
        manager.persist(skincare);
        manager.getTransaction().commit();
        RepoJpa.checkExpiration(product);

    }

    public void addPerfume(Product product, Perfume perfume){
        perfume.setProduct(product);
        manager.getTransaction().begin();
        manager.persist(product);
        manager.persist(perfume);
        manager.getTransaction().commit();
        RepoJpa.checkExpiration(product);

    }

    @Override
    public void buyProduct( Order order){
        manager.getTransaction().begin();
        String ans="yes";
        while (!Objects.equals(ans, "no")) {
            System.out.println("The id of the product: ");
            Scanner in = new Scanner(System.in);
            Long idd= Long.valueOf(in.nextLine());
            try{
            Product product=findIdProduct(idd);
            System.out.println("How many pieces?");
            int cant= Integer.parseInt(in.nextLine());
            if(product.getQuantity()>=cant &&product.getStatusProduct()==AVAILABLE){
                for (int i=1;i<=cant;i++){
                    order.addTag(product);
                    product.setQuantity(product.getQuantity()-1);
                    order.setSum(order.getSum()+product.getPrice());
                    manager.persist(order);

                }
                System.out.println("Would you like another product?");
                ans=in.nextLine();
                if (Objects.equals(ans, "no")){
                    System.out.println("Thank you for buying!");
                    manager.getTransaction().commit();
                }
            }
            else{
                System.out.println("Out of stock");
            }} catch (Exception e) {
                System.out.println("");}}

    }

    public void addClient(Client client){
        manager.getTransaction().begin();
        manager.persist(client);
        manager.getTransaction().commit();

    }
        public List getProducts()
        {
            return manager.createQuery("SELECT p from Product p").getResultList();
    }

    public List<Makeup> getMakeupList(){
        List<Makeup> makeupList = manager.createQuery("SELECT m from Makeup m INNER JOIN Product p on p.id=m.id").getResultList();
        return makeupList;
    }

    public List<Perfume> getPerfumeList(){
        return (List<Perfume>) manager.createQuery("SELECT m from Perfume m INNER JOIN Product p on p.id=m.id").getResultList();
    }

    public List<Skincare> getSkincareList(){
        return (List<Skincare>) manager.createQuery("SELECT m from Skincare m INNER JOIN Product p on p.id=m.id").getResultList();
    }

    public List<Product> getSortedList() {
        RepositoryJpa RepoJpa=new RepositoryJpa();
        Scanner in = new Scanner(System.in);
        System.out.println("desc/asc by price?");
        String sort = in.nextLine();
        List<Product> productsList = RepoJpa.getProducts();
        if (Objects.equals(sort, "asc")) {
            productsList.sort(Comparator.comparing(Product::getPrice));
        }
        if (Objects.equals(sort, "desc")) {
            productsList.sort(Comparator.comparing(Product::getPrice).reversed());
        }

        return productsList;
    }

    public List<Client> getClientsList(){
        return (List<Client>) manager.createQuery("SELECT m from Client m ").getResultList();
    }

    public Client findClient(Long id) {
        return manager.find(Client.class, id);
    };

    public List<Order>findCustomerOrder(Long id){
        Client client=findClient(id);
        return client.getOrder();
    }

    public void updateProductPrice(Product product,int new_price){
        try{
        product.setPrice(new_price);}
        catch (Exception e) {
            System.out.println("Nu avem id-ul respectiv");
        }

    }
    public void updateProductQuantity(Product product, int quantity){
        try{
        product.setQuantity(quantity);}
        catch (Exception e) {
            System.out.println("Nu avem id-ul respectiv");
        }

    }

    public void returnProduct(Product product){

        try{product.setQuantity(product.getQuantity()+1);}
        catch (Exception e) {
            System.out.println("Id-ul nu exista");
        }
    }

    public List getFilteredProducts()
    {
        return manager.createQuery("SELECT p from Product p where p.status=0").getResultList();
    }


    public void checkExpiration(Product product){
        LocalDate date=LocalDate.parse(product.getExpirationDate(), DateTimeFormatter.ISO_DATE);
        if (date.isBefore(LocalDate.now())){
            product.setStatusProduct(NOT_AVAILABLE);
        }

    }

}

