package iDeas;

import java.io.*;
import java.util.*;

/**
 * Created by vinod on 15/4/18.
 */
public class OutdatedVersion {

    /**
     * Solution is implemented using stack and at any given point of time stack contains the current greater version.
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {

            /**
             * Advanced try(), need to use Java 7 or greater to run it cleanly.
             */
        try (BufferedReader fileReader = new BufferedReader(new FileReader(new File("/home/vinod/IdeaProjects/GeeksForGeeks/src/iDeas/input.txt")));
             BufferedWriter fileWriter = new BufferedWriter(new FileWriter(new File("output.txt")));) {

            //Map to keep packages and its versions.
            Map<String, Stack<String>> softwarePackageVersionMap = new HashMap<>();


            String serverInformation = fileReader.readLine();
            Map<String, Integer> packageCnt = new HashMap<>();

            while (serverInformation != null) {

                String[] splittedLine = serverInformation.replace(" ", "").split(",");

                String softwarePackageName = splittedLine[2];
                String currentVer = splittedLine[3].trim();


                if (softwarePackageVersionMap.containsKey(softwarePackageName)) {
                    Stack<String> currentStack = softwarePackageVersionMap.get(softwarePackageName.trim());

                    if (packageCnt.get(softwarePackageName) == null || packageCnt.get(softwarePackageName) < 2) {

                        int count = 0;

                        //If current stack is not empty and count of servers is less than 2
                        while (!currentStack.isEmpty() && count < 2) {

                            String poppedVersion = currentStack.pop();
                            if (currentVer.compareTo(poppedVersion) > 0) {

                                //Increment count if current version is greater than popped version.
                                count++;
                            } else if (currentVer.compareTo(poppedVersion) < 0) {
                                //Increment counter if current version is less than popped version and repush the popped version.
                                count++;
                                currentStack.push(poppedVersion);
                                break;
                            } else {
                                currentStack.push(poppedVersion);
                                break;
                            }
                        }

                        if (currentStack.isEmpty() || count == 0) {
                            currentStack.push(currentVer);
                        }

                        //Update count in the package count map for current package.
                        Integer integer = packageCnt.get(softwarePackageName);
                        integer = (integer == null) ? 0 : integer;
                        packageCnt.put(softwarePackageName, integer + count);
                    }

                    softwarePackageVersionMap.put(softwarePackageName, currentStack);

                } else {
                    softwarePackageVersionMap.put(softwarePackageName, new Stack<String>() {{
                        push(currentVer);
                    }});
                }

                serverInformation = fileReader.readLine();
            }


            //Write package name to file.
            for (String packageName : packageCnt.keySet()) {
                if (packageCnt.get(packageName) >= 2) {
                    fileWriter.write(packageName + "\n");
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
