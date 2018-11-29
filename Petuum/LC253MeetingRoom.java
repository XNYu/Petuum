package Petuum;

import java.util.Arrays;

public class LC253MeetingRoom {
     public static class Interval {
         int start;
          int end;
          Interval() { start = 0; end = 0; }
          Interval(int s, int e) { start = s; end = e; }
      }
    public int minMeetingRooms(Interval[] intervals) {
        int[] start=new int[intervals.length];
        int[] end=new int[intervals.length];

        for(int i=0;i<intervals.length;i++){
            start[i]=intervals[i].start;
            end[i]=intervals[i].end;

        }
        // Don't care about the specific intervals
        // Care about start and ends
        Arrays.sort(start);
        Arrays.sort(end);

        int res=0;
        int en=0;
        for(int i=0;i<start.length;i++){
            if(start[i]<end[en]){
                System.out.println("New Room " + start[i]+" "+end[en]);
                res++;
            }else{
                System.out.println("No New Room " + start[i]+" "+end[en]);
                en++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LC253MeetingRoom m = new LC253MeetingRoom();
        Interval[] s = {new Interval(0, 30), new Interval(7, 10), new Interval(12, 15),new Interval(13,20)};
        System.out.println(m.minMeetingRooms(s));
    }
}
