package design.practice.designEx.restaurant;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;


public class Orders {
    
    private Map<String, String> listOrders;
    

    public Orders(int ordersCount){
        listOrders = new LinkedHashMap<String, String>();
    }

    public void addOrder(String customerName, String order) {
       
        if(order.equals("Same")){
            String lastAddedOrder = getLastAddedOrder();
            listOrders.put(customerName, lastAddedOrder);
        }
        else{
            listOrders.put(customerName, order);
        }
        
    }
    
    private String getLastAddedOrder() {
        Iterator<String> iterator = listOrders.values().iterator();
        String lastAddedOrder = null;
        while(iterator.hasNext())
            lastAddedOrder = iterator.next();
        
        return lastAddedOrder;
    }

    public String print() {
        StringBuilder stringToPrint = new StringBuilder();
        for (String dish : listOrders.values()) {
            stringToPrint.append(dish+", ");
        }
        stringToPrint.deleteCharAt(stringToPrint.length() - 1);
        stringToPrint.deleteCharAt(stringToPrint.length() - 1);
        
        return stringToPrint.toString();
    }

    public boolean isNewCustomerToServe(String customerName) {
        return ! listOrders.containsKey(customerName);
    }

}
