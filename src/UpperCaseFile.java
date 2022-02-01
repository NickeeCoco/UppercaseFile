import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.ArrayList;

public class UpperCaseFile {
    private String filename1;
    private String filename2;

    // Constructor
    public UpperCaseFile(String filename1, String filename2) {
        this.filename1 = filename1;
        this.filename2 = filename2;
    }

    public void processFiles() {
        ArrayList<String> fileContents = readFile(filename1);
        ArrayList<String> processedArray = processToUpper(fileContents);
        writeFile(filename2, processedArray);
    }

    public ArrayList<String> readFile(String filename) {
        try {
            FileReader fr = new FileReader(filename1);
            BufferedReader br = new BufferedReader(fr);

            ArrayList<String> fileContents = new ArrayList<String>();
            String line = br.readLine();

            while(line != null) {
                    fileContents.add(line);
                    line = br.readLine();
            }

            br.close();
            fr.close();

            return fileContents;

        } catch(Exception e) {
            System.out.println(e.getMessage());
            return new ArrayList<String>();
        }
    }

    public ArrayList<String> processToUpper(ArrayList<String> linesArray) {
        ArrayList<String> processedArray = new ArrayList<String>();

        for(String line: linesArray) {
            String processedLine = "";
            for(int letter = 0; letter < line.length(); letter++) {
                char lowerCase = Character.toLowerCase(line.charAt(letter));

                if(lowerCase == 'a'
                        || lowerCase == 'e'
                        || lowerCase == 'i'
                        || lowerCase == 'o'
                        || lowerCase == 'u') {
                    processedLine += Character.toLowerCase(lowerCase);
                } else {
                    processedLine += Character.toUpperCase(line.charAt(letter));
                }
            }
            processedArray.add(processedLine);
        }

        return processedArray;
    }

    public void writeFile(String filename, ArrayList<String> linesList) {
        try {
            FileWriter fw = new FileWriter(filename);
            BufferedWriter bw = new BufferedWriter(fw);

            String contents = "";

            for (String line: linesList) {
                contents += line + "\n";
            }

            bw.write(contents);

            bw.close();
            fw.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
