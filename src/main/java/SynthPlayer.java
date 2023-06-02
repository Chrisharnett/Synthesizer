import javax.sound.midi.*;

public class SynthPlayer {
    private MidiDevice midiDevice;
    private MidiChannel[] midiChannels;

    public SynthPlayer() throws MidiUnavailableException {
        midiDevice = MidiSystem.getSynthesizer();
        midiDevice.open();
        if (midiDevice instanceof Synthesizer) {
            Synthesizer synthesizer = (Synthesizer) midiDevice;
            midiChannels = synthesizer.getChannels();
        } else {
            midiChannels = new MidiChannel[0];
        }
    }

    public void setMidiDevice(MidiDevice.Info deviceInfo) throws MidiUnavailableException {
        midiDevice.close();
        midiDevice = MidiSystem.getMidiDevice(deviceInfo);
        midiDevice.open();
        if (midiDevice instanceof Synthesizer) {
            Synthesizer synthesizer = (Synthesizer) midiDevice;
            midiChannels = synthesizer.getChannels();
        } else {
            midiChannels = new MidiChannel[0];
        }
    }

    public void setMidiChannel(int[] channels) {
        for (int i = 0; i < channels.length; i++) {
            if (midiChannels.length > 0) {
                int channelIndex = i % midiChannels.length;
                midiChannels[channelIndex].programChange(channels[i]);
            }
        }
    }


    public void start() {
        // Start playing the MIDI notes or sequence
    }

    public void stop() {
        // Stop playing the MIDI notes or sequence
    }
}
