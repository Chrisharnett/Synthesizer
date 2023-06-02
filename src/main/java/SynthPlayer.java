import javax.sound.midi.*;

public class SynthPlayer {
    private Synthesizer synthesizer;
    private MidiChannel[] midiChannels;

    public SynthPlayer() throws MidiUnavailableException {
        synthesizer = MidiSystem.getSynthesizer();
        synthesizer.open();
        midiChannels = synthesizer.getChannels();
    }

    public void setMidiDevice(MidiDevice.Info deviceInfo) throws MidiUnavailableException {
        MidiDevice midiDevice = MidiSystem.getMidiDevice(deviceInfo);
        if (midiDevice instanceof Synthesizer) {
            synthesizer = (Synthesizer) midiDevice;
            synthesizer.open();
            midiChannels = synthesizer.getChannels();
        } else {
            throw new IllegalArgumentException("Selected device is not a Synthesizer");
        }
    }

    public void setMidiChannel(int[] channels) {
        for (int i = 0; i < channels.length; i++) {
            int channelIndex = i % midiChannels.length;
            midiChannels[channelIndex].programChange(channels[i]);
        }
    }

    public void start() {
        // Start playing the MIDI notes or sequence
    }

    public void stop() {
        // Stop playing the MIDI notes or sequence
    }
}
