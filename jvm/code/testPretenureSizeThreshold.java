/**
 * description:
 * 大对象直接分配在老年大，参数 -XX:PretenureSizeThreshold
 * author: xirong
 * date: 2015-07-30
 * version: 1.0
 * copyright 2015 ,all rights reserved.
 */
public class testPretenureSizeThreshold {
    private static final int _1MB = 1024*1024;

    /*
    vm :-verbose:gc -Xmx20M -Xms20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
    -XX:PretenureSizeThreshold=3145728
     */
    public static void main(String[] args){
        byte[] a4;
        a4 =new byte[4*_1MB]; // 大于3M直接分配在老年代

    }
}

/*
Heap
 def new generation   total 9216K, used 1515K [0x00000007f9a00000, 0x00000007fa400000, 0x00000007fa400000)
  eden space 8192K,  18% used [0x00000007f9a00000, 0x00000007f9b7af08, 0x00000007fa200000)
  from space 1024K,   0% used [0x00000007fa200000, 0x00000007fa200000, 0x00000007fa300000)
  to   space 1024K,   0% used [0x00000007fa300000, 0x00000007fa300000, 0x00000007fa400000)
 tenured generation   total 10240K, used 4096K [0x00000007fa400000, 0x00000007fae00000, 0x00000007fae00000)
   the space 10240K,  40% used [0x00000007fa400000, 0x00000007fa800010, 0x00000007fa800200, 0x00000007fae00000)
 compacting perm gen  total 21248K, used 2979K [0x00000007fae00000, 0x00000007fc2c0000, 0x0000000800000000)
   the space 21248K,  14% used [0x00000007fae00000, 0x00000007fb0e8cf8, 0x00000007fb0e8e00, 0x00000007fc2c0000)
No shared spaces configured.

对象直接分配在 tenured generation 里面了
 */