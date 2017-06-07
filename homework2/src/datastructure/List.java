package datastructure;

public class List {
    private ListNode header;
    private ListNode trailer;

    public List() {
        this.header = new ListNode();
        this.trailer = new ListNode();
        header.setNextNode(trailer);
        trailer.setPrevNode(header);
    }

    public ListNode getHeader() {
        return header;
    }

    public void setHeader(ListNode header) {
        this.header = header;
    }

    public ListNode getTrailer() {
        return trailer;
    }

    public void setTrailer(ListNode trailer) {
        this.trailer = trailer;
    }

    public void initialization() {
        this.header.setNextNode(trailer);
        this.trailer.setPrevNode(header);
    }

    public void addLast(String command) {
        ListNode newNode = new ListNode(command, trailer.getPrevNode(), trailer);
        trailer.getPrevNode().setNextNode(newNode);
        trailer.setPrevNode(newNode);
    }

    public void addFirst(String command) {
        ListNode newNode = new ListNode(command, header, header.getNextNode());
        header.getNextNode().setPrevNode(newNode);
        header.setNextNode(newNode);
    }

    public ListNode getNode(int i) {
        ListNode curr = header.getNextNode();
        for (int j = 0; j < i; j++) {
            curr = curr.getNextNode();
        }
        return curr;
    }

}
