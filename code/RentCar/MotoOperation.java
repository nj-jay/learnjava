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