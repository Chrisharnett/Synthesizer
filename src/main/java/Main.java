import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws MidiUnavailableException {
        Scanner scanner = new Scanner(System.in);
        SynthPlayer synthPlayer = new SynthPlayer();

        System.out.println("Welcome to the Generative Synth!");

        // Prompt the user for MIDI device selection
        System.out.println("Available MIDI Devices:");
        MidiDevice.Info[] midiDeviceInfo = MidiSystem.getMidiDeviceInfo();
        for (int i = 0; i < midiDeviceInfo.length; i++) {
            MidiDevice.Info info = midiDeviceInfo[i];
            System.out.println((i + 1) + ". " + info.getName());
        }
        System.out.print("Enter the MIDI device number: ");
        int deviceChoice = scanner.nextInt();

        // Set the selected MIDI device
        synthPlayer.setMidiDevice(deviceChoice - 1);

        // Prompt the user for MIDI channel selection
        System.out.print("Enter the MIDI channels (comma-separated): ");
        scanner.nextLine(); // Consume the newline character
        String input = scanner.nextLine();
        String[] channelStrings = input.split(",");
        int[] midiChannels = new int[channelStrings.length];

        for (int i = 0; i < channelStrings.length; i++) {
            String channelString = channelStrings[i].trim();
            if (!channelString.isEmpty()) {
                try {
                    midiChannels[i] = Integer.parseInt(channelString);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input for MIDI channel: " + channelString);
                    // You can choose to handle the error in different ways, such as asking for input again or setting a default value.
                    // Here, I'll set the MIDI channel to 0 as a default value.
                    midiChannels[i] = 0;
                }
            } else {
                System.out.println("Empty input for MIDI channel");
                // You can choose to handle the error in different ways, such as asking for input again or setting a default value.
                // Here, I'll set the MIDI channel to 0 as a default value.
                midiChannels[i] = 0;
            }
        }

        // Set the MIDI channels
        synthPlayer.setMidiChannel(midiChannels);

        // Start the playback
        synthPlayer.start();

        System.out.println("Generative Synth is now playing!");

        // Wait for user input to stop the playback
        System.out.println("Press Enter to stop the playback...");
        scanner.nextLine();
        scanner.nextLine();

        // Stop the playback
        synthPlayer.stop();

        System.out.println("Playback stopped. Thank you for using the Generative Synth!");
    }
}
