package threadtest.api.reference;

import threadtest.api.Person;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

import static threadtest.PrintTool.*;

public class RefeerenceT {
    public static void main(String[] args) {

        try {
            SoftReference<Person> softReference=new SoftReference<Person>(new Person());
            println("softReference--1:"+softReference.get());
            System.gc();
            Thread.sleep(1000);
            println("softReference--2:"+softReference.get());

            WeakReference<Person> weakReference=new WeakReference<Person>(new Person());
            println("weakReference--1:"+weakReference.get());
            System.gc();
            Thread.sleep(1000);
            println("weakReference--2:"+weakReference.get());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
