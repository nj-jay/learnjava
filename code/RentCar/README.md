# java大作业：汽车租赁

### by信卓11801聂健 201801022

![](https://picture.nj-jay.com/5.28.11.25.png)

```java
//filename MotoVehicle.java
//父类
public class MotoVehicle {
    //类的属性 1.车牌 2.日租金 3.品牌
    //类的方法 1.计算租金 public float calRent(int days)
    //        2.租车流程 public void leaseOutFlow();
    //定义属性
    private String vehicleld;//车牌号
    private String brand;//品牌
    private float perRent;//日租金

    //构造方法(无参)
    public MotoVehicle() {
    }

    //构造方法(有参数)
    public MotoVehicle(String vehicleld, String brand, float perRent) {
        this.vehicleld = vehicleld;
        this.brand = brand;
        this.perRent = perRent;
    }

    //getter and setter
    public String getVehicleld() {
        return vehicleld;
    }

    public void setVehicleld(String vehicleld) {
        this.vehicleld = vehicleld;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public float getPerRent() {
        return perRent;
    }

    public void setPerRent(float perRent) {
        this.perRent = perRent;
    }

    //计算租金
    public float calRent(int days) {
        return days * perRent;
    }
    public void leaseOutFlow() {

    }
}
```

```java
//filename: Car.java
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
                System.out.println("请选择你要租赁的轿车型号:");
                int choice3 = sc.nextInt();
                System.out.println("请输入你要租赁的天数:");
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
```

```java
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
```

```java
//filename: Trunk.java
import java.util.Scanner;
public class Trunk extends MotoVehicle{
    //卡车类 继承MotoVehicle
    //属性：吨  double tonnage

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
```

```java
//filename: MotoOperation.java
import java.util.Scanner;
public class MotoOperation {

    //方法：motoLeaseOut(motoType:String):MotoVehicle
    //创建车的对象
    //选择租赁哪辆车

    public MotoVehicle motoLeaseOut(String motoType) {

        MotoVehicle car = new Car();
        MotoVehicle bus = new Bus();
        MotoVehicle trunk = new Trunk();
        switch (motoType) {
            case "1":
                car.leaseOutFlow();//调用car的租车流程
                break;
            case "2":
                bus.leaseOutFlow();//调用bus的租车流程
                break;
            case "3":
                trunk.leaseOutFlow();//调用卡车的租车流程
        }
        return null;
    }
}
```

```java
//filename: RentMgrSys.java
import java.util.Scanner;
public class RentMgrSys {
    public static void main(String[] args) {
        System.out.println("**********欢迎光临腾飞汽车租赁公司************");
        System.out.print("1.轿车\t\t2.客车\t\t3.卡车");
        System.out.print("请选择你要租赁的汽车类型:");
        Scanner sc = new Scanner(System.in);
        String motoType = sc.next();
        MotoOperation operation = new MotoOperation();
        operation.motoLeaseOut(motoType);
    }
}
```

运行结果

Car类

<img src="https://picture.nj-jay.com/5.28.11.43.png" style="zoom:67%;" />

<img src="https://picture.nj-jay.com/5.28.11.44.png" style="zoom:67%;" />

Bus类

<img src="https://picture.nj-jay.com/5.28.11.49.png" style="zoom:67%;" />

Trunk类

<img src="https://picture.nj-jay.com/5.28.11.50.png" style="zoom:67%;" />