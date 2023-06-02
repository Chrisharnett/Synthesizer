import javax.sound.midi.*;

public class SynthPlayer {
    private Synthesizer synthesizer;
    private MidiChannel[] midiChannels;
    private MidiDevice midiOutputDevice;

    public SynthPlayer() throws MidiUnavailableException {
        synthesizer = MidiSystem.getSynthesizer();
        synthesizer.open();
        midiChannels = synthesizer.getChannels();
    }

    public void setScale(int scaleChoice) {
        // Code for setting the scale
    }

    /**
     * Sets the MIDI channels to be used by the SynthPlayer.
     *
     * @param channels the MIDI channels to set
     * @throws IllegalArgumentException if the number of channels exceeds the available channels in the synthesizer
     */
    public void setMidiChannels(int[] channels) {
        if (channels.length > midiChannels.length) {
            throw new IllegalArgumentException("Number of channels exceeds available channels");
        }

        for (int i = 0; i < channels.length; i++) {
            midiChannels[i] = synthesizer.getChannels()[channels[i]];
        }
    }

    public void setMidiOutputDevice(MidiDevice midiOutputDevice) {
        this.midiOutputDevice = midiOutputDevice;
        if (midiOutputDevice != null && midiOutputDevice.isOpen()) {
            closeMidiOutputDevice();
        }
        try {
            midiOutputDevice.open();
        } catch (MidiUnavailableException e) {
            System.out.println("Failed to open MIDI output device: " + e.getMessage());
        }
        if (midiOutputDevice instanceof Synthesizer) {
            synthesizer = (Synthesizer) midiOutputDevice;
            midiChannels = synthesizer.getChannels();
        }
    }


    public void start() {
        // Code for starting the playback
    }

    public void stop() {
        // Code for stopping the playback
    }

    private void closeMidiOutputDevice() {
        if (midiOutputDevice != null && midiOutputDevice.isOpen()) {
            midiOutputDevice.close();
        }
    }
}
