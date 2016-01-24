/**
 * description:
 * 对象无引用链后，需要进行标记和筛选后才行回收；
 *
 * 1. 演示对象可以在GC时候进行自我拯救，通过Finalize（）方法；
 * 2. 不过只有一种机会，一个对象的finalize（）方法只能执行一次
 *
 *
 *
 * author: xirong
 * date: 2015-07-30
 * version: 1.0
 */
public class FinalizeEscapeGC {
    public static FinalizeEscapeGC SAVE_INSTANCE = null;

    public void isAlive() {
        System.out.println("yes, i am still alive !");

    }

    @Override
    protected void finalize() throws Throwable{
        super.finalize();
        System.out.println("finalize method has been invoked !");
        // 拯救自我
        FinalizeEscapeGC.SAVE_INSTANCE =this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_INSTANCE =new FinalizeEscapeGC();

        // 对象第一次拯救自我
        SAVE_INSTANCE =null;
        System.gc();

        Thread.sleep(1000); // finalize方法的优先级低，等待1秒后
        if(SAVE_INSTANCE !=null){
            SAVE_INSTANCE.isAlive();
        }else {
            System.out.println("no ,i am dead !");
        }

        // 执行过一次后，被回收
        SAVE_INSTANCE =null;
        System.gc();

        Thread.sleep(1000);
        if(SAVE_INSTANCE !=null){
            SAVE_INSTANCE.isAlive();
        }else {
            System.out.println("no ,i am dead !");
        }

    }
}
