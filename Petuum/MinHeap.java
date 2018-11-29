package Petuum;
//最小堆
public class MinHeap {
    private int[] data;
    private int count; //当前节点数
    private int capacity; //容量

    private void shiftDown(int k){
        while((2*k)<=count){     //有左子节点
            int j=2*k;      //这轮循环,data[k]和data[j]交换位置
            if((j+1)<=count&&(data[j+1]<data[j])){ //有右子节点且右边的更小
                j+=1;
            }
            if(data[k]<=data[j])  //如果父节点小于等于子节点,则停止循环
                break;
            swap(data,k,j);
            k=j;       //k被赋为当前位置,为下次循环做初始化
        }
    }

    public static void swap(int[] arr,int a,int b){
        int c=arr[a];
        arr[a]=arr[b];
        arr[b]=c;
    }
    public MinHeap(int capacity) {
        this.data=new int[capacity+1];  //因为索引0不存节点，所以长度加一
        this.capacity=capacity;
        this.count=0;
    }
    //将一个无序数组构造成一个最小堆          相当于堆排序
    public MinHeap(int[] arr,int n){
        data=new int[n+1];
        capacity=n;
        for(int i=0;i<n;i++){
            data[i+1]=arr[i];
        }
        count=n;
        for(int i=count/2;i>=1;i--){  //i=count/2:i是最后一个叶子节点的父节点(最后一个非叶子节点)
            shiftDown(i);
        }
    }

    public int extractMin(){      //弹出最小值，即根节点
        assert(count>0);
        int ret=data[1];
        swap(data,1,count);    //将最后数放到第一位置,保持完全二叉树的结构
        count--;
        shiftDown(1);         //将第一个数移至合适位置,保持最小堆性质
        return ret;
    }

    public int size() {
        return count;
    }
    public boolean isEmpty(){
        return count==0;
    }
    public static void main(String[] args) {
        int arr[] = new int[]{9, 8, 8, 2, 33, 4, 1, 34, 21, 3,100,10000,1000000,-1};
        MinHeap mp=new MinHeap(arr,arr.length);
        System.out.print("heap.extractMin():");
        while(!mp.isEmpty()){
            System.out.print(mp.extractMin()+" ");   //从小到大输出
        }
    }

}
