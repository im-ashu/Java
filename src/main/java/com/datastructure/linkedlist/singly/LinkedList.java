package com.datastructure.linkedlist.singly;

import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class LinkedList<T extends Comparable<T>> {

  Node<T> head;

  public static void main(String[] args) {
    LinkedList<Integer> linkedList = new LinkedList<>();
    linkedList.append(6);
    linkedList.push(7);
    linkedList.push(1);
    linkedList.insertAfterNode(linkedList.head.next, 8);
    linkedList.insertAtPosition(4, 4);
    linkedList.insertAtPosition(4, 9);
    linkedList.delete(9);
    linkedList.insertAtPosition(5, 9);
    linkedList.deleteAtPosition(5);
    linkedList.printList();
    System.out.println();
    System.out.printf("LinkedList length : %d%n", linkedList.getCount());
    System.out.printf("Is 6 present : %s%n", linkedList.search(6) ? "Yes" : "No");
    linkedList.getAtPosition(4)
        .ifPresent(d -> System.out.printf("Element at 4th position : %d%n", d));
    linkedList.getNthFromLast(2)
        .ifPresent(d -> System.out.printf("Element at 2nd position from last : %d%n", d));
    linkedList.getMiddle().ifPresent(d -> System.out.printf("Middle Element : %d%n", d));
    System.out.printf("Count of element 7 : %d%n", linkedList.getFrequency(7));
    linkedList.deleteList();

    linkedList.push(10);
    linkedList.push(4);
    linkedList.push(15);
    linkedList.push(20);

    linkedList.head.next.next.next.next = linkedList.head;

    System.out.printf("Is loop present using 2 pointers : %s%n",
        linkedList.detectLoopUsingTwoPointers() ? "Yes" : "No");
    System.out
        .printf("Is loop present using set : %s%n", linkedList.detectLoopUsingSet() ? "Yes" : "No");
    linkedList.printList();
    System.out.println();
    linkedList.deleteList();
    linkedList.push(1);
    linkedList.push(2);
    linkedList.push(3);
    linkedList.push(4);
    linkedList.push(3);
    linkedList.push(2);
    linkedList.push(1);
    linkedList.printList();
    System.out.println();
    System.out.printf("Is list palindrome : %s%n", linkedList.isPalindrome() ? "Yes" : "No");
    linkedList.deleteList();
    linkedList.push(7);
    linkedList.push(6);
    linkedList.push(5);
    linkedList.push(4);
    linkedList.push(3);
    linkedList.push(2);
    linkedList.push(1);
    linkedList.swapNodes(4, 3);
    linkedList.printList();
    linkedList.deleteList();

    LinkedList<Integer> sortedLinkedList = new LinkedList<>();
    sortedLinkedList.push(20);
    sortedLinkedList.push(13);
    sortedLinkedList.push(13);
    sortedLinkedList.push(11);
    sortedLinkedList.push(11);
    sortedLinkedList.push(11);
    System.out.println();
    System.out.println("List before removal of duplicates");
    sortedLinkedList.printList();
    sortedLinkedList.removeDuplicatesFromSortedList();
    System.out.println("List after removal of elements");
    sortedLinkedList.printList();

    linkedList.push(10);
    linkedList.push(11);
    linkedList.push(12);
    linkedList.push(11);
    linkedList.push(11);
    linkedList.push(12);
    linkedList.push(10);
    System.out.println();
    System.out.println("List before removal of duplicates");
    linkedList.printList();
    linkedList.removeDuplicatesFromUnsortedList();
    System.out.println("List after removal of elements");
    linkedList.printList();

    System.out.println();
    System.out.println("List before ");
    linkedList.printList();
    linkedList.moveLastElementToFront();
    System.out.println("List after");
    linkedList.printList();
    linkedList.deleteList();

    linkedList.push(0);
    linkedList.push(3);
    linkedList.push(0);
    linkedList.push(2);
    linkedList.push(0);
    linkedList.push(1);
    linkedList.push(0);
    linkedList.push(1);
    linkedList.push(0);
    linkedList.push(1);
    System.out.println();
    System.out.println("List before ");
    linkedList.printList();
    linkedList.moveZeroesToFront();
    System.out.println("List after");
    linkedList.printList();
    linkedList.deleteList();

    LinkedList<Integer> list1 = new LinkedList<>();
    LinkedList<Integer> list2 = new LinkedList<>();
    LinkedList<Integer> list3 = new LinkedList<>();
    list1.push(6);
    list1.push(5);
    list1.push(4);
    list1.push(3);
    list1.push(2);
    list1.push(1);

    list2.push(8);
    list2.push(6);
    list2.push(4);
    list2.push(2);
    System.out.println("\nIntersection");
    list3.intersection(list1.head, list2.head);
    list3.printList();

    list1.deleteList();
    list2.deleteList();
    list3.deleteList();

    list1.push(6);
    list1.push(4);
    list2.push(7);
    list2.push(8);
    System.out.println();
    System.out.println("Adding two lists");
    list3.head = addTwoLists(list1.head, list2.head);
    list3.printList();
  }

  private static Node<Integer> addTwoLists(Node<Integer> headList1, Node<Integer> headList2) {
    Node<Integer> dummy = new Node<>(0);
    Node<Integer> head = dummy;
    int sum;
    int carry = 0;
    Node<Integer> first = headList1;
    Node<Integer> second = headList2;
    while (first != null || second != null) {
      sum = carry + (first != null ? first.data : 0) + (second != null ? second.data : 0);
      if (sum >= 10) {
        carry = 1;
      } else {
        carry = 0;
      }
      sum = sum % 10;
      dummy.next = new Node<>(sum);
      dummy = dummy.next;
      if (first != null) {
        first = first.next;
      }
      if (second != null) {
        second = second.next;
      }
    }
    if (carry > 0) {
      dummy.next = new Node<>(carry);
    }
    return head.next;
  }

  public void push(T newData) {
    Node<T> newNode = new Node<>(newData);
    newNode.next = head;
    head = newNode;
  }

  public void append(T newData) {
    Node<T> newNode = new Node<>(newData);
    if (null == head) {
      head = newNode;
      return;
    }
    Node<T> last = head;
    while (last.next != null) {
      last = last.next;
    }
    last.next = newNode;
  }

  public void insertAfterNode(Node<T> previousNode, T newData) {
    if (previousNode == null) {
      return;
    }
    Node<T> newNode = new Node<>(newData);
    newNode.next = previousNode.next;
    previousNode.next = newNode;
  }

  public void insertAtPosition(int position, T newData) {
    Node<T> newNode = new Node<>(newData);
    if (position == 0) {
      newNode.next = head;
      head = newNode;
      return;
    }
    Node<T> temp = head;
    while (position-- > 1 && temp != null) {
      temp = temp.next;
    }
    if (position > 1 || temp == null) {
      return;
    }
    newNode.next = temp.next;
    temp.next = newNode;
  }

  public void delete(T key) {
    Node<T> temp = head;
    Node<T> prev = null;

    if (temp != null && temp.data == key) {
      head = temp.next;
      return;
    }
    while (temp != null && temp.data != key) {
      prev = temp;
      temp = temp.next;
    }
    if (temp == null) {
      return;
    }
    prev.next = temp.next;
  }

  public void deleteAtPosition(int position) {
    if (head == null) {
      return;
    }
    if (position == 0) {
      head = head.next;
      return;
    }
    Node<T> temp = head;
    for (int i = 0; i < position - 1 && temp != null; i++) {
      temp = temp.next;
    }
    if (temp == null || temp.next == null) {
      return;
    }
    temp.next = temp.next.next;
  }

  void deleteList() {
    head = null;
  }

  public void printList() {
    Node<T> node = head;
    while (node != null) {
      System.out.print(node.data + " ");
      node = node.next;
    }
  }

  public int getCount() {
    return getCountRecursive(head);
  }

  private int getCountRecursive(Node<T> node) {
    if (node == null) {
      return 0;
    }
    return 1 + getCountRecursive(node.next);
  }

  public boolean search(T data) {
    return searchRec(head, data);
  }

  private boolean searchRec(Node<T> node, T data) {
    if (node == null) {
      return false;
    }
    if (Objects.equals(data, node.data)) {
      return true;
    }
    return searchRec(node.next, data);
  }

  public Optional<T> getAtPosition(int n) {
    return getAtPositionRec(head, n);
  }

  private Optional<T> getAtPositionRec(Node<T> head, int n) {
    if (head == null) {
      return Optional.empty();
    }
    if (1 == n) {
      return Optional.of(head.data);
    }
    return getAtPositionRec(head.next, n - 1);
  }

  public Optional<T> getNthFromLast(int i) {
    Node<T> referenceNode = head;
    Node<T> mainNode = head;
    int count = 0;
    if (head == null) {
      return Optional.empty();
    }
    while (count < i) {
      if (referenceNode == null) {
        return Optional.empty();
      }
      referenceNode = referenceNode.next;
      count++;
    }
    while (referenceNode != null) {
      referenceNode = referenceNode.next;
      mainNode = mainNode.next;
    }
    return Optional.of(mainNode.data);
  }

  public Optional<T> getMiddle() {
    Node<T> slowNode = head;
    Node<T> fastNode = head;
    if (head == null) {
      return Optional.empty();
    }
    while (fastNode != null && fastNode.next != null) {
      fastNode = fastNode.next.next;
      slowNode = slowNode.next;
    }
    return Optional.of(slowNode.data);
  }

  public int getFrequency(T key) {
    return getFrequencyRec(head, key);
  }

  private int getFrequencyRec(Node<T> head, T key) {
    if (head == null) {
      return 0;
    }
    if (Objects.equals(head.data, key)) {
      return 1 + getFrequencyRec(head.next, key);
    }
    return getFrequencyRec(head.next, key);
  }

  private boolean detectLoopUsingSet() {
    Node<T> temp = head;
    Set<Node<T>> set = new HashSet<>();
    Node<T> prev = null;
    while (temp != null) {
      if (set.contains(temp)) {
        /*prev.next = null; // For removing loop*/
        return true;
      }
      set.add(temp);
      prev = temp;
      temp = temp.next;
    }
    return false;
  }

  private boolean detectLoopUsingTwoPointers() {
    Node<T> slowNode = head;
    Node<T> fastNode = head;
    while (slowNode != null && fastNode != null && fastNode.next != null) {
      slowNode = slowNode.next;
      fastNode = fastNode.next.next;

      if (slowNode == fastNode) {
        removeLoop(slowNode, head);
        return true;
      }
    }
    return false;
  }

  private void removeLoop(Node<T> loop, Node<T> head) {
    Node<T> node1 = loop;
    Node<T> node2 = loop;
    int k = 1;
    int i;
    while (node1.next != node2) {
      node1 = node1.next;
      k++;
    }
    node1 = head;
    node2 = head;
    for (i = 0; i < k; i++) {
      node2 = node2.next;
    }
    while (node2 != node1) {
      node1 = node1.next;
      node2 = node2.next;
    }
    while (node2.next != node1) {
      node2 = node2.next;
    }
    node2.next = null;
  }

  boolean isPalindrome() {
    Node<T> fast = head;
    Node<T> slow = head;
    Node<T> prevOfSlow = null;
    Node<T> midNode = null;
    Node<T> secondHalfHead;
    boolean res = true;

    if (head != null && head.next != null) {
      while (fast != null && fast.next != null) {
        fast = fast.next.next;
        prevOfSlow = slow;
        slow = slow.next;
      }
      /*
       * fast_ptr would become NULL when there are even elements
       * in the list and not NULL for odd elements.We need to skip
       * the middle node for odd case and store it somewhere so that
       * we can restore the original list
       * */
      if (fast != null) {
        midNode = slow;
        slow = slow.next;
      }
      secondHalfHead = slow;
      prevOfSlow.next = null; //Terminate first half
      secondHalfHead = reverse(secondHalfHead);
      res = compareLists(head, secondHalfHead);
      secondHalfHead = reverse(secondHalfHead);
      if (midNode != null) {
        prevOfSlow.next = midNode;
        midNode.next = secondHalfHead;
      } else {
        prevOfSlow.next = secondHalfHead;
      }
    }
    return res;
  }

  private boolean compareLists(Node<T> head, Node<T> secondHalfHead) {
    Node<T> temp1 = head;
    Node<T> temp2 = secondHalfHead;
    while (temp1 != null && temp2 != null) {
      if (temp1.data != temp2.data) {
        return false;
      }
      temp1 = temp1.next;
      temp2 = temp2.next;
    }
    return temp1 == null && temp2 == null;
  }

  private Node<T> reverse(Node<T> head) {
    Node<T> prev = null;
    Node<T> current = head;
    Node<T> next;
    while (current != null) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }
    head = prev;
    return head;
  }

  public void swapNodes(T x, T y) {
    Node<T> prevX = null;
    Node<T> prevY = null;
    Node<T> currentX = head;
    Node<T> currentY = head;

    while (currentX != null && !Objects.equals(currentX.data, x)) {
      prevX = currentX;
      currentX = currentX.next;
    }

    while (currentY != null && !Objects.equals(currentY.data, y)) {
      prevY = currentY;
      currentY = currentY.next;
    }

    if (currentX == null || currentY == null) {
      return;
    }
    if (prevX != null) {
      prevX.next = currentY;
    } else {
      head = currentY;
    }
    if (prevY != null) {
      prevY.next = currentX;
    } else {
      head = currentX;
    }
    Node<T> temp = currentX.next;
    currentX.next = currentY.next;
    currentY.next = temp;
  }

  public void removeDuplicatesFromSortedList() {
    Node<T> curr = head;
    Node<T> temp;
    while (curr != null) {
      temp = curr;
      while (temp != null && Objects.equals(temp.data, curr.data)) {
        temp = temp.next;
      }
      curr.next = temp;
      curr = curr.next;
    }
  }

  public void removeDuplicatesFromUnsortedList() {
    Node<T> node1 = head;
    Node<T> node2;
    while (node1 != null) {
      node2 = node1;
      while (node2.next != null) {
        if (Objects.equals(node1.data, node2.next.data)) {
          node2.next = node2.next.next;
        } else {
          node2 = node2.next;
        }
      }
      node1 = node1.next;
    }
  }

  public void moveLastElementToFront() {
    Node<T> last = head;
    Node<T> secondLast = null;
    if (head == null || head.next == null) {
      return;
    }
    while (last.next != null) {
      secondLast = last;
      last = last.next;
    }
    secondLast.next = null;
    last.next = head;
    head = last;
  }

  public void moveZeroesToFront() {
    if (head == null || head.next == null) {
      return;
    }
    Node<T> prev = head;
    Node<T> current = head.next;
    while (current != null) {
      if (Objects.equals(current.data, 0)) {
        Node<T> temp = current;
        current = current.next;
        prev.next = current;
        temp.next = head;
        head = temp;
      } else {
        prev = current;
        current = current.next;
      }
    }
  }

  public void intersection(Node<T> firstListHead, Node<T> secondListHead) {
    Node<T> first = firstListHead;
    Node<T> second = secondListHead;
    while (first != null && second != null) {
      if (Objects.equals(first.data, second.data)) {
        append(first.data);
        first = first.next;
        second = second.next;
      } else if (first.data.compareTo(second.data) > 0) {
        second = second.next;
      } else {
        first = first.next;
      }
    }
  }

  public void swapKthNode(int k) {
    int size = getCount();
    if (k > size) {
      return;
    }
    if (((2 * k) - 1) == size) {
      return;
    }
    int x, y;
    Node<T> ptr1 = head;
    Node<T> prevPtr1 = null;
    Node<T> ptr2 = head;
    Node<T> prevPtr2 = null;
    for (int i = 1; i < k; i++) {
      prevPtr1 = ptr1;
      ptr1 = ptr1.next;
    }
    for (int i = 1; i < size - k + 1; i++) {
      prevPtr2 = ptr2;
      ptr2 = ptr2.next;
    }
    if (prevPtr1 != null) {
      prevPtr1.next = ptr2;
    }
    if (prevPtr2 != null) {
      prevPtr2.next = ptr1;
    }

    Node<T> temp = ptr1.next;
    ptr1.next = ptr2.next;
    ptr2.next = temp;

    if (k == 1) {
      head = ptr2;
    }
    if (k == size) {
      head = ptr1;
    }

  }

  static class Node<T> {

    T data;
    Node<T> next;

    public Node(T data) {
      this.data = data;
      this.next = null;
    }
  }
}
