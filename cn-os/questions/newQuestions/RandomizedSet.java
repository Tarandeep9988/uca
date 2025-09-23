import java.util.ArrayList;
import java.util.HashMap;

class RandomizedSet {
  private ArrayList<Integer> list;
  private HashMap<Integer, Integer> map;
  private int size = 0;
  public RandomizedSet() {
    list = new ArrayList<>();
    map = new HashMap<>();
  }

  public boolean insert(int val) {
    if (map.containsKey(val)) {
      return false;
    }
    if (size == list.size()) {
      list.add(-1);
    }

    list.set(size, val);
    map.put(val, size);
    size++;
    return true;
  }

  public boolean remove(int val) {
    if (!map.containsKey(val)) {
      return false;
    }

    int index = map.get(val); // element at index to be removed
    int lastElement = list.get(size - 1); // getting last element from list;
    list.set(index, lastElement);
    
    // update index of last element in hashmap
    map.put(lastElement, index);
    // removing entry of val
    map.remove(val);
    
    size--; // size reduced
    return true;
  }

  public int getRandom() {
    int random = (int) (Math.random() * size);
    System.out.println(size + " " + random);
    return list.get(random);
  }


  public static void main(String[] args) {
    RandomizedSet set = new RandomizedSet();
    set.insert(3);
    set.insert(5);
    set.insert(4);
    set.remove(4);
    for (int i = 0; i < 100; i++) {
      System.out.println(set.getRandom());
    }
  }
}