public class Experiment {
    public static void main(String[] args) {
        int times = 1_600;
        String res;
        long start = System.currentTimeMillis();
        res = repeat2(times);
        long end = System.currentTimeMillis();
        System.out.println("StringBuilder took : " + (end - start) + " ms");
        start = System.currentTimeMillis();
        res = repeat1(times);
        end = System.currentTimeMillis();
        System.out.println("String took: " + (end - start) + " ms");
    }

    static String repeat1(int times) {
        String str = "";
        for (int i = 0; i < times; i++) {
            str += '*';
        }
        return str;
    }

    static String repeat2(int times) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times; i++) {
            sb.append('*');
        }
        return sb.toString();
    }
}
