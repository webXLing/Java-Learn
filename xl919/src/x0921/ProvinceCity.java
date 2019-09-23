package x0921;
//1对多

// 一个省份有多个城市
class Province{
    private int pid;
    private String pName;
    private City citys[];

    public void setCitys(City[] citys) {
        this.citys = citys;
    }

    public City[] getCitys() {
        return this.citys;
    }

    public Province(int pid, String pName){
        this.pid = pid;
        this.pName = pName;

    }

    public String getInfo(){
        return "省份id:"+this.pid+"省份名称："+this.pName;
    }

}

// 一个城市有 对应的省份
class City{
    private int cid;
    private String cName;
    private Province province;
    static String comtry="中国";  // 放入全局数据去区  最重要的一点是 static属性 在没有实例化对象的时候 也能访问 修改
    // 栈内存 堆内存 全局数据区 全局方法区
    public void setProvince(Province province) {
        this.province = province;
    }

    public Province getProvince() {
        return this.province;
    }

    public City(int cid, String cName) {
        this.cid = cid;
        this.cName = cName;
    }

    public String getInfo(){
        return "城市编号："+this.cid+"城市名称："+this.cName;
    }
}

public class ProvinceCity {
    public static void main(String[] args) {
        Province pro = new Province(1,"浙江");
        City city1 = new City(1,"宁波");
        City city2 = new City(2,"杭州");
        City city3 = new City(3,"舟山");

        System.out.println(city1.comtry);
        city1.comtry="美国";
        System.out.println(city2.comtry);
        System.out.println(city3.comtry);
        pro.setCitys(new City[]{city1,city2,city3});
        city1.setProvince(pro);
        city2.setProvince(pro);
        city3.setProvince(pro);

        for (int i = 0; i <pro.getCitys().length ; i++) {
            System.out.println(pro.getCitys()[i].getInfo());
        }
        System.out.println("----------");
        System.out.println(city1.getProvince().getInfo());
        System.out.println(city2.getProvince().getInfo());
        System.out.println(city3.getProvince().getInfo());
    }
}
