import java.util.Random;

/**
 * The RhythmGenerator class generates random rhythms.
 */
public class RhythmGenerator {
    private Random random;

    /**
     * Constructs a RhythmGenerator.
     */
    public RhythmGenerator() {
        this.random = new Random();
    }

    /**
     * Generates a random rhythm value.
     *
     * @return the randomly generated rhythm value
     */
    public double generateRhythmValue() {
        return random.nextDouble();
    }

    /**
     * Generates a random rhythm pattern.
     *
     * @param length the length of the rhythm pattern
     * @return an array representing the rhythm pattern
     */
    public double[] generateRhythmPattern(int length) {
        double[] pattern = new double[length];
        for (int i = 0; i < length; i++) {
            pattern[i] = generateRhythmValue();
        }
        return pattern;
    }
}
