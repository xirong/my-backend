/**
 * description:
 * 对象优先分配在Eden空间，当不足时，发生Minor GC的操作
 * author: xirong
 * date: 2015-07-30
 * version: 1.0
 * copyright 2015 ,all rights reserved.
 */
public class MinorGC {
    private static final int _1MB=1024*1024;

    /*
    vm : -verbose:gc -Xmx20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     */
    public static void main(String[] args){
        byte[] a1,a2,a3,a4;
        a1 =new byte[2*_1MB];
        a2 =new byte[2*_1MB];
        a3 =new byte[2*_1MB];
        a4 =new byte[4*_1MB];

        System.out.println("main is over!");
    }
}

/*

[GC[DefNew: 7495K->382K(9216K), 0.0072260 secs] 7495K->6526K(19456K), 0.0072610 secs] [Times: user=0.00 sys=0.01, real=0.01 secs]
main is over!
Heap
 def new generation   total 9216K, used 4984K [0x00000007f9a00000, 0x00000007fa400000, 0x00000007fa400000)
  eden space 8192K,  56% used [0x00000007f9a00000, 0x00000007f9e7e8c8, 0x00000007fa200000)
  from space 1024K,  37% used [0x00000007fa300000, 0x00000007fa35fa88, 0x00000007fa400000)
  to   space 1024K,   0% used [0x00000007fa200000, 0x00000007fa200000, 0x00000007fa300000)
 tenured generation   total 10240K, used 6144K [0x00000007fa400000, 0x00000007fae00000, 0x00000007fae00000)
   the space 10240K,  60% used [0x00000007fa400000, 0x00000007faa00030, 0x00000007faa00200, 0x00000007fae00000)
 compacting perm gen  total 21248K, used 2930K [0x00000007fae00000, 0x00000007fc2c0000, 0x0000000800000000)
   the space 21248K,  13% used [0x00000007fae00000, 0x00000007fb0dca68, 0x00000007fb0dcc00, 0x00000007fc2c0000)
No shared spaces configured.

 */