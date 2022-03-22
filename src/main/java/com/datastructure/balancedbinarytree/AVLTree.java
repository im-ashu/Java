package com.datastructure.balancedbinarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class AVLTree<T extends Comparable<T>> {

  AVLNode<?> root;
  int nodeCount = 0;

  public static void main(String[] args) {
    AVLTree<Integer> tree = new AVLTree<>();

    /* Constructing tree given in the above figure */
    tree.insert(10);
    tree.insert(20);
    tree.insert(30);
    tree.insert(40);
    tree.insert(50);
    tree.insert(25);
    tree.insert(5);
    tree.remove(5);
 /*tree.root = tree.insert(tree.root, 20);
 tree.root = tree.insert(tree.root, 30);
 tree.root = tree.insert(tree.root, 40);
 tree.root = tree.insert(tree.root, 50);
 tree.root = tree.insert(tree.root, 25);*/

 /* The constructed AVL Tree would be
 30
 / \
 20 40
 / \ \
 10 25 50
 */
    System.out.println("Preorder traversal" +
        " of constructed tree is : ");
    tree.preOrderTraversal();
    System.out.println();
    System.out.println("Inorder traversal" +
        " of constructed tree is : ");
    tree.inOrderTraversal();

    System.out.println();
    System.out.println("Level order traversal" +
        " of constructed tree is : ");
    tree.levelOrderTraversal();
  }

  public int height() {
   if (root == null) {
    return 0;
   }
    return root.height;
  }

  public int size() {
    return nodeCount;
  }

  public boolean contains(T value) {
   if (value == null) {
    return false;
   }
    return contains(root, value);
  }

  private boolean contains(AVLNode<?> node, T value) {
   if (value == null || node == null) {
    return false;
   }
    int compareValue = value.compareTo((T) node.data);
    if (compareValue < 0) {
      return contains(node.left, value);
    } else if (compareValue > 0) {
      return contains(node.right, value);
    }
    return true;
  }

  private AVLNode<?> insert(AVLNode<?> node, T value) {
   if (node == null) {
    return new AVLNode<>(value);
   }
    int compareValue = value.compareTo((T) node.data);
    if (compareValue < 0) {
      node.left = insert(node.left, value);
    } else {
      node.right = insert(node.right, value);
    }
    update(node);
    return balance(node);
  }

  public boolean insert(T value) {
   if (value == null) {
    return false;
   }
    if (!contains(value)) {
      root = insert(root, value);
      nodeCount++;
      return true;
    }
    return false;
  }

  private void update(AVLNode<?> node) {
    int leftHeight = (node.left == null) ? -1 : node.left.height;
    int rightHeight = node.right == null ? -1 : node.right.height;
    node.height = 1 + Math.max(leftHeight, rightHeight);
    node.balanceFactor = rightHeight - leftHeight;
  }

  private AVLNode<?> balance(AVLNode<?> node) {
   if (node == null) {
    return null;
   }
    if (node.balanceFactor == -2) {
      if (node.left.balanceFactor <= 0) {
        return leftLeftCase(node);
      } else {
        return leftRightCase(node);
      }
    } else if (node.balanceFactor == 2) {
      if (node.right.balanceFactor >= 0) {
        return rightRightCase(node);
      } else {
        return rightLeftCase(node);
      }
    }
    return node;
  }

  private AVLNode<?> leftLeftCase(AVLNode<?> node) {
    return rightRotation(node);
  }

  private AVLNode<?> leftRightCase(AVLNode<?> node) {
    node.left = leftRotation(node.left);
    return leftLeftCase(node);
  }

  private AVLNode<?> rightRightCase(AVLNode<?> node) {
    return leftRotation(node);
  }

  private AVLNode<?> rightLeftCase(AVLNode<?> node) {
    node.right = rightRotation(node.right);
    return rightRightCase(node);
  }

  private AVLNode<?> rightRotation(AVLNode<?> node) {
    AVLNode<?> newParent = node.left;
    node.left = newParent.right;
    newParent.right = node;
    update(node);
    update(newParent);
    return newParent;
  }

  private AVLNode<?> leftRotation(AVLNode<?> node) {
    AVLNode<?> newParent = node.right;
    node.right = newParent.left;
    newParent.left = node;
    update(node);
    update(newParent);
    return newParent;
  }

  public boolean remove(T value) {
   if (value == null) {
    return false;
   }
    if (contains(value)) {
      root = remove(root, value);
      nodeCount--;
      return true;
    }
    return false;
  }

  private AVLNode<?> remove(AVLNode<?> node, T value) {
   if (value == null) {
    return null;
   }
    int compareValue = value.compareTo((T) node.data);
    if (compareValue < 0) {
      node.left = remove(node.left, value);
    } else if (compareValue > 0) {
      node.right = remove(node.right, value);
    } else {
      if (node.left == null) {
        return node.right;
      } else if (node.right == null) {
        return node.left;
      } else {
        if (node.left.height > node.right.height) {
          AVLNode<?> tempSuccessor = findMax(node.left);
          node.data = tempSuccessor.data;
          node.left = remove(node.left, (T) tempSuccessor.data);
        } else {
          AVLNode<?> tempSuccessor = findMin(node.right);
          node.data = tempSuccessor.data;
          node.right = remove(node.right, (T) tempSuccessor.data);
        }
      }
    }
    update(node);
    return balance(node);
  }

  private AVLNode<?> findMax(AVLNode<?> node) {
   while (node.left != null) {
    node = node.left;
   }
    return node;
  }

  private AVLNode<?> findMin(AVLNode<?> node) {
   while (node.right != null) {
    node = node.right;
   }
    return node;
  }

  public void preOrderTraversal() {
   if (root == null) {
    return;
   }
    preOrderTraversal(root);
  }

  private void preOrderTraversal(AVLNode<?> node) {
   if (node == null) {
    return;
   }
    System.out.print(node.data + " ");
    preOrderTraversal(node.left);
    preOrderTraversal(node.right);
  }

  public void inOrderTraversal() {
    Stack<AVLNode<?>> stack = new Stack<>();
    stack.push(root);
    AVLNode<?> traverse = root;
    while (!stack.isEmpty()) {
      while (traverse != null && traverse.left != null) {
        stack.push(traverse.left);
        traverse = traverse.left;
      }
      AVLNode<?> node = stack.pop();
      if (node.right != null) {
        stack.push(node.right);
        traverse = node.right;
      }
      System.out.print(node.data + " ");
    }

  }

  public void levelOrderTraversal() {
    Queue<AVLNode<?>> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      AVLNode<?> node = queue.poll();
      System.out.print(node.data + " ");
     if (node.left != null) {
      queue.add(node.left);
     }
     if (node.right != null) {
      queue.add(node.right);
     }
    }
  }
}