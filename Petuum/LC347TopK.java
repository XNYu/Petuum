package Petuum;

import java.util.*;

public class LC347TopK {
    //version7提前对比 找到minmax用array实现hashmap,priotiryqueue根据
    public List<Integer> topKFrequent(int[] nums, int k) {
        //find min and max
        int min=nums[0],max=nums[0];
        for(int val:nums){
            if(val<min)
                min=val;
            if(val>max)
                max=val;
        }
        int freq[]=new int[max-min+1];
        for(int i=0;i<nums.length;i++){
            freq[nums[i]-min]++;
        }

        Queue<Integer> q=new PriorityQueue(nums.length,Collections.reverseOrder());
        //nums.length是设置的初始化大小,使用Collections.reverseOrder(),变递减

        for(int i=0;i<freq.length;i++)q.offer(freq[i]);

        for(int i=0;i<k-1;i++)q.poll();

        int limit=q.poll();//找到k的界限

        List<Integer> lst= new ArrayList<>();

        for(int i=0;i<freq.length;i++){//找到所有大于界限的,总共k个
            if(freq[i]>=limit){
                lst.add(i+min);
            }
        }
        return lst;
    }
    class N {
        int val;
        int count;
        public N(int val, int count) {
            this.val = val;
            this.count = count;
        }
    }
    public List<Integer> topKFrequent2(int[] nums, int k) {
        PriorityQueue<N> queue = new PriorityQueue<>(new Comparator<N>() {
            @Override
            public int compare(N o1, N o2) {
                return o2.count-o1.count;
            }
        });
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            int count = map.getOrDefault(n, 0);
            map.put(n, count + 1);
        }
        for (Map.Entry e : map.entrySet()) {
            N n = new N((int)e.getKey(), (int)e.getValue());
            queue.offer(n);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(queue.poll().val);
        }
        return list;
    }
}
