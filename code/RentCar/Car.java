import java.util.Scanner;
public class Car extends MotoVehicle {
    //轿车
    //类的属性 型号

    //定义属性
    private String type;//型号

    //构造方法(无参)
    public Car(){

    }
    //构造方法(有参)
    public Car(String vehicleld, String brand, int perRent, String type) {
        super(vehicleld, brand, perRent);
        this.type = type;
    }

    //Getter and Setter
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    //重写父类中的calRent()
    @Override
    public float calRent(int days) {
        float price = this.getPerRent() * days;
        if(days >= 0 && days <= 7) {
            price *= 1.0; //小于7天，原价
        } else if(days >= 7 && days <= 30) {
            price *= 0.9;//大于7天小于30天9折
        } else if(days > 30 && days <= 150) {
            price *= 0.8;//大于30天小于150天打8折
        } else if(days > 150) {
            price *= 0.7;//大于150天打7折
        }
        return price;
    }

    @Override
    public void leaseOutFlow() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1.宝马\t\t2.别克");
        System.out.print("请选择你要租赁的轿车品牌:");
        int choice1 = sc.nextInt();

        switch (choice1) {
            case 1:

                setType("550i");
                System.out.print("1." + getType() + "\t");
                setType("X6");
                System.out.println("2." + getType());
                System.out.print("请选择你要租赁的轿车型号:");
                int choice2 = sc.nextInt();
                System.out.print("请输入你要租赁的天数:");
                int days = sc.nextInt();
                switch (choice2) {
                    case 1:
                        setVehicleld("京CNY3284");
                        setPerRent(600);
                        break;
                    case 2:
                        setVehicleld("京NY28588");
                        setPerRent(800);
                        break;
                }
                System.out.println("分配给您的汽车牌号是:" + getVehicleld());
                System.out.println("您需要支付的租赁费用是:" + calRent(days) + "元");
                break;
            case 2:
                setType("林荫大道");
                System.out.print("1." + getType() + "\t");
                setType("GL8");
                System.out.println("2." + getType());
                System.out.print("请选择你要租赁的轿车型号:");
                int choice3 = sc.nextInt();
                System.out.print("请输入你要租赁的天数:");
                days = sc.nextInt();
                switch (choice3) {
                    case 1:
                        setVehicleld("京NT37465");
                        setPerRent(300);
                    case 2:
                        setVehicleld("京NT96968");
                        setPerRent(600);
                }
                System.out.println("分配给您的汽车牌号是:" + getVehicleld());
                System.out.println("您需要支付的租赁费用是:" + calRent(days) + "元");
                break;
            default:
                System.out.println("没有此轿车品牌");
        }
        super.leaseOutFlow();
    }


}
