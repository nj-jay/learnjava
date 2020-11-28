import java.util.Scanner;
public class RentMgrSys {
    public static void main(String[] args) {
        System.out.println("**********欢迎光临腾飞汽车租赁公司************");
        System.out.println("1.轿车\t\t2.客车\t\t3.卡车");
        System.out.print("请选择你要租赁的汽车类型:");
        Scanner sc = new Scanner(System.in);
        String motoType = sc.next();
        MotoOperation operation = new MotoOperation();
        operation.motoLeaseOut(motoType);
    }
}