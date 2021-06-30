package hello.core.singletone;

public class StatefulService {
//    private int price;

    public int order(String name, int price) {
        System.out.print("name = " + name+"  ");
        System.out.println("price = " + price);
//        this.price = price;
        return price;
    }

//    public int getPrice() {
//        return price;
//    }
}


