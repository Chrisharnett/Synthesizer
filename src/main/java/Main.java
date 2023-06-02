import javax.sound.midi.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            SynthPlayer synthPlayer = new SynthPlayer();

            System.out.println("Welcome to the Generative Synth!");

            // Prompt the user for MIDI device selection
            MidiDevice.Info[] midiDeviceInfo = MidiSystem.getMidiDeviceInfo();
            System.out.println("Available MIDI devices:");
            for (int i = 0; i < midiDeviceInfo.length; i++) {
                System.out.println((i + 1) + ". " + midiDeviceInfo[i].getName());
            }
            System.out.print("Select the MIDI device: ");
            int deviceChoice = new Scanner(System.in).nextInt();

            // Set the selected MIDI device
            MidiDevice.Info selectedDeviceInfo = midiDeviceInfo[deviceChoice - 1];
            synthPlayer.setMidiDevice(selectedDeviceInfo);

            // Prompt the user for MIDI channel selection
            System.out.print("Enter the MIDI channels (comma-separated): ");
            String input = new Scanner(System.in).nextLine();
            String[] channelStrings = input.split(",");
            int[] midiChannels = new int[channelStrings.length];

            for (int i = 0; i < channelStrings.length; i++) {
                midiChannels[i] = Integer.parseInt(channelStrings[i].trim());
            }

            // Set the MIDI channels
            synthPlayer.setMidiChannel(midiChannels);

            // Start the playback
            synthPlayer.start();

            System.out.println("Generative Synth is now playing!");

            // Wait for user input to stop the playback
            System.out.println("Press Enter to stop the playback...");
            new Scanner(System.in).nextLine();

            // Stop the playback
            synthPlayer.stop();

            System.out.println("Playback stopped. Thank you for using the Generative Synth!");
        } catch (MidiUnavailableException e) {
            System.out.println("MIDI is unavailable.");
        }
    }
}
