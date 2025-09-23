
/**
 * Test class for CustomHashMap with Foo objects as keys and String as values.
 * Foo class implements hashCode and equals methods to ensure proper
 * functionality in the hash table.
 */
class Foo {
  Integer x;
  Boolean y;
  String z;

  Foo(Integer x, Boolean y, String z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  @Override
  public int hashCode() {
    int hash = 17;
    hash = 31 * hash + (x == null ? 0 : x.hashCode());
    hash = 31 * hash + (y == null ? 0 : y.hashCode());
    hash = 31 * hash + (z == null ? 0 : z.hashCode());
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Foo foo = (Foo) obj;
    return (x == null ? foo.x == null : x.equals(foo.x)) &&
           (y == null ? foo.y == null : y.equals(foo.y)) &&
           (z == null ? foo.z == null : z.equals(foo.z));
  }
}

/**
 * Test class for CustomHashMap.
 */
public class TestCustomHashMap {
  /**
   * Main method to run tests.
   *
   * @param args
   */
  public static void main(String[] args) {
    CustomHashMap<Foo, String> map = new CustomHashMap<>();

    Foo foo1 = new Foo(1, true, "one");
    Foo foo2 = new Foo(2, false, "two");
    Foo foo3 = new Foo(3, true, "three");

    map.put(foo1, "First");
    map.put(foo2, "Second");
    map.put(foo3, "Third");

    assert "First".equals(map.get(foo1));
    assert "Second".equals(map.get(foo2));
    assert "Third".equals(map.get(foo3));
    assert map.get(new Foo(4, false, "four")) == null;
    System.out.println("All tests passed.");
  }
}