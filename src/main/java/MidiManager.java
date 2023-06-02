import javax.sound.midi.*;

/**
 * The MidiManager class handles the MIDI output for the synth player.
 */
public class MidiManager {
    private Synthesizer synthesizer;
    private MidiChannel midiChannel;

    /**
     * Constructs a MidiManager and opens the default synthesizer.
     *
     * @throws MidiUnavailableException if the default synthesizer is unavailable
     */
    public MidiManager() throws MidiUnavailableException {
        synthesizer = MidiSystem.getSynthesizer();
        openMidiDevice();
        midiChannel = synthesizer.getChannels()[0];
    }

    /**
     * Opens the MIDI device and prepares it for use.
     *
     * @throws MidiUnavailableException if the MIDI device is unavailable
     */
    public void openMidiDevice() throws MidiUnavailableException {
        synthesizer.open();
    }

    /**
     * Closes the MIDI device and releases any system resources.
     */
    public void closeMidiDevice() {
        synthesizer.close();
    }

    /**
     * Plays a MIDI note on the specified channel with the given pitch, velocity, and duration.
     *
     * @param channel  the MIDI channel
     * @param pitch    the MIDI note pitch
     * @param velocity the velocity of the note
     * @param duration the duration of the note in milliseconds
     * @throws InvalidMidiDataException if there is an error in the MIDI data
     */
    public void playNote(int channel, int pitch, int velocity, long duration) throws InvalidMidiDataException {
        midiChannel.programChange(0);
        midiChannel.noteOn(pitch, velocity);
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        midiChannel.noteOff(pitch);
    }
}
