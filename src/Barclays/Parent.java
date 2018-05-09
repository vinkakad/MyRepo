package Barclays;

import java.io.*;

/**
 * Created by vinod on 21/4/18.
 */
public class Parent {
    String name;
    public Parent() {}
    public Parent(String nm){
        this.name = nm;
    }
}

class Child1 extends Parent implements Serializable{
    String name2;
    public Child1(){}
    public Child1(String nm1, String nm2){
        super(nm1);
        this.name2= nm2;
    }
}
class SerializeTest1 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Child1 child= new Child1("A","B");
        try{

            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(new File("C:\\JavaSamples\\serialize.ser")));
            os.writeObject(child);
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(new File("C:\\JavaSamples\\serialize.ser")));
            Child1 childRead = (Child1)is.readObject();
            System.out.println("Child name1 : " + childRead.name);
            System.out.println("Child name2 : " + childRead.name2);
        }catch(IOException ex){
            ex.printStackTrace();
        }catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }
}
