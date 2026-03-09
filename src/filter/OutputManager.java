package filter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class OutputManager {

    private FileWriter intWriter;
    private FileWriter floatWriter;
    private FileWriter stringWriter;

    private final ArgsParser config;

    public OutputManager(ArgsParser config) {

        this.config = config;

        if (!config.outputDir.isEmpty()) {
            new File(config.outputDir).mkdirs();
        }

    }

    private String path(String name) {

        if (config.outputDir.isEmpty())
            return config.prefix + name;

        return config.outputDir + File.separator + config.prefix + name;

    }

    public void writeInteger(String value) throws IOException {

        if (intWriter == null)
            intWriter = new FileWriter(path("integers.txt"), config.append);

        intWriter.write(value + "\n");

    }

    public void writeFloat(String value) throws IOException {

        if (floatWriter == null)
            floatWriter = new FileWriter(path("floats.txt"), config.append);

        floatWriter.write(value + "\n");

    }

    public void writeString(String value) throws IOException {

        if (stringWriter == null)
            stringWriter = new FileWriter(path("strings.txt"), config.append);

        stringWriter.write(value + "\n");

    }

    public void closeAll() {

        try {

            if (intWriter != null) intWriter.close();
            if (floatWriter != null) floatWriter.close();
            if (stringWriter != null) stringWriter.close();

        } catch (IOException ignored) {}

    }

}