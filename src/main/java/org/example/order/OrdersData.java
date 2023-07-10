package org.example.order;



public class OrdersData {
    public Order baseOrderChangeableColor(String[] colors) {
        return new Order("FirstNameExample", "LastNameExample", "AddressExample",
                4, "+79520264510", 5,"2020-06-06", "Some_comment", colors);
    }
}
