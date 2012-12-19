package fil;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.IOException;
import java.net.URL;

public class SoundFileHandler {
	
	static SoundFileHandler loader = new SoundFileHandler();
	
	public static AudioClip sound1;
	public static AudioClip sound2;
	
	public static void load() throws IOException{
		sound1=loadSound("sounds/sound1.wav");
		sound2=loadSound("sounds/sound2.wav");
	}
	
	public static AudioClip loadSound(String path) throws IOException {
		AudioClip sound;
		URL url = loader.getClass().getResource(path);
		sound = Applet.newAudioClip(url);
		return sound;
	}

}
