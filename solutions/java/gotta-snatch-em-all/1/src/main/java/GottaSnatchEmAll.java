import java.util.HashSet;
import java.util.List;
import java.util.Set;

class GottaSnatchEmAll {

    static Set<String> newCollection(List<String> cards) {
        Set<String> collection = new HashSet<>();
        for (String card : cards) {
            addCard(card, collection);
        }
        return collection;
    }

    static boolean addCard(String card, Set<String> collection) {
        return collection.add(card);
    }

    static boolean canTrade(Set<String> myCollection, Set<String> theirCollection) {
        // Найти разницу между вашими коллекциями
        Set<String> myUniqueCards = new HashSet<>(myCollection);
        myUniqueCards.removeAll(theirCollection); // Карты, которые есть у вас, но нет у друга

        // Найти разницу между коллекцией друга и вашей
        Set<String> theirUniqueCards = new HashSet<>(theirCollection);
        theirUniqueCards.removeAll(myCollection); // Карты, которые есть у друга, но нет у вас

        // Обмен возможен, если есть уникальные карты у обеих сторон
        return !myUniqueCards.isEmpty() && !theirUniqueCards.isEmpty();
    }

    static Set<String> commonCards(List<Set<String>> collections) {
        Set<String> common = new HashSet<>(collections.get(0));
        for (int i = 1; i < collections.size(); i++) {
            common.retainAll(collections.get(i));
        }
        return common;
    }

    static Set<String> allCards(List<Set<String>> collections) {
        Set<String> all = new HashSet<>();
        for (Set<String> collection : collections) {
            all.addAll(collection);
        }
        return all;
    }
}
