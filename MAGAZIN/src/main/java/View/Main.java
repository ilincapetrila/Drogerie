package View;

import Controller.RepositoryJpa;
import Controller.Table;
import Model.*;

import java.util.Objects;
import java.util.Scanner;


//
public class Main {
    public static RepositoryJpa RepoJpa = new RepositoryJpa();
    static Table table= new Table();
    public static void firstStart(){
        Scanner in= new Scanner(System.in);
        System.out.println("Start/Exit Application");
        String answer1=in.nextLine();
        while(!Objects.equals(answer1, "Exit")){
            startMenu();
        }}

    public static void startMenu() {
        Scanner in = new Scanner(System.in);
        System.out.println("Do you want to log as an admin or client? admin/client/back ");
        String answer = in.nextLine();
        if (Objects.equals(answer.toUpperCase(), "BACK")) {
            firstStart();
        }

        if(Objects.equals(answer.toUpperCase(), "ADMIN")){
            System.out.println("admins password");
            String pass=in.nextLine();
            if (!Objects.equals(pass, "ili") && !Objects.equals(pass, "bia")){
                startMenu();}
            while (Objects.equals(answer.toUpperCase(), "ADMIN")) {
                adminMenu();}
            }
        if (Objects.equals(answer.toUpperCase(), "CLIENT")) {
                clientMenu();
        }
    }
    public static void adminMenu() {
        Scanner in = new Scanner(System.in);

        System.out.println("Would you like to:");
        System.out.println("1: Add Product");
        System.out.println("2:Delete Product");
        System.out.println("3:Update Product");
        System.out.println("4:See all Products");
        System.out.println("5:See Makeup-Products");
        System.out.println("6:See Skincare-Products");
        System.out.println("7:See Perfume-Products");
        System.out.println("8:Sort Products");
        System.out.println("9:Filter Products");
        System.out.println("10:See All Clients ");
        System.out.println("11:back");
        String adminAnswer = in.nextLine();
        if (Objects.equals(adminAnswer, "1")) {
            System.out.println("The name of the product:");
            String name = in.nextLine();
            System.out.println("The quantity of the product:");
            int quantity = Integer.parseInt(in.nextLine());
            System.out.println("The  price of the product:");
            int price = Integer.parseInt(in.nextLine());
            System.out.println("The expiration-date of the product:");
            String expirationDate = in.nextLine();
            System.out.println("Is the Product : makeup/skincare/perfume?");
            String type = in.nextLine();
            if (Objects.equals(type.toUpperCase(), "MAKEUP")) {
                System.out.println("The area of the face for the product:");
                String area = in.nextLine();
                Product product = new Product(quantity, name, expirationDate, price);
                Makeup makeup = new Makeup(area);
                RepoJpa.addMakeup(product, makeup);
            }

            if (Objects.equals(type.toUpperCase(), "SKINCARE")) {
                System.out.println("The skin type for the product:");
                String area = in.nextLine();
                Product product = new Product(quantity, name, expirationDate, price);
                Skincare skincare = new Skincare(area);
                RepoJpa.addSkincare(product, skincare);
            }
            if (Objects.equals(type.toUpperCase(), "PERFUME")) {
                System.out.println("The scent for the perfume:");
                String scent = in.nextLine();
                Product product = new Product(quantity, name, expirationDate, price);
                Perfume perfume = new Perfume(scent);
                RepoJpa.addPerfume(product, perfume);
            }
        }
        if (Objects.equals(adminAnswer, "2")) {
            System.out.println("Would you like to delete : makeup/skincare/perfume");
            String deleting = in.nextLine();
            if (Objects.equals(deleting.toUpperCase(), "MAKEUP")) {
                System.out.println("Please write the id of the makeup-product");
                Long id = Long.valueOf(in.nextLine());
                RepoJpa.remove((long) Math.toIntExact(id));

            }
        }
        if (Objects.equals(adminAnswer, "3")) {
            System.out.println("The id of the product you want to update:");
            long id= Long.parseLong(in.nextLine());
            Product product= RepoJpa.findIdProduct(id);
            System.out.println("Would you like to update : price/quantity");
            String updating=in.nextLine();
            if(Objects.equals(updating.toUpperCase(), "PRICE")){
                System.out.println("The new price: ");
                int price= Integer.parseInt(in.nextLine());
                RepoJpa.updateProductPrice(product, price);
            }
            if(Objects.equals(updating.toUpperCase(), "QUANTITY")){
                System.out.println("The new quantity: ");
                int quantity= Integer.parseInt(in.nextLine());
                RepoJpa.updateProductQuantity(product, quantity);
            }
        }

        if (Objects.equals(adminAnswer, "4")) {
            table.tableShowProducts();
        }
        if (Objects.equals(adminAnswer, "5")){
            table.tableMakeupProducts();
        }
        if (Objects.equals(adminAnswer, "6")){
            table.tableSkincareProducts();
        }
        if (Objects.equals(adminAnswer, "7")){
            table.tablePerfumeProducts();
        }

        if (Objects.equals(adminAnswer, "8")){
            table.tableShowProductsSortPrice();
        }

        if(Objects.equals(adminAnswer, "9")) {
            System.out.println("In Stock Products");
            table.tableShowProductsInStock();
        }

        if(Objects.equals(adminAnswer,"10")){
            table.tableShowClients();
        }
        if(Objects.equals(adminAnswer,"11")){
            firstStart();
        }

    }
    public static Client clientAuth() {
        Scanner in = new Scanner(System.in);
        System.out.println("Do you already have an account?");
        String answer = in.nextLine();
        if (!Objects.equals(answer, "yes")) {
            System.out.println("First Name: ");
            String clientFirstName = in.nextLine();
            System.out.println("Last Name:  ");
            String clientLastName = in.nextLine();
            System.out.println("Date of Birth: ");
            String clientDateOfBirth = in.nextLine();
            Client client = new Client(clientFirstName, clientLastName, clientDateOfBirth);
            RepoJpa.addClient(client);
            return client;
        }
        if (Objects.equals(answer, "yes")) {
            try {
                Client oldClient;
                System.out.println("The id of the username:");
                long id = Long.parseLong(in.nextLine());
                System.out.println("Last name:");
                String last = in.nextLine();
                System.out.println("First name:");
                String first = in.nextLine();
                oldClient = RepoJpa.findClient(id);
                if (!Objects.equals(oldClient.getLastName().toUpperCase(), last.toUpperCase()) || !Objects.equals(oldClient.getFirstName().toUpperCase(), first.toUpperCase())) {
                    System.out.println("The account does not exist! Please make one");
                    clientAuth();
                }
                return oldClient;
            } catch (Exception e) {
                System.out.println("Id-ul nu exista");
                clientAuth();
            }
        }
        return null;

    }
    public static void clientMenu() {
        Client client = clientAuth();
        optiuni();
        Scanner in = new Scanner(System.in);
        String clientAnswer = in.nextLine();
        while (!Objects.equals(clientAnswer, "10")) {

            if(Objects.equals(clientAnswer,"0")){
                System.out.println("Id:  "+ client.getId() + "  FirstName:  " +client.getFirstName() + "  Last Name:  " + client.getLastName() + "  DoB:  "+client.getDateOfBirth());
            }

            if (Objects.equals(clientAnswer, "1")) {
                Order order = new Order();
                order.setClient(client);
                RepoJpa.buyProduct(order);
            }
            if (Objects.equals(clientAnswer, "2")){
                //return product
                System.out.println("The id of the product you want to return: ");
                long id= Long.parseLong(in.nextLine());
                Product product= RepoJpa.findIdProduct(id);
                RepoJpa.returnProduct(product);
            }

            if (Objects.equals(clientAnswer, "3")) {
                table.tableShowProducts();
            }
            if(Objects.equals(clientAnswer, "4")){
                table.tableMakeupProducts();
            }
            if(Objects.equals(clientAnswer, "5")){
                table.tableSkincareProducts();
            }
            if(Objects.equals(clientAnswer, "6")){
                table.tablePerfumeProducts();
            }

            if(Objects.equals(clientAnswer, "7")) {
                table.tableShowProductsSortPrice();
            }

            if(Objects.equals(clientAnswer, "8")) {
                System.out.println("In Stock Products");
                table.tableShowProductsInStock();
            }


             if(Objects.equals(clientAnswer, "9")) {
                 long id=client.getId();
                 table.tableOrderClient(id);
            }

        clientAnswer=optiuni();
        }

        startMenu();

    }

    private static String optiuni() {
        System.out.println("Would you like to:");
        System.out.println("0:See Profile");
        System.out.println("1: Buy Product");
        System.out.println("2: Return Product");
        System.out.println("3 : All Products");
        System.out.println("4: ALl Makeup List");
        System.out.println("5: All Skincare List");
        System.out.println("6: All Perfume List");
        System.out.println("7: Sort Products");
        System.out.println("8: Filter Products");
        System.out.println("9: See your Orders");
        System.out.println("10:back to start menu");
        Scanner in= new Scanner(System.in);
        return in.nextLine();
    }

            public static void main (String[]args){
                firstStart();
            }
        }