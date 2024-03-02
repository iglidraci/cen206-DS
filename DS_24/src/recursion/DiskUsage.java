package recursion;

import java.io.File;

public class DiskUsage {

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
