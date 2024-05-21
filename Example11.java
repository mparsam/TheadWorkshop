import java.io.ObjectStreamException;
import java.util.Queue;
import java.util.LinkedList;

class Kitchen {
    private Queue<String> orderQueue = new LinkedList<>();

    public synchronized void placeOrder(String dish) {
        orderQueue.add(dish);
        System.out.println("Order placed for " + dish);
        notify(); // Notify the chef that an order is placed
    }

    public synchronized void prepareDish(int chefId) {
        while (orderQueue.isEmpty()) {
            try {
                System.out.println("No orders yet. Waiting for orders...");
                wait(1000); // Wait until an order is placed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        String dish = orderQueue.poll();
        System.out.println("Chef #"+ chefId+ " is preparing " + dish);
        // Simulate dish preparation
        try {
            Thread.sleep(3000); // Simulating time taken to prepare dish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(dish + " is ready!");
    }
}

class Chef extends Thread {
    private Kitchen kitchen;
    private int chefId;
    public Chef(Kitchen kitchen, int chefId) {
        this.kitchen = kitchen;
        this.chefId = chefId;
    }

    public void run() {
        while (true) {
            kitchen.prepareDish(chefId);
        }
    }
}

public class Example11 {
    public static void main(String[] args) {
        Kitchen kitchen = new Kitchen();

        // Creating multiple chefs
        Chef chef1 = new Chef(kitchen,1);
        Chef chef2 = new Chef(kitchen,2);

        // Start the chefs
        chef1.start();
        chef2.start();

        Object a = new Object();
        a.wait();
        // Place some orders

        kitchen.placeOrder("Pizza");
        kitchen.placeOrder("Kebab");
        kitchen.placeOrder("Hamburger");
    }


}
