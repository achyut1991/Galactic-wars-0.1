/**
 * Author : Sesha Sendhil Subramanian
 * Purpose : Adding sound for the game
 */
import java.io.*;
import javax.sound.midi.*;

public class MidiSound {
	private static Sequencer midiPlayer;
	
	/**
	 * Ivokes the playing of the song
	 * @param startSound True if song is to be played and false if song to be muted
	 */

	public static void playSound(boolean startSound) {
		if (startSound == true) {
			startMidi("./aliens.mid"); // start the midi player
		}
		else{
			midiPlayer.stop();
			midiPlayer.close();
		}


	}
	
	/**
	 * Plays the specified song
	 * @param midFilename The filename of the song to be played
	 */

	public static void startMidi(String midFilename) {
		try {
			File midiFile = new File(midFilename);
			Sequence song = MidiSystem.getSequence(midiFile);
			midiPlayer = MidiSystem.getSequencer();
			midiPlayer.open();
			midiPlayer.setSequence(song);
			midiPlayer.setLoopCount(10); // repeat 0 times (play once)
			midiPlayer.start();
		} catch (MidiUnavailableException e) {
			e.printStackTrace();
		} catch (InvalidMidiDataException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
