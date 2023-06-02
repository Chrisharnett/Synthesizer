import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;
import java.util.List;

public class SynthPlayer {
    private Scale scale;
    private MidiManager midiManager;
    private RhythmGenerator rhythmGenerator;
    private NoteGenerator noteGenerator;
    private VelocityGenerator velocityGenerator;
    private AftertouchGenerator aftertouchGenerator;
    private ChannelManager channelManager;

    public SynthPlayer() {
        this.scale = null;
        this.midiManager = null;
        this.noteGenerator = null;
        this.rhythmGenerator = null;
        this.velocityGenerator = null;
        this.aftertouchGenerator = null;
        this.channelManager = null;
    }

    public void start() throws MidiUnavailableException {
        // Logic to start playing the synthesizer
        if (midiManager != null) {
            midiManager.openMidiDevice();
        }
    }

    public void stop() {
        // Logic to stop playing the synthesizer
        if (midiManager != null) {
            midiManager.closeMidiDevice();
        }
    }

    public void setScale(int scaleChoice) {
        Scale scale;
        switch (scaleChoice) {
            case 1:
                scale = new Scale(Scale.ScaleType.CHROMATIC);
                break;
            case 2:
                scale = new Scale(Scale.ScaleType.MAJOR);
                break;
            case 3:
                scale = new Scale(Scale.ScaleType.MINOR);
                break;
            case 4:
                scale = new Scale(Scale.ScaleType.DIMINISHED);
                break;
            case 5:
                scale = new Scale(Scale.ScaleType.WHOLE_TONE);
                break;
            default:
                throw new IllegalArgumentException("Invalid scale choice.");
        }
        this.scale = scale;
    }

    public void play(List<Double> rhythmPattern, List<Integer> notePattern,
                     List<Integer> velocityPattern, List<Integer> aftertouchPattern) {
        // Validate patterns
        if (rhythmPattern.isEmpty() || notePattern.isEmpty() ||
                velocityPattern.isEmpty() || aftertouchPattern.isEmpty()) {
            throw new IllegalArgumentException("Empty patterns are not allowed.");
        }

        // Iterate through the patterns and play the notes
        for (int i = 0; i < rhythmPattern.size(); i++) {
            double rhythmValue = rhythmPattern.get(i);
            int noteValue = notePattern.get(i);
            int velocityValue = velocityPattern.get(i);
            int aftertouchValue = aftertouchPattern.get(i);

            int midiNote = scale.getMidiNoteByValue(noteValue);
            int midiVelocity = velocityGenerator.generateVelocity(velocityValue);
            int midiAftertouch = aftertouchGenerator.generateAftertouch(aftertouchValue);

            // Play the note using the MIDI manager
            if (midiManager != null) {
                try {
                    midiManager.playNote(midiNote, midiVelocity, midiAftertouch, (long) (rhythmValue * 1000));
                } catch (InvalidMidiDataException e) {
                    e.printStackTrace();
                }
            }

            // Wait for the specified duration
            try {
                Thread.sleep((long) (rhythmValue * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void setMidiChannel(int[] midiChannels) {
        if (channelManager != null) {
            for (int channel : midiChannels) {
                try {
                    channelManager.addChannel(channel);
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
