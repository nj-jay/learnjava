import java.util.Scanner;

public class Trunk extends MotoVehicle{
    //卡车类 继承MotoVehicle
    //属性：吨 double tonnage


    private double tonnage;
    //构造方法(无参)
    public Trunk() {

    }

    //构造方法(有参)
    public Trunk(String vehicleld, String brand, int perRent, double tonnage) {
        super(vehicleld, brand, perRent);
        this.tonnage = tonnage;
    }

    //getter and setter

    public double getTonnage() {
        return tonnage;
    }

    public void setTonnage(double tonnage) {
        this.tonnage = tonnage;
    }


    @Override
    public float calRent(int days) {
        float price = (float) ( this.getPerRent() * days * this.getTonnage());
        return price;
    }

    @Override
    public void leaseOutFlow() {

        System.out.println("1.解放\t\t2.东风");
        System.out.print("请选择你要租赁的卡车品牌:");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        System.out.print("请输入卡车的吨数:");
        tonnage = sc.nextDouble();
        System.out.print("请输入您要租赁的天数:");
        int days = sc.nextInt();
        switch (choice) {
            case 1:
                setVehicleld("京GD56577");
                setPerRent(800);
                setTonnage(tonnage);
                System.out.println("分配给您的汽车牌号是:" + getVehicleld());
                System.out.println("您要支付的租赁费用是:" + calRent(days));
                break;
            case 2:
                setVehicleld("京GD53456");
                setPerRent(700);
                setTonnage(tonnage);
                System.out.println("分配给您的汽车牌号是:" + getVehicleld());
                System.out.println("您要支付的租赁费用是:" + calRent(days));
                break;
        }
        super.leaseOutFlow();
    }

}
