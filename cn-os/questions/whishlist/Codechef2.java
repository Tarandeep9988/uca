import java.util.*;

class Codechef
{
	public static void main (String[] args) {
		
        ProductTracker pt = new ProductTracker();
		pt.wishlist("a");
		pt.wishlist("a");
		pt.wishlist("a");
		
		pt.wishlist("b");
		pt.wishlist("b");
		// a = 3
		// b = 2
		
		System.out.println("MAX : " + pt.getMaxProduct());
		System.out.println("MIN : " + pt.getMinProduct());
		
		pt.delist("a");
		pt.delist("a");

		// a = 1
		// b = 2
		System.out.println("MAX : " + pt.getMaxProduct());
		System.out.println("MIN : "  + pt.getMinProduct());
		
		pt.delist("a");
		// a = 0 -> should be removed

		pt.delist("a"); // nothing should happen
		
		
		System.out.println("MAX : " + pt.getMaxProduct());
		System.out.println("MIN : " + pt.getMinProduct());
	}
}


class ProductTracker {
    HashMap<String, Integer> map;
    public ProductTracker() {
		map = new HashMap<>();
	}
    
    public void wishlist(String productName)  {
		map.put(productName, map.getOrDefault(productName, 0) + 1);
	}
    
    public void delist(String productName)  {
		int cnt = map.getOrDefault(productName, 0);
		if (cnt <= 1) {
			map.remove(productName);
		}
		else {
			map.put(productName, cnt - 1);
		}
	}
    
    public String getMaxProduct()  {
		String res = "";
		int maxCnt = -1;
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() > maxCnt) {
				res = entry.getKey();
				maxCnt = entry.getValue();
			}
		}
		return res;
	}
    
    public String getMinProduct()  {
		String res = "";
		int minCnt = Integer.MAX_VALUE;
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() < minCnt) {
				res = entry.getKey();
				minCnt = entry.getValue();
			}
		}
		return res;
	}
}


