public class MotoVehicle {
    //父类
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
