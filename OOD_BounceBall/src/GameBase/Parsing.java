package GameBase;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
//----------------<<README>>------------------
//object1��x,y,h,w媛믪쓣 �쎄퀬 object2��x,y留��쎌쓬
//arraylist��index 0��ball data
//�덉쇅泥섎━���ъ떖�댁꽌 �ｌ뼱遊�//--------------------------------------------







import javax.sound.sampled.Port;

import GameRes.Ball;
import GameRes.FadeWall;
import GameRes.GameObject;
import GameRes.Land;
import GameRes.Needle;
import GameRes.Portal;
import GameRes.Schanze;

public class Parsing {

	// ******�대� �ъ슜 �곸닔媛�吏�젙*********
	private final int ERROR = -1;
	private final int BALL = 0;
	private final int FADEWALL = 1;
	private final int LAND = 2;
	private final int NEEDLE = 3;
	private final int PORTAL = 4;
	private final int SCHANZE = 5;
	// ****************************

	private ArrayList<GameObject> objects;
	private Scanner scanner;
	private BufferedReader bufferedReader;

	public Parsing(String StageFileName) throws FileNotFoundException {
		try {
			bufferedReader = new BufferedReader(new FileReader(StageFileName));
			scanner = new Scanner(bufferedReader);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("[Error]Stage file read Error!!");
			throw e;
		}
		objects = new ArrayList<GameObject>();
	}

	public ArrayList<GameObject> getGameObjects() throws Exception {
		this.makeGameObject();
		return objects; // index 0��ball data
	}

	private String FileRead() { // �쇱씤 �쒖쨪 �쎌뼱��由ы꽩
		if (scanner.hasNext()) {
			return scanner.next();
		} else
			return null;
	}

	private void makeGameObject() throws Exception {
		while (true) {
			String readObjectName = this.FileRead();
			if (readObjectName == null) // EOF 泥섎━
				return;

			int n; // NumOfObjects
			switch (CharObjctType(readObjectName)) {

			case FADEWALL: // 4媛쒖뵫 �쎌쓬
				n = Integer.parseInt(this.FileRead());
				for (int i = 0; i < n; i++) {
					FadeWall tmp = new FadeWall();
					try {
						tmp.setX(Integer.parseInt(FileRead()));
						tmp.setY(Integer.parseInt(FileRead()));
						tmp.setWidth(Integer.parseInt(FileRead()));
						tmp.setHeight(Integer.parseInt(FileRead()));
						objects.add(tmp);
					} catch (NumberFormatException e) {
						// TODO: handle exception
						System.out.println("[Error]Invalid Object Error");
						throw e;
					}

				}
				break;
			case LAND: // 4媛쒖뵫 �쎌쓬
				n = Integer.parseInt(this.FileRead());
				for (int i = 0; i < n; i++) {
					Land tmp = new Land();
					try {
						tmp.setX(Integer.parseInt(FileRead()));
						tmp.setY(Integer.parseInt(FileRead()));
						tmp.setWidth(Integer.parseInt(FileRead()));
						tmp.setHeight(Integer.parseInt(FileRead()));
						objects.add(tmp);
					} catch (NumberFormatException e) {
						// TODO: handle exception
						System.out.println("[Error]Invalid Object Error");
						throw e;
					}

				}
				break;
			case NEEDLE: // 4媛쒖뵫 �쎌쓬
				n = Integer.parseInt(this.FileRead());
				for (int i = 0; i < n; i++) {
					Needle tmp = new Needle();
					try {
						tmp.setX(Integer.parseInt(FileRead()));
						tmp.setY(Integer.parseInt(FileRead()));
						tmp.setWidth(Integer.parseInt(FileRead()));
						tmp.setHeight(Integer.parseInt(FileRead()));
						objects.add(tmp);
					} catch (NumberFormatException e) {
						// TODO: handle exception
						System.out.println("[Error]Invalid Object Error");
						throw e;
					}

				}
				break;
			case PORTAL: // 4媛쒖뵫 �쎌쓬
				n = Integer.parseInt(this.FileRead());
				for (int i = 0; i < n; i++) {
					Portal tmp = new Portal();
					try {
						tmp.setX(Integer.parseInt(FileRead()));
						tmp.setY(Integer.parseInt(FileRead()));
						tmp.setWidth(Integer.parseInt(FileRead()));
						tmp.setHeight(Integer.parseInt(FileRead()));
						objects.add(tmp);
					} catch (NumberFormatException e) {
						// TODO: handle exception
						System.out.println("[Error]Invalid Object Error");
						throw e;
					}

				}
				break;
			case SCHANZE: // 4媛쒖뵫 �쎌쓬
				n = Integer.parseInt(this.FileRead());
				for (int i = 0; i < n; i++) {
					Schanze tmp = new Schanze();
					try {
						tmp.setX(Integer.parseInt(FileRead()));
						tmp.setY(Integer.parseInt(FileRead()));
						tmp.setWidth(Integer.parseInt(FileRead()));
						tmp.setHeight(Integer.parseInt(FileRead()));
						objects.add(tmp);
					} catch (NumberFormatException e) {
						// TODO: handle exception
						System.out.println("[Error]Invalid Object Error");
						throw e;
					}

				}
				break;
			case BALL: // ball data �쎌쓬
				try {
					Ball tmp = Ball.getInstance();
					tmp.setX(Integer.parseInt(FileRead()));
					tmp.setY(Integer.parseInt(FileRead()));
					objects.add(0, tmp); // 怨듭젙蹂대뒗 �쒖씪 �욎뿉 �붾떎.
				} catch (NumberFormatException e) {
					// TODO: handle exception
					System.out.println("[Error]Invalid Object Error");
					throw e;
				}
				break;
			case ERROR: // �곗씠��Error 諛쒖깮 ��IOException���섏쭚
				System.out.println("[Error]Invalid Object Error");
				throw new IOException();
			}
		}
	}

	private int CharObjctType(String ObjectName) {
		switch (ObjectName) {
		case "FadeWall":
			return FADEWALL;
		case "Land":
			return LAND;
		case "Needle":
			return NEEDLE;
		case "Portal":
			return PORTAL;
		case "Schanze":
			return SCHANZE;
		case "Ball":
			return BALL;
		default:
			return ERROR;
		}
	}
}
