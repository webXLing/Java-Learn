package x920;

// 一个部门 有多个雇员
class Dept {
    //    编号 deptno 名称dname 位置 loc
    private int deptno;
    private String dname;
    private String loc;
    private Emp[] emps; // 多个雇员

    public void setEmps(Emp[] emps) {
        this.emps = emps;
    }

    public Emp[] getEmps() {
        return this.emps;
    }

    public Dept(int deptno, String dname, String loc) {
        this.deptno = deptno;
        this.dname = dname;
        this.loc = loc;
    }

    public String getInfo() {
        return "部门编号：" + this.deptno + "部门名称：" + this.dname + "位置：" + this.loc;
    }
}

// 一个雇员 有一个领导
class Emp {
    //    empno 雇员编号 enamel雇员名称 job 雇员职位 sal雇员工资 comm
    private int empno;
    private String ename;
    private String job;
    private double sal;
    private double comm;
    private Dept dept;//表示对应的部门信息
    private Emp mgr;

    public void setMgr(Emp mgr) {
        this.mgr = mgr;
    }

    public Emp getMgr() {
        return this.mgr;
    }

    public Emp(int empno, String ename, String job, double sal, double comm) {
        this.empno = empno;
        this.ename = ename;
        this.job = job;
        this.sal = sal;
        this.comm = comm;
    }

    public String getInfo() {
        return "雇员编号：" + this.empno + "雇员名称：" + this.ename + "职位：" + this.job + "工资" + this.sal + "佣金：" + this.comm;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Dept getDept() {
        return this.dept;
    }
}

public class DeptEmp {
    public static void main(String[] args) {
//        第一步 设置数据
        Dept dept = new Dept(10, "技术部", "宁波");// 部门信息
        Emp emp1 = new Emp(1, "xl1", "java", 1000, 0.1);
        Emp emp2 = new Emp(2, "xl2", "java", 10020, 0.1);
        Emp emp3 = new Emp(3, "xl3", "java", 10300, 0.1);

//        设置雇员和领导关系
        emp1.setMgr(emp2);
        emp2.setMgr(emp3);
//        设置 雇员 与部门的关系
        emp1.setDept(dept);
        emp2.setDept(dept);
        emp3.setDept(dept);

        dept.setEmps(new Emp[]{emp1, emp2, emp3});

//        取出数据
//        查询一个雇员的他对应的领导信息 和部门信息
        System.out.println(emp1.getInfo());
        System.out.println(emp1.getMgr().getInfo());
        System.out.println(emp1.getDept().getInfo());
//通过 部门 找到所有雇员 以及其的 领导信息
        System.out.println("-----------");
        System.out.println(dept.getInfo());
        for (int i = 0; i < dept.getEmps().length; i++) {
            System.out.println(dept.getEmps()[i].getInfo());
            if (dept.getEmps()[i].getMgr() != null) {
                System.out.println(dept.getEmps()[i].getMgr().getInfo());
            }
        }
    }
}
