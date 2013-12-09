package GameBase;

import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import GameRes.GameObject;

public class ResourceManager {

	private Parsing parsing;
	private ArrayList<GameObject> objects;

	public ResourceManager() {
		// TODO Auto-generated constructor stub
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
