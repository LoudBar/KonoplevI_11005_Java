package tuple;

public class Main {

    public static void main(String[] args) {

        FourTuple<Float, Double, Float, Double> tuple = new FourTuple<>(15F, 20D, 25F, 30D);

        System.out.println(tuple.first);
        System.out.println(tuple.second);
        System.out.println(tuple.third);
        System.out.println(tuple.fourth);
    }

}

