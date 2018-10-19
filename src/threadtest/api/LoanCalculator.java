package threadtest.api;

public class LoanCalculator {
    public static void main(String[] args) {

        System.out.println("利息总和：" + calculate(33000, 2.5f * 30 / 10000, 20, 0));
    }

    /**
     * @param capital//本金
     * @param rate//利息
     * @param mouth//贷款时间
     * @return//利息和
     */
    private int days=30;
    private static boolean firstMonth=true;
    private static float calculate(float capital, float rate, int mouth, float interest) {
        if (firstMonth){
            rate=2.5f * 54 / 10000;
            firstMonth=false;
        }else {
            rate=2.5f * 30 / 10000;
        }
        final float repayCapital = 1650f;
        float interestTemp=capital * rate;
        System.out.println("利息："+interestTemp);
        interest += interestTemp;

        System.out.println("利息和："+interest);
//        System.out.println("剩余本金："+(capital-repayCapital));
        mouth--;
        if (mouth <= 0) {
            return interest;
        }else {
            calculate(capital-repayCapital, rate, mouth, interest);
        }

        return interest;
    }
}
