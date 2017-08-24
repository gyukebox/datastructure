package datastructure;

import java.util.ArrayList;

public class Dictionary {
    private DictionaryNode header;
    private DictionaryNode trailer;

    public Dictionary() {
        this.header = new DictionaryNode(0, null);
        this.trailer = new DictionaryNode(0, null);
        this.header.setNext(trailer);
        this.trailer.setPrev(header);
    }

    public void insert(int key, String value) {
        DictionaryNode newNode = new DictionaryNode(key, value);
        newNode.setNext(trailer);
        newNode.setPrev(newNode.getNext().getPrev());
        newNode.getNext().setPrev(newNode);
        newNode.getPrev().setNext(newNode);
    }

    public String find(int key) {
        DictionaryNode curr = this.header.getNext();
        while (curr != trailer) {
            if(curr.getKey() == key) {
                return curr.getValue();
            }
            curr = curr.getNext();
        }
        return null;
    }

    public ArrayList<DictionaryNode> findAll(int key) {
        ArrayList<DictionaryNode> ret = new ArrayList<>();
        DictionaryNode curr = this.header.getNext();
        while (curr != trailer) {
            if(curr.getKey() == key) {
                ret.add(curr);
            }
            curr = curr.getNext();
        }
        return ret;
    }

    public void remove(int key) {
        ArrayList<DictionaryNode> toRemove = findAll(key);
        for (DictionaryNode node : toRemove) {
            node.getPrev().setNext(node.getNext());
            node.getNext().setPrev(node.getPrev());
            node.setPrev(null);
            node.setNext(null);
        }
    }

    public void printDictionary() {
        DictionaryNode curr = header.getNext();
        while (curr != trailer) {
            System.out.print( "(" + curr.getKey() + ", " + curr.getValue() + ") ");
            curr = curr.getNext();
        }
        System.out.println();
    }
}
