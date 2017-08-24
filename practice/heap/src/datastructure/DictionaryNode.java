package datastructure;

public class DictionaryNode {
    private DictionaryNode prev;
    private DictionaryNode next;
    private int key;
    private String value;

    public DictionaryNode(int key, String value) {
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }

    public DictionaryNode getPrev() {
        return prev;
    }

    public void setPrev(DictionaryNode prev) {
        this.prev = prev;
    }

    public DictionaryNode getNext() {
        return next;
    }

    public void setNext(DictionaryNode next) {
        this.next = next;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
