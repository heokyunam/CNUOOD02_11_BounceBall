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


import GameRes.Ball;
import GameRes.GameObject;

public class Parsing {

	// ******�대� �ъ슜 �곸닔媛�吏�젙*********
	private final int ERROR = -1;
	private final int BALL = 0;
	private final int OBJECT1 = 1;
	private final int OBJECT2 = 2;
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

			case OBJECT1: // 4媛쒖뵫 �쎌쓬
				n = Integer.parseInt(this.FileRead());
				for (int i = 0; i < n; i++) {
					Ball tmp = new Ball(); //
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

			case OBJECT2: // 2媛쒖뵫 �쎌쓬
				n = Integer.parseInt(this.FileRead());
				for (int i = 0; i < n; i++) {
					try {
						Ball tmp = new Ball(); //
						tmp.setX(Integer.parseInt(FileRead()));
						tmp.setY(Integer.parseInt(FileRead()));
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
					Ball tmp = new Ball();
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
		case "TestObject":
			return OBJECT1;
		case "TestObject2":
			return OBJECT2;
		case "Ball":
			return BALL;
		default:
			return ERROR;
		}
	}
}
