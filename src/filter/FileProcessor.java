package filter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileProcessor {

    private final ArgsParser config;
    private final Statistics stats = new Statistics();
    private final OutputManager output;

    public FileProcessor(ArgsParser config) {
        this.config = config;
        this.output = new OutputManager(config);
    }

    public void process() {

        for (String path : config.inputFiles) {

            try (BufferedReader reader = new BufferedReader(new FileReader(path))) {

                String line;

                while ((line = reader.readLine()) != null) {

                    if (isInteger(line)) {

                        long value = Long.parseLong(line);
                        output.writeInteger(line);
                        stats.addInteger(value);

                    } else if (isFloat(line)) {

                        double value = Double.parseDouble(line);
                        output.writeFloat(line);
                        stats.addFloat(value);

                    } else {

                        output.writeString(line);
                        stats.addString(line);

                    }

                }

            } catch (IOException e) {

                System.out.println("Error processing file: " + path);

            }

        }

        output.closeAll();
        stats.print(config.shortStat, config.fullStat);

    }

    private boolean isInteger(String s) {

        try {
            Long.parseLong(s);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    private boolean isFloat(String s) {

        try {
            Double.parseDouble(s);
            return s.contains(".") || s.contains("E") || s.contains("e");
        } catch (Exception e) {
            return false;
        }

    }

}