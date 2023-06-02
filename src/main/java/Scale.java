/**
 * The Scale class represents a musical scale with a specific set of notes.
 */
public class Scale {
    private int[] notes;

    /**
     * Constructs a Scale object based on the specified scale type.
     *
     * @param scaleType the scale type
     */
    public Scale(ScaleType scaleType) {
        notes = generateNotes(scaleType);
    }

    /**
     * Generates the notes for the given scale type.
     *
     * @param scaleType the scale type
     * @return an array of notes representing the scale
     */
    private int[] generateNotes(ScaleType scaleType) {
        switch (scaleType) {
            case CHROMATIC:
                return new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
            case MAJOR:
                return new int[]{0, 2, 4, 5, 7, 9, 11};
            case MINOR:
                return new int[]{0, 2, 3, 5, 7, 8, 10};
            case DIMINISHED:
                return new int[]{0, 2, 3, 5, 6, 8, 9, 11};
            case WHOLE_TONE:
                return new int[]{0, 2, 4, 6, 8, 10};
            default:
                throw new IllegalArgumentException("Invalid scale type.");
        }
    }

    /**
     * Returns the notes of the scale.
     *
     * @return an array of notes representing the scale
     */
    public int[] getNotes() {
        return notes;
    }

    /**
     * Returns the MIDI note value for the given scale degree.
     *
     * @param degree the scale degree
     * @return the MIDI note value
     */
    public int getMidiNoteByValue(int degree) {
        int noteIndex = degree % notes.length;
        return notes[noteIndex];
    }

    /**
     * The ScaleType enumeration represents different types of scales.
     */
    public enum ScaleType {
        CHROMATIC,
        MAJOR,
        MINOR,
        DIMINISHED,
        WHOLE_TONE
    }
}
