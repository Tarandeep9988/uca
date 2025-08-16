public class MaxPQ {
	private int[] pq;
	private int n;

	public MaxPQ(int capacity) {
		this.pq = new int[capacity + 1];
		this.n = 0;
	}

	public boolean isEmpty() {
		return this.n == 0;
	}

	public int size() {
		return this.n;
	}

	public void insert(int x) {
		this.pq[++this.n] = x;
		swim(n);
	}

	private void swim(int k) {
		while(k > 1 && this.pq[k / 2] < this.pq[k]) {
			// Swap child and parent
			this.exch(k, k / 2);
			k /= 2;
		}
	}

	public int delMax() {
		int maxElem = this.pq[1];
		// Swap first with last element
		
		this.exch(1, n);
		this.n--;

		sink(1);
		return maxElem;
	}

	private int exch(int i, int j) {
		int temp = this.pq[i];
		this.pq[i] = this.pq[j];
		this.pq[j] = temp;
	}
	
	private boolean less(int i, int j) {
		return this.pq[i] < this.pq[j];
	}

	private void sink(int k) {
		while (2 * k <= n) {
			int j = 2 * k;
			
			if (k < n && less(j, j + 1) {
				j++;
			}
			exch(k, j);
			k = j;
		}
	}
}
