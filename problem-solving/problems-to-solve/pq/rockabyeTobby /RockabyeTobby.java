import java.util.PriorityQueue;

/**
 * RockabyeTobby class provides a method to select medications based on their
 * frequency and priority using a priority queue.
 */

public class RockabyeTobby {
  /**
   * Medicine class represents a medication with a name, frequency, priority,
   * and a factor that increases after each selection.
   */
  static class Medicine {
    String name;
    int frequency;
    int priority;
    int factor;
    /**
     * Constructs a Medicine object.
     *
     * @param name      the name of the medicine
     * @param frequency the base frequency of the medicine
     * @param priority  the order of appearance for tie-breaking
     */

    Medicine(String name, int frequency, int priority) {
      this.name = name;
      this.frequency = frequency;
      this.priority = priority;
      factor = 1;
    }

    public int getFrequency() {
      return frequency * factor;
    }
  }

  public static String[] rockabyeTobby(String[] medications, int[] frequencys, int k) {
    PriorityQueue<Medicine> pq = new PriorityQueue<>((m1, m2) -> {
      // if frequency is different
      if (m1.getFrequency() != m2.getFrequency()) {
        return m1.getFrequency() - m2.getFrequency();
      }
      // check priority
      return m1.priority - m2.priority;
    });

    int n = medications.length;
    // System.out.println();
    for (int i = 0; i < n; i++) {
      // System.out.println(medications[i] + " "+ frequencys[i]);
      pq.add(new Medicine(medications[i], frequencys[i], i));
    }
    // System.out.println();
    String[] ans = new String[k];
    for (int i = 0; i < k; i++) {
      Medicine m = pq.remove();
      ans[i] = m.getFrequency() + " " + m.name;
      m.factor++;
      pq.add(m);
    }
    return ans;
  }
}
