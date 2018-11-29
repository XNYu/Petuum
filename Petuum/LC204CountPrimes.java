package Petuum;

import java.util.ArrayList;

public class LC204CountPrimes {
    ArrayList<Integer> primes;
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        //选取一个数，把在n以内的，所以这个数的倍数mark
        for (int i = 2; i < n; i++) {
            //这个条件比较tricky，查看当前数字是否是false，如果是false，那么需要mark它的倍数
            //如果不是prime，说明它的倍数已经被Mark过了，就不管了
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; i*j < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }
        return count;
    }
    public int countPrimes2(int n) {
        primes = new ArrayList<>();
        if(n<2)
            return 0;
        primes.add(2);
        for (int i = 3; i < n; i++) {
            int cur = (int) Math.sqrt(i);
            boolean isPrime = true;
            for (int p : primes) {
                if(p>cur)
                    break;
                if(i%p==0)
                {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime)
                primes.add(i);
        }
        System.out.println(primes);
        return primes.size();
    }

    public static void main(String[] args) {
        LC204CountPrimes l = new LC204CountPrimes();
        System.out.println(l.countPrimes(100));
    }
}
