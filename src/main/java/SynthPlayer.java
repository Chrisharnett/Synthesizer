import javax.sound.midi.*;

public class SynthPlayer {
    private Synthesizer synth;
    private MidiChannel[] midiChannels;
    private Transmitter midiInputTransmitter;
    private Receiver midiOutputReceiver;

    public SynthPlayer() throws MidiUnavailableException {
        synth = MidiSystem.getSynthesizer();
        midiChannels = synth.getChannels();
    }

    public void setMidiOutputPort(int portIndex) throws MidiUnavailableException {
        MidiDevice.Info[] midiDeviceInfo = MidiSystem.getMidiDeviceInfo();
        if (portIndex >= 0 && portIndex < midiDeviceInfo.length) {
            MidiDevice.Info info = midiDeviceInfo[portIndex];
            MidiDevice device = MidiSystem.getMidiDevice(info);
            if (device.getMaxTransmitters() != 0) {
                midiOutputReceiver = device.getReceiver();
            } else {
                throw new IllegalArgumentException("Selected device does not have an output port");
            }
        } else {
            throw new IllegalArgumentException("Invalid port index");
        }
    }

    public void start() throws MidiUnavailableException {
        synth.open();
        if (midiOutputReceiver != null) {
            midiInputTransmitter = synth.getTransmitter();
            midiInputTransmitter.setReceiver(midiOutputReceiver);
        }
    }

    public void stop() {
        if (midiInputTransmitter != null) {
            midiInputTransmitter.close();
            midiInputTransmitter = null;
        }
        if (midiOutputReceiver != null) {
            midiOutputReceiver.close();
            midiOutputReceiver = null;
        }
        synth.close();
    }

    // Rest of the class methods...
}
