import java.util.List;
import java.util.Random;

/**
 * The NoteGenerator class generates random notes based on the selected scale.
 */
public class NoteGenerator {
    private Scale scale;
    private Random random;

    /**
     * Constructs a NoteGenerator with the specified scale.
     *
     * @param scale the scale to generate notes from
     */
    public NoteGenerator(Scale scale) {
        this.scale = scale;
        this.random = new Random();
    }

    /**
     * Generates a random note from the selected scale.
     *
     * @return the randomly generated note
     */
    public int generateNote() {
        int[] notes = scale.getNotes();
        int index = random.nextInt(notes.length);
        return notes[index];
    }

    /**
     * Generates a random note pattern for a series of MIDI notes within the specified scale and octave range.
     *
     * @param length       the length of the note pattern
     * @param scale        the scale to generate notes from
     * @param minOctave    the minimum octave value
     * @param maxOctave    the maximum octave value
     * @return an array representing the note pattern
     * @throws IllegalArgumentException if the length is less than or equal to 0 or the minimum octave is greater than the maximum octave
     */
    public int[] generateNotePattern(int length, Scale scale, int minOctave, int maxOctave) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length should be greater than 0");
        }
        if (minOctave > maxOctave) {
            throw new IllegalArgumentException("Minimum octave cannot be greater than maximum octave");
        }

        int[] notes = scale.getNotes();

        int[] notePattern = new int[length];
        for (int i = 0; i < length; i++) {
            int randomNoteIndex = random.nextInt(notes.length);
            int randomOctave = random.nextInt(maxOctave - minOctave + 1) + minOctave;
            notePattern[i] = notes[randomNoteIndex] + (randomOctave * 12);
        }
        return notePattern;
    }


}
