package threadtest.errorthought;

/**
 * Created by wufeifei on 2016/4/11.
 * @deprecated
 */
public class Test {
    public static void main(String[] args) {
        InterruptTest interruptTest=new InterruptTest();
        interruptTest.setDaemon(true);
        interruptTest.start();
        try {
            Thread.sleep(100);
//            interruptTest.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("--------------------end");
//        int i=10;//10
//        System.out.println(i);
//        i++;
//        System.out.println(i);//11
//        ++i;
//        System.out.println(i);//12
//        System.out.println(i++);//12
//        System.out.println(i);//13
//        System.out.println(++i);//14
//        System.out.println(i);//14
//        char a='Z';
//        System.out.println(--a);
    }
}
