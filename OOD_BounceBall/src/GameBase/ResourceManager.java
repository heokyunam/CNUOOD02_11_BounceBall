package GameBase;

import java.awt.Graphics;
import java.util.ArrayList;

import GameRes.GameObject;

public class ResourceManager {
	private static ResourceManager manager;
	private Parsing parsing;
	private ArrayList<GameObject> objects;

	private ResourceManager() {
		
	}
	public static ResourceManager getInstance() {
		if(manager == null) manager = new ResourceManager();
		return manager;
	}
	public void draw(Graphics g) {
		for(int i = 0; i < objects.size(); i++)
			objects.get(i).draw(g);
	}

	public void StageParsing(int STAGE) {
		try {
			parsing = new Parsing(STAGE + ".hnl");

			objects = parsing.getGameObjects();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}
