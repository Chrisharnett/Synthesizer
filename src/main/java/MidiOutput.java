import javax.sound.midi.*;

/**
 * The MidiOutput class handles the MIDI output for the synth player.
 */
public class MidiOutput {
    private MidiDevice midiDevice;

    /**
     * Constructs a MidiOutput with the specified MIDI device.
     *
     * @param midiDevice the MIDI device to use for output
     * @throws MidiUnavailableException if the MIDI device is unavailable
     */
    public MidiOutput(MidiDevice midiDevice) throws MidiUnavailableException {
        this.midiDevice = midiDevice;
        this.midiDevice.open();
    }

    /**
     * Closes the MIDI output and releases any system resources.
     */
    public void close() {
        midiDevice.close();
    }

    /**
     * Sends a MIDI message to the output device.
     *
     * @param message the MIDI message to send
     * @throws MidiUnavailableException if the MIDI device is unavailable
     * @throws InvalidMidiDataException if there is an error in the MIDI data
     */
    public void sendMidiMessage(MidiMessage message) throws MidiUnavailableException, InvalidMidiDataException {
        if (midiDevice instanceof Receiver) {
            Receiver receiver = (Receiver) midiDevice;
            receiver.send(message, -1);
        }
    }
}
