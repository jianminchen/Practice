package linkedList;

class Node<Item> {

  public Item item;
  public Node next;

  public Node(Item item) {
    this.item = item;
    this.next = null;
  }

  @Override
  public String toString() {

      String data = "";
      Node current = this;
      do {
          data += current.item + ",";
          current = current.next;
      } while (current != null);

      return data;
  }
}
