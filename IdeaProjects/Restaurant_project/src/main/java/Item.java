import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class Item {
    private String name;
    private int price;

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }
    @Override
    public String toString(){
        return  name + ":"
                + price
                + "\n"
                ;
    }

    public int getPrice() { return price; }

}
