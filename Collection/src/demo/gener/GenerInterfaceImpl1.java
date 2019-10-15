package demo.gener;

public class GenerInterfaceImpl1 implements GenerInterface<String> {
    @Override
    public void fun(String s) {
        System.out.println(s);
    }
}
