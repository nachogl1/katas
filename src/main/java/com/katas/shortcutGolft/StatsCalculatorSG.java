package com.katas.shortcutGolft;

public class StatsCalculatorSG {

    public String getLengthOf(int[] samples) {
        return ""+samples.length;
    }

    public String returnMaxOf(int[] samples) {
        if (samples.length == 0) return "Empty";

        int max = samples[0];
        for (int sample : samples) {
            max = max > sample ? max : sample;
        }
        return String.valueOf(max);
    }

    public String returnMinOf(int[] samples) {
        if (samples.length == 0) return "Empty";

        int min = samples[0];

        for (int sample : samples) {
            min = min < sample ? min : sample;
        }

        return String.valueOf(min);
    }

    public String averageOf(int[] samples) {
        if (samples.length == 0) return "Empty";
        int average = 0;
        for (int sample : samples) {
            average += sample;
        }
        return String.valueOf(Math.floorDiv(average, samples.length));
    }

    public String generateStats(int[] samples) {
        return "" + "Max: " + returnMaxOf(samples) + "/n" + "Min: " + returnMinOf(samples) + "/n" + "Length: " + getLengthOf(samples) + "/n" + "Average : " + averageOf(samples);
    }
}
