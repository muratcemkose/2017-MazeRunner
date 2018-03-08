package gameDynamics;

import initials.Mapping;
import initials.Runner;

public class InputHandler{
	private Runner player;
	private Mapping maze;
	public InputHandler(Runner player, Mapping map) {
		this.setPlayer(player);
		this.setMaze(map);
	}
	// Setters and getters
	public Runner getPlayer() {
		return player;
	}
	public void setPlayer(Runner player) {
		this.player = player;
	}
	public Mapping getMaze() {
		return maze;
	}
	public void setMaze(Mapping maze) {
		this.maze = maze;
	}

}
