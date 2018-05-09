package Barclays;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vinod on 21/4/18.
 */
public class Customer {

    int id;

    String name;

    public Customer(int id, String name) {

        this.id = id;

        this.name = name;

    }

    public Customer(Customer c) {

        this.id = c.id;
        this.name = c.name;

    }}

class MapTest {

    public static void main(String args[]) {

        String desg1 = "A";

        String desg2 = "B";

        Customer c1 = new Customer(1,"tom");

        Customer c2 = new Customer(2,"harry");

        Customer c3 = new Customer(1,"tom");

        Customer c4 = new Customer(c2);

        Map<Customer,String> custMap = new HashMap<>();

        custMap.put(c1,"Manager");

        custMap.put(c2,"Developer");

        desg1 = custMap.get(c3);

        desg2 = custMap.get(c4);

        System.out.println(desg1+","+desg2);

    }}
