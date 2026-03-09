package filter;

public class Main {

    public static void main(String[] args) {

        ArgsParser config = ArgsParser.parse(args);
        if (config == null) {
            System.out.println("Invalid arguments.");
            return;
        }

        FileProcessor processor = new FileProcessor(config);
        processor.process();

    }

}