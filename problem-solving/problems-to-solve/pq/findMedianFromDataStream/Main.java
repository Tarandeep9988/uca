public class Main {
    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();

        mf.addNum(1);
        assert mf.findMedian() == 1.0 : "Test 1 Failed";

        mf.addNum(2);
        assert mf.findMedian() == 1.5 : "Test 2 Failed";

        mf.addNum(3);
        assert mf.findMedian() == 2.0 : "Test 3 Failed";

        mf.addNum(4);
        assert mf.findMedian() == 2.5 : "Test 4 Failed";

        mf.addNum(5);
        assert mf.findMedian() == 3.0 : "Test 5 Failed";

        mf.addNum(6);
        assert mf.findMedian() == 3.5 : "Test 6 Failed";

        mf.addNum(0);
        assert mf.findMedian() == 3.0 : "Test 7 Failed";

        System.out.println("All tests passed!");
    }
}
