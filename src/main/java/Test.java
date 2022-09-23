public class Test {

    public static void main(String[] args) {
        int population1 = 3;
        int population2 = 13;
        int population3 = 10;
        int population4 = 5;
        int p1_2 = Math.max(population1,population2);
        int p3_4 = Math.max(population3,population4);
        int larger = Math.max(p1_2,p3_4);
        System.out.println(p1_2);
        System.out.println(p3_4);
        System.out.println(larger);

    }
}