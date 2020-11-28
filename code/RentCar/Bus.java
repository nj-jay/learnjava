import java.util.Scanner;
public class Bus extends MotoVehicle{
    //客车
    //继承MotoVehicle(汽车 父类)
    //类的属性 座位数

    //定义属性
    private int seatCount;//座位数

    //构造方法(无参)
    public Bus() {
    }

    //构造方法(有参)
    public Bus(String vehicleld, String brand, int perRent, int seatCount) {
        super(vehicleld, brand, perRent);//父类
        this.seatCount = seatCount;//本类
    }

    //getter and setter
    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    //重写父类的计算租金方法
    public float calRent(int days) {
        float price = this.getPerRent() * days; //总收费 = 租金x天数
        //收费规则
        if(days >= 3 && days < 7 ) {
            price *= 0.9;//大于等于3天小于7天打9折
        } else if(days >= 7 && days < 30) {
            price *= 0.8;//大于等于7天小于30天打8折
        }else if(days >= 30 && days < 150) {
            price *= 0.7;
        }else if(days >= 150) {
            price *= 0.6;//大于等于150天打6折
        }
        return price; //返回打折后的总收费
    }

    @Override
    public void leaseOutFlow() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1.金杯\t\t2.金龙");
        System.out.print("请选择你要租赁的客车品牌:");
        int choice1 = sc.nextInt();
        System.out.print("请输入客车的座位数:");
        seatCount = sc.nextInt();
        System.out.print("请输入你要租赁的天数:");
        int days = sc.nextInt();
        switch (choice1) {
            case 1:
                if(seatCount <= 16) {
                    setSeatCount(16);
                    setVehicleld("京6566754");
                    setPerRent(800);

                } else if(seatCount > 16) {
                    setSeatCount(34);
                    setVehicleld("京9696996");
                    setPerRent(1500);
                }
                System.out.println("分配给您的汽车牌号是:" + getVehicleld());
                System.out.println("您需要支付的租赁的费用是:" + calRent(days));
                break;
            case 2:
                if(seatCount <= 16) {
                    setSeatCount(16);
                    setVehicleld("京8696997");
                    setPerRent(800);
                } else if(seatCount > 16) {
                    setSeatCount(34);
                    setVehicleld("京8696998");
                    setPerRent(1500);
                }
                System.out.println("分配给您的汽车牌号是:" + getVehicleld());
                System.out.println("您需要支付的租赁的费用是:" + calRent(days));
                break;
            default:
                System.out.println("没有此类客车品牌");
        }
        super.leaseOutFlow();

    }

}
