package demo.gener;

/*
 第二种方式
 */
class GenerInterfaceImpl2I<I> implements GenerInterface<I> {
    @Override
    public void fun(I i) {
        System.out.println(i);
    }

}
