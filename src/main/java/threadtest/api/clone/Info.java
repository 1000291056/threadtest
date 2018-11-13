package threadtest.api.clone;

public class Info implements Cloneable{
    int f_c;
    String f_n="";

    public Info(int f_c, String f_n) {


        this.f_c = f_c;
        this.f_n = f_n;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Info{" +
                "f_c=" + f_c +
                ", f_n='" + f_n + '\'' +
                '}';
    }
}
