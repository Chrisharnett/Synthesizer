import java.util.ArrayList;
import java.util.List;

/**
 * The ChannelManager class manages the MIDI channels used by the synth player.
 */
public class ChannelManager {
    private List<Integer> channels;

    /**
     * Constructs a ChannelManager with no assigned channels.
     */
    public ChannelManager() {
        channels = new ArrayList<>();
    }


    /**
     * Adds a MIDI channel to the manager.
     *
     * @param channel the MIDI channel to add
     * @throws IllegalArgumentException if the channel is already assigned
     */
    public void addChannel(int channel) {
        if (channels.contains(channel)) {
            throw new IllegalArgumentException("Channel " + channel + " is already assigned");
        }
        channels.add(channel);
    }

    /**
     * Removes a MIDI channel from the manager.
     *
     * @param channel the MIDI channel to remove
     * @throws IllegalArgumentException if the channel is not assigned
     */
    public void removeChannel(int channel) {
        if (!channels.contains(channel)) {
            throw new IllegalArgumentException("Channel " + channel + " is not assigned");
        }
        channels.remove(Integer.valueOf(channel));
    }

    /**
     * Clears all assigned MIDI channels from the manager.
     */
    public void clearChannels() {
        channels.clear();
    }

    /**
     * Returns the list of assigned MIDI channels.
     *
     * @return the list of assigned MIDI channels
     */
    public List<Integer> getChannels() {
        return channels;
    }
}
