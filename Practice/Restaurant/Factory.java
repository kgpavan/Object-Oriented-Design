package design.practice.designEx.restaurant;


public class Factory {

    public static Table createTable(int numberOfCustomers){
        return new Table(numberOfCustomers);
    }
    
    public static String getCustomer(String order){
        return order.split(":")[0];
    }
    
    public static String getOrder(String order){
        return order.split(":")[1].trim();
    }
}
