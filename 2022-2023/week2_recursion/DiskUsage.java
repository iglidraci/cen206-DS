import java.io.File;

public class DiskUsage {
    public static void main(String[] args) {
        File file = new File("/Users/dreisenfaust/Desktop/repos/cen206-DS");
        long size = directorySize(file);
        System.out.println((size / 10e6f) + " Mb");
    }

    static long directorySize(File file) {
        if (file.isFile()) return file.length();
        long total = 0;
        File[] subFiles = file.listFiles();
        if (subFiles != null) {
            for(File subFile : subFiles) {
                total += directorySize(subFile);
            }
        }
        return total;
    }
}
