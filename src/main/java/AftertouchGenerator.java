import java.util.Random;

/**
 * The AftertouchGenerator class generates randomized aftertouch values for MIDI notes.
 */
public class AftertouchGenerator {
    private Random random;

    /**
     * Constructs an AftertouchGenerator.
     */
    public AftertouchGenerator() {
        random = new Random();
    }

    /**
     * Generates a random aftertouch value for a MIDI note within the specified range.
     *
     * @param aftertouchValue the aftertouch value
     * @return the randomly generated aftertouch value
     */
    public int generateAftertouch(int aftertouchValue) {
        return aftertouchValue;
    }

    /**
     * Generates a random aftertouch pattern for a series of MIDI notes within the specified range.
     *
     * @param length         the length of the aftertouch pattern
     * @param minAftertouch  the minimum aftertouch value
     * @param maxAftertouch  the maximum aftertouch value
     * @return an array representing the aftertouch pattern
     * @throws IllegalArgumentException if the length is less than or equal to 0 or the minimum aftertouch is greater than the maximum aftertouch
     */
    public int[] generateAftertouchPattern(int length, int minAftertouch, int maxAftertouch) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length should be greater than 0");
        }
        if (minAftertouch > maxAftertouch) {
            throw new IllegalArgumentException("Minimum aftertouch cannot be greater than maximum aftertouch");
        }

        int[] aftertouchPattern = new int[length];
        for (int i = 0; i < length; i++) {
            aftertouchPattern[i] = random.nextInt(maxAftertouch - minAftertouch + 1) + minAftertouch;
        }
        return aftertouchPattern;
    }
}
