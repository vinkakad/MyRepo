package iDeas;

import java.io.*;
import java.util.*;

/**
 * Created by vinod on 15/4/18.
 */
public class OutOfDateVersion {
    class Version implements Comparable<Version>{
        double x;
        double y;
        double z;

        public Version(double x,double y,double z){
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public int compareTo(Version o) {
            if (this.x > o.x)
                return 1;
            else if (this.x < o.x)
                return -1;
            else if (this.y > o.y)
                return 1;
            else if (this.y < o.y)
                return -1;
            else if (this.z > o.z)
                return 1;
            else if (this.z < o.z)
                return -1;

            return 0;
        }
    }

    public static void main(String[] args) {
        try {
            OutOfDateVersion outOfDateVersion = new OutOfDateVersion();
            BufferedReader bf = new BufferedReader(new FileReader(new File("/home/vinod/IdeaProjects/GeeksForGeeks/src/iDeas/input.txt")));
            Map<String,List<Version>> packageVersionMap = new HashMap<>();


            String line = bf.readLine();

            while (line != null){
                String[] splittedLine = line.split(",");

                String packageName = splittedLine[2];
                String version = splittedLine[3];

                String[] versionArr = version.split("\\.");
                Version versionO = outOfDateVersion.getVersion(versionArr);

                if (packageVersionMap.containsKey(packageName)) {
                    List<Version> strings = packageVersionMap.get(packageName.trim());
                    strings.add(versionO);
                    packageVersionMap.put(packageName, strings);
                } else {
                    packageVersionMap.put(packageName, new ArrayList<Version>() {{
                        add(versionO);
                    }});
                }

                line = bf.readLine();
            }


            Set<String> strings = packageVersionMap.keySet();
            List<String> pacakges = new ArrayList<>();

            for (String str : strings) {
                List<Version> versions = packageVersionMap.get(str);
                if (versions.size() > 2) {
                    Collections.sort(versions);
                    Version highestVersion = versions.get(versions.size() - 1);
                    double lowCount = 0;

                    for (Version ver : versions) {
                        if (highestVersion.compareTo(ver) == 1) {
                            lowCount += 1;
                        }
                    }

                    if (lowCount >= 2) {
                        pacakges.add(str);
                    }
                }
            }

            System.out.println(Arrays.toString(pacakges.toArray()));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Version getVersion(String[] versionArr) {

        if (versionArr.length > 2) {
            String x = versionArr[0];
            String y = versionArr[1];
            String z = versionArr[2];

            double dx=0,dy=0,dz = 0;

            dx = Double.parseDouble(x);

            if(y.length() > 1 && y.startsWith("0")) {
                y = y.substring(0,0) + "." + y.substring(1);
            }

            dy = Double.parseDouble(y);
            if(z.length() > 1 && z.startsWith("0")) {
                z = z.substring(0,0) + "." + z.substring(1);
            }
            dz = Double.parseDouble(z);

            return new Version(dx, dy, dz);
        } else {

            String x = versionArr[0];
            String y = versionArr[1];

            double dx=0,dy=0;

            dx = Double.parseDouble(x);

            if(y.length() > 1 && y.startsWith("0")) {
                y = y.substring(0,0) + "." + y.substring(1);
            }
            dy = Double.parseDouble(y);

            return new Version(dx, dy, 0);
        }
    }
}
