// package csvReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class csvReader {
    public static void main(String[] args) {
        String filename = "\\Users\\csilb\\Documents\\java\\csvReader\\src\\sample.csv";
        File file = new File(filename);
        int version = 2;

        if (version == 1) {
            Properties p = System.getProperties();
            Enumeration keys = p.keys();
            while (keys.hasMoreElements()) {
                String key = (String) keys.nextElement();
                String value = (String) p.get(key);
            System.out.println(key + ": " + value);
            }
        }

        if (version == 2) {
            List<List<String>> lines = new ArrayList<>();
            Scanner inputStream;

            try {
                inputStream = new Scanner(file);

                while (inputStream.hasNext()) {
                    String line = inputStream.nextLine();
                    String[] values = line.split(",");
                    // this adds the currently parsed line to the 2-dimensional string array
                    lines.add(Arrays.asList(values));
                }

                inputStream.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            // the following code lets you iterate through the 2-dimensional array
            int lineNo = 1;
            String[] colNames = {"customerId", "First Name", "Last Name", "Street1", "Street2","City", "State",
                    "Zip","Country", "Phone1", "Phone2", "Phone3","CreateDate"};

            System.out.println(colNames[0]);
            for (List<String> line : lines) {
//                System.out.println("phone # " + line.get(9));
                int columnNo = 1;
                for (String value : line) {
                    System.out.println("Line " + lineNo + " " + colNames[columnNo-1] + ": " + value);
                    if (columnNo == 10) {
                    }
                    columnNo++;
                }
                lineNo++;
            }
        }

    }
}
