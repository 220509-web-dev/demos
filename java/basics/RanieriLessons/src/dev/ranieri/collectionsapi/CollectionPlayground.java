package dev.ranieri.collectionsapi;

import java.util.*;

public class CollectionPlayground {

    public static void main(String[] args) {

        Player lebron = new Player("Lebron", 26_000_000, 80);
        Player haslem = new Player("Haslem", 3_000_000,78);
        Player curry = new Player("Curry", 22_000_000, 74);
        Player butler = new Player("Butler", 3_000_000, 78);

        // List
        List<Player> playerList = new ArrayList<Player>(); // Coding to the interface
        playerList.add(haslem);
        playerList.add(lebron);
        playerList.add(curry);
        playerList.add(haslem); // can add duplicates no problem
//
//        System.out.println(playerList); // ordered by insertion
//        System.out.println(playerList.get(2)); // get by index

        //Set
        Set<Player> playerSet = new HashSet<Player>();
        playerSet.add(haslem);
        playerSet.add(lebron);
        playerSet.add(curry);

        //System.out.println(playerSet); // sets do not allow duplicates
        // no way to get an individual element

        //Map

        Map<String,Player> playerMap = new HashMap<String,Player>();
        playerMap.put("The King", lebron);
        playerMap.put("Jimmy", butler);
        playerMap.put("U", haslem);
        // put objects in matched with a key

        // get objects out using that key

        Player j = playerMap.get("Jimmy");
        //System.out.println(j);

        // there is a method that returns another collection to allow you to iterate over players
        // If you find yourself wanting this behavior you probaly did not want to use a map
        // Maps are useful for looking up. Dictionary/phonebook
        for(Player player : playerMap.values()){}

        Queue<Player> playerQueue = new LinkedList<Player>();
        playerQueue.add(lebron);
        playerQueue.add(butler);
        playerQueue.add(haslem);
        // no ability to grab elements in anything other than the defined order
        playerQueue.poll();// returns the next person in the queue (Lebron)
        playerQueue.poll(); // Butler
        //System.out.println(playerQueue.poll()); // Haslem

        Stack<Player> playerStack = new Stack<>();
        playerStack.add(lebron);
        playerStack.add(butler);
        playerStack.add(haslem);

        System.out.println(playerStack.pop());// get the last person added //
        playerStack.pop(); // butler
        playerStack.pop(); // lebron

        // Stack is deprecated. Deque is an optimized version of a stack and queue that does LIFO and FIFO
        // can get things at the begining and end as needed
        Deque<Player> playerDeque = new ArrayDeque<Player>();
        playerDeque.add(lebron);
        playerDeque.add(butler);
        playerDeque.add(haslem);
        
    }
}
