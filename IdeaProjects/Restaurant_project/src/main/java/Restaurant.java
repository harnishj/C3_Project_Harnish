import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Restaurant {
    private String name;
    private String location;
    public LocalTime openingTime;
    public LocalTime closingTime;
    private List<Item> menu = new ArrayList<Item>();

    public Restaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        this.name = name;
        this.location = location;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

    public boolean isRestaurantOpen() {
        //return true;
        //DELETE ABOVE STATEMENT AND WRITE CODE HERE

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        //Parsing/formatting the current, opening and closing time.
        LocalTime curTime = LocalTime.parse(getCurrentTime().format(formatter));

        openingTime = LocalTime.parse(openingTime.format(formatter));
        closingTime = LocalTime.parse(closingTime.format(formatter));

        //Checking if the current time is between the opening and closing time.
        if (openingTime.isBefore(curTime) && closingTime.isAfter(curTime))
            return true;
        else
            return false;
    }

    public LocalTime getCurrentTime() {
        return LocalTime.now();
    }

    public List<Item> getMenu() {
        //return null;
        //DELETE ABOVE RETURN STATEMENT AND WRITE CODE HERE
        return Collections.unmodifiableList(menu);
    }

    private Item findItemByName(String itemName) {
        for (Item item : menu) {
            if (item.getName().equals(itemName))
                return item;
        }
        return null;
    }

    public void addToMenu(String name, int price) {
        Item newItem = new Item(name, price);
        menu.add(newItem);
    }

    public void removeFromMenu(String itemName) throws itemNotFoundException {

        Item itemToBeRemoved = findItemByName(itemName);
        if (itemToBeRemoved == null)
            throw new itemNotFoundException(itemName);

        menu.remove(itemToBeRemoved);
    }

    public void displayDetails() {
        System.out.println("Restaurant:" + name + "\n"
                + "Location:" + location + "\n"
                + "Opening time:" + openingTime + "\n"
                + "Closing time:" + closingTime + "\n"
                + "Menu:" + "\n" + getMenu());

    }

    public String getName() {
        return name;
    }

    public int selectedItemsOrderTotal(List<Item> itemList) {
        int orderTotal = 0;

        ListIterator<Item> it = itemList.listIterator();

        while (it.hasNext()) {
            orderTotal = orderTotal + it.next().getPrice();
        }
        return orderTotal;
    }
}
