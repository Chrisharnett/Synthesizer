import java.util.Random;

/**
 * The VelocityGenerator class generates randomized velocities for MIDI notes.
 */
public class VelocityGenerator {
    private Random random;

    /**
     * Constructs a VelocityGenerator.
     */
    public VelocityGenerator() {
        random = new Random();
    }

    /**
     * Generates a random velocity for a MIDI note within the specified range.
     *
     * @param velocityValue the velocity value
     * @return the randomly generated velocity
     */
    public int generateVelocity(int velocityValue) {
        return velocityValue;
    }

    /**
     * Generates a random velocity pattern for a series of MIDI notes within the specified range.
     *
     * @param length       the length of the velocity pattern
     * @param minVelocity  the minimum velocity value
     * @param maxVelocity  the maximum velocity value
     * @return an array representing the velocity pattern
     * @throws IllegalArgumentException if the length is less than or equal to 0 or the minimum velocity is greater than the maximum velocity
     */
    public int[] generateVelocityPattern(int length, int minVelocity, int maxVelocity) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length should be greater than 0");
        }
        if (minVelocity > maxVelocity) {
            throw new IllegalArgumentException("Minimum velocity cannot be greater than maximum velocity");
        }

        int[] velocityPattern = new int[length];
        for (int i = 0; i < length; i++) {
            velocityPattern[i] = random.nextInt(maxVelocity - minVelocity + 1) + minVelocity;
        }
        return velocityPattern;
    }
}
