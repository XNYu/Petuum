package Petuum;

import java.util.PriorityQueue;

public class MedianFinder {
    /**
     * initialize your data structure here.
     */
    PriorityQueue<Integer> maxHeap, minHeap;
    double median;
    public MedianFinder() {
        maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        minHeap = new PriorityQueue<>();
        median = 0;
    }

    public void addNum(int num) {
        if (num >= median) {
            minHeap.add(num);
        } else {
            maxHeap.add(num);
        }
        int diff = maxHeap.size() - minHeap.size();
        if (diff == 2) {
            minHeap.add(maxHeap.poll());
            diff -= 2;
        } else if (diff == -2) {
            maxHeap.add(minHeap.poll());
            diff += 2;
        }
        if (diff == 1) {
            median = maxHeap.peek();
        } else if (diff == -1) {
            median = minHeap.peek();
        } else if (diff == 0) {
            median = ((double) maxHeap.peek() + (double) minHeap.peek()) / 2;
        }
        System.out.println("max "+maxHeap);
        System.out.println("min "+minHeap);
        System.out.println(median);
        System.out.println();
    }

    public double findMedian() {
        return median;
    }

    public static void main(String[] args) {
        MedianFinder m = new MedianFinder();
        m.addNum(1);
        m.addNum(2);
        m.addNum(3);
        m.addNum(-1);
        m.addNum(2);
        m.addNum(2);
        m.addNum(-1);
        m.addNum(-1);
    }
}
