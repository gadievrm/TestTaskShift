package filter;

public class Statistics {

    long intCount;
    long floatCount;
    long stringCount;

    long intSum;
    double floatSum;

    Long intMin;
    Long intMax;

    Double floatMin;
    Double floatMax;

    Integer minStrLen;
    Integer maxStrLen;

    public void addInteger(long v) {

        intCount++;
        intSum += v;

        if (intMin == null || v < intMin) intMin = v;
        if (intMax == null || v > intMax) intMax = v;

    }

    public void addFloat(double v) {

        floatCount++;
        floatSum += v;

        if (floatMin == null || v < floatMin) floatMin = v;
        if (floatMax == null || v > floatMax) floatMax = v;

    }

    public void addString(String s) {

        stringCount++;

        int len = s.length();

        if (minStrLen == null || len < minStrLen) minStrLen = len;
        if (maxStrLen == null || len > maxStrLen) maxStrLen = len;

    }

    public void print(boolean shortStat, boolean fullStat) {

        if (shortStat) {

            System.out.println("Integers: " + intCount);
            System.out.println("Floats: " + floatCount);
            System.out.println("Strings: " + stringCount);

        }

        if (fullStat) {

            System.out.println("Integers:");
            System.out.println("count = " + intCount);
            if (intCount > 0) {
                System.out.println("min = " + intMin);
                System.out.println("max = " + intMax);
                System.out.println("sum = " + intSum);
                System.out.println("avg = " + (double) intSum / intCount);
            }

            System.out.println("\nFloats:");
            System.out.println("count = " + floatCount);
            if (floatCount > 0) {
                System.out.println("min = " + floatMin);
                System.out.println("max = " + floatMax);
                System.out.println("sum = " + floatSum);
                System.out.println("avg = " + floatSum / floatCount);
            }

            System.out.println("\nStrings:");
            System.out.println("count = " + stringCount);
            if (stringCount > 0) {
                System.out.println("shortest length = " + minStrLen);
                System.out.println("longest length = " + maxStrLen);
            }

        }

    }

}