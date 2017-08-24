package datastructure;

public class Main {

    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        dictionary.insert(1, "henry");
        dictionary.insert(2, "James");
        dictionary.insert(3, "Zinedine");
        dictionary.insert(1, "Oliver");
        dictionary.insert(2, "Antoinne");
        dictionary.printDictionary();

        dictionary.remove(1);
        dictionary.printDictionary();
    }
}
