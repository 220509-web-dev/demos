package dev.ranieri.collectionsapi;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class ComparePlayground {

    public static void main(String[] args) {
        Player lebron = new Player("Lebron", 26_000_000, 80); // +1 +1 = +2
        Player haslem = new Player("Haslem", 3_000_000,78); // -1 + 1 = 0
        Player curry = new Player("Curry", 22_000_000, 74);// -1 -1 = -2

        Set<Player> playerSet = new TreeSet<Player>(); // will call compareTo on all the objects and comparisions to sort them
        // the most negative elements are first, the most positive elements are last
        playerSet.add(lebron);
        playerSet.add(haslem);
        playerSet.add(curry);

        System.out.println(playerSet);
        System.out.println(haslem.compareTo(curry));

    }
}
