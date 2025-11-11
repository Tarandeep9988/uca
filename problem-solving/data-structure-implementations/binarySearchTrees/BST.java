public class BST<Key extends Comparable<Key>, Value>
{
  private Node root;

  private class Node {
    Node right;
    Node left;
    Key key;
    Value value;

    Node(Key key, Value value) {
      this.key = key;
      this.value = value;
    }
  }

  // Implement these 5 functions as homework
  public Key min() {
    if (root == null) {
      return null;
    }
    Node node = root;
    while (node.left != null) {
      node = node.left;
    }
    return node.key;
  }

  public Key max() {
    if (root == null) {
      return null;
    }
    Node node = root;
    while (node.right != null) {
      node = node.right;
    }
    return node.key;
  }

  public Key floor(Key key) {
    if (root == null) {
      return null;
    }

    Node node = root;
    Node floor = null;
    while (node != null) {
      int cmp = key.compareTo(node.key);
      if (cmp == 0) {
        return node.key;
      }
      else if (cmp < 0) {
        node = node.left;
      }
      else {
        floor = node;
        node = node.right;
      }
    }
    return floor.key;
  }

  public Key ceil(Key key) {
    if (root == null) {
      return null;
    }

    Node node = root;
    Node ceil = null;
    while (node != null) {
      int cmp = key.compareTo(node.key);
      if (cmp == 0) {
        return node.key;
      }
      else if (cmp < 0) {
        ceil = node;
        node = node.left;
      }
      else {
        node = node.right;
      }
    } 
    return ceil.key;
  }

  public int rank(Key key) {
    // How many keys are smaller or equal to this key
    return rank(key, root);
  }
  // Helper function for rank function
  private int rank(Key key, Node node) {
    if (node == null) {
      return 0;
    }
    int cmp = key.compareTo(node.key);
    if (cmp == 0) {
      return 1 + rank(key, node.left);
    }
    else if (cmp < 0) {
      // Current node.key greater then the key
      return rank(key, node.left);
    }
    else {
      // Current node.key smaller then the key
      return 1 + rank(key, node.left) + rank(key, node.right);
    }
  }

  public Value get(Key key) {
    return get(root, key);  
  }

  private Value get(Node x, Key key) {
    if (x == null) {
      return null;
    }
    int cmp = key.compareTo(x.key);

    if (cmp == 0) {
      // Keys are matching
      return x.value;
    }
    else if (cmp < 0) {
      // Go left
      return get(x.left, key);
    }
    else {
      // Go right
      return get(x.right, key);
    }
  }

  public void put(Key key, Value value) {
    root = put(root, key, value);
  }

  private Node put(Node x, Key key, Value value) {
    if (x == null) {
      return new Node(key, value);
    }
    int cmp = key.compareTo(x.key);
    if (cmp == 0) {
      // Overwrite value at current node
      x.value = value;
    }
    else if (cmp < 0) {
      // Go left
      x.left = put(x.left, key, value);
    }
    else {
      // Go right
      x.right = put(x.right, key, value);
    }
    return x;
  }

  public static void main(String[] args) {
    BST<Integer, String> bst = new BST<Integer, String>();
    
    // When bst is empty
    assert bst.get(1) == null;
    assert bst.min() == null;
    assert bst.max() == null;
    assert bst.rank(1) == 0;
    assert bst.floor(1) == null;
    assert bst.ceil(1) == null;

    bst.put(5, "A");
    bst.put(1, "X");
    bst.put(3, "Y");
    bst.put(4, "Z");
    bst.put(7, "A");

    assert bst.get(4).equals("Z");
    assert bst.get(5).equals("A");
    assert bst.min().equals(1);
    assert bst.max().equals(7);

    assert bst.ceil(3).equals(3);
    assert bst.ceil(6).equals(7);
    assert bst.floor(6).equals(5);
    assert bst.rank(6) == 4;
    assert bst.rank(5) == 4;


    bst.put(5, "B");
    assert bst.get(5).equals("B");
  }
}
