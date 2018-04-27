package design.practice.designEx.restaurant;



public class Table {

    private Orders orders;// = new HashMap<String, Customer>();
    private StringBuilder orderPage;

    public Table(int numberOfCustomers){
        orders = new Orders(numberOfCustomers);
    }

    public void addCustomerRequest(String string) {
        String customerName = getCustomerFromString(string);
        String order =  getOrderFromString(string);
        orders.addOrder(customerName, order);
    }
    
    public boolean isNewCustomerToServe(String customerName){
        return orders.isNewCustomerToServe(customerName);
    }

    private void updateCustomerRequest(String customerName, String request) {
        
        
    }

    private boolean customerAlreadyExist(String customerName) {
        return false;

    }

    private void addNewCustomer(String customerName, String request) {

    }

    private void addOrderToOrderPage(String request) {
        if(orderPage.length() == 0){
            orderPage.append(request);
        }else{
            orderPage.append(", "+request);
        }
    }

    private String getCustomerFromString(String string){
        return string.split(":")[0].trim();
    }

    private String getOrderFromString(String string){
        return string.split(":")[1].trim();
    }
    
    public String printOrders() {
        
        return orders.print();
    }

}
