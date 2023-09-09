package _05_cow_timer;

import game_tools.Sound;

/*
 * Objective: Create a Cow Count Down program!
 * 
 * In this class:
 * 1. Make a constructor for the CowTimer class that initializes the seconds
 *    variable.
 * 
 * 2. In the start() method, count down the seconds, print the current second,
 *    then sleep for the number of seconds using Thread.sleep(int milliseconds).
 *    For example, if the count down seconds is 10, the console should print
 *    the remaining seconds with a 1 second delay between each print:
 *    10
 *    9
 *    8
 *    ...
 * 
 * 3. After the timer is finished, use the playSound() method to play a moo
 *    sound. You can use "moo.wav" as the sound file.
 * 
 * In the CowTimerRunner class:
 * Complete the main method
 */
public class CowTimer {
	
	public CowTimer(int seconds) {
		setTime(seconds);
	}
    private int seconds;

    public void setTime(int seconds) {
        this.seconds = seconds;
        System.out.println("Cow time set to " + this.seconds + " seconds.");
    }

    public void start() throws InterruptedException {
        while (seconds > 0) {
        	System.out.println(seconds);
        	Thread.sleep(1000);
        	seconds--;
        }
        playSound("moo.wav");
    }

    public void playSound(final String file) {
        String fileName = "_05_cow_timer/" + file;
        Sound sound = new Sound(fileName);
        sound.play();
    }
}
