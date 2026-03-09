package filter;

import java.util.ArrayList;
import java.util.List;

public class ArgsParser {

    String outputDir = "";
    String prefix = "";
    boolean append = false;
    boolean shortStat = false;
    boolean fullStat = false;

    List<String> inputFiles = new ArrayList<>();

    public static ArgsParser parse(String[] args) {

        ArgsParser config = new ArgsParser();

        int i = 0;

        while (i < args.length) {

            switch (args[i]) {

                case "-o":
                    if (i + 1 >= args.length) return null;
                    config.outputDir = args[i + 1];
                    i += 2;
                    break;

                case "-p":
                    if (i + 1 >= args.length) return null;
                    config.prefix = args[i + 1];
                    i += 2;
                    break;

                case "-a":
                    config.append = true;
                    i++;
                    break;

                case "-s":
                    config.shortStat = true;
                    i++;
                    break;

                case "-f":
                    config.fullStat = true;
                    i++;
                    break;

                default:
                    config.inputFiles.add(args[i]);
                    i++;
            }
        }

        return config;
    }

}