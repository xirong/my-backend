/**
 * description:
 * 当对象的age熬过指定年龄时，将进入老年代
 * author: xirong
 * date: 2015-07-30
 * version: 1.0
 * copyright 2015 ,all rights reserved.
 */
public class testMaxTenuringThreshold {
    private static final int _1MB = 1024*1024;

    /*
    vm :-verbose:gc -Xmx20M -Xms20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
    -XX:MaxTenuringThreshold=1
    -XX:MaxTenuringThreshold=15 尝试下 不同
    -XX:+PrintTenuringDistribution
     */
    public static void main(String[] args){
        /*
        eden space 8192K,
        from space 1024K,
        to   space 1024K,
         */

//        //-XX:MaxTenuringThreshold=1 运行注释
//        byte[] a1,a2,a3;
//        a1 =new byte[_1MB/4];
//        a2=new byte[4*_1MB];
//        // 对象优先存储在Eden，4M放不下，minor gc start
//        // a1 存储在from ，a2 from、to都无法放下，进入老年代
//        a3=new byte[4*_1MB];
//        a3 =null; //上一句分配的对象无引用，下次GC即可回收掉
//        // Eden空间中保存着上一个 4M，新对象无法存储，Minor GC开始，from 空间 age=1的 a1对象要到老年代去了
//        a3=new byte[4*_1MB];
//        // 最终，a3的4M在 Eden区，a1+a2进入老年代


        //-XX:MaxTenuringThreshold=15 运行注释
        byte[] a1,a2,a3;
        a1 =new byte[_1MB/4];
        a2=new byte[4*_1MB];
        // 对象优先存储在Eden，4M放不下，minor gc start
        // a1 存储在from ，a2 from、to都无法放下，进入老年代
        a3=new byte[4*_1MB];
        a3 =null; //上一句分配的对象无引用，下次GC即可回收掉
        // Eden空间中保存着上一个 4M，新对象无法存储，Minor GC开始，
        // from 空间 age=1的 a1对象不到年龄仍然留在 from 空间
        a3=new byte[4*_1MB];
        // 最终，a3的4M在 Eden区，a1+a2进入老年代
    }
}

/*
 -XX:MaxTenuringThreshold=1 的时候结果如下：

[GC[DefNew
Desired survivor size 524288 bytes, new threshold 1 (max 1)
- age   1:     615792 bytes,     615792 total
: 5556K->601K(9216K), 0.0056710 secs] 5556K->4697K(19456K), 0.0056960 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
[GC[DefNew
Desired survivor size 524288 bytes, new threshold 1 (max 1)
- age   1:        256 bytes,        256 total
: 4945K->0K(9216K), 0.0017150 secs] 9041K->4693K(19456K), 0.0017390 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
Heap
 def new generation   total 9216K, used 4178K [0x00000007f9a00000, 0x00000007fa400000, 0x00000007fa400000)
  eden space 8192K,  51% used [0x00000007f9a00000, 0x00000007f9e14820, 0x00000007fa200000)
  from space 1024K,   0% used [0x00000007fa200000, 0x00000007fa200100, 0x00000007fa300000)
  to   space 1024K,   0% used [0x00000007fa300000, 0x00000007fa300000, 0x00000007fa400000)
 tenured generation   total 10240K, used 4693K [0x00000007fa400000, 0x00000007fae00000, 0x00000007fae00000)
   the space 10240K,  45% used [0x00000007fa400000, 0x00000007fa895548, 0x00000007fa895600, 0x00000007fae00000)
 compacting perm gen  total 21248K, used 2623K [0x00000007fae00000, 0x00000007fc2c0000, 0x0000000800000000)
   the space 21248K,  12% used [0x00000007fae00000, 0x00000007fb08ffa0, 0x00000007fb090000, 0x00000007fc2c0000)
No shared spaces configured.
 */