import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
//----------------<<README>>------------------
//object1은 x,y,h,w값을 읽고 object2는 x,y만 읽음
//arraylist에 index 0는 ball data
//예외처리는 심심해서 넣어봄
//--------------------------------------------

public class Parsing {

	// ******내부 사용 상수값 지정*********
	private final int ERROR = -1;
	private final int BALL = 0;
	private final int OBJECT1 = 1;
	private final int OBJECT2 = 2;
	// ****************************

	private ArrayList<Object> objects;
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
		objects = new ArrayList<Object>();
	}

	public ArrayList<Object> getGameObjects() throws Exception {
		this.makeGameObject();
		return objects; // index 0는 ball data
	}

	private String FileRead() { // 라인 한줄 읽어서 리턴
		if (scanner.hasNext()) {
			return scanner.next();
		} else
			return null;
	}

	private void makeGameObject() throws Exception {
		while (true) {
			String readObjectName = this.FileRead();
			if (readObjectName == null) // EOF 처리
				return;

			int n; // NumOfObjects
			switch (CharObjctType(readObjectName)) {

			case OBJECT1: // 4개씩 읽음
				n = Integer.parseInt(this.FileRead());
				for (int i = 0; i < n; i++) {
					TestObject tmp = new TestObject();
					try {
						tmp.setX(Integer.parseInt(FileRead()));
						tmp.setY(Integer.parseInt(FileRead()));
						tmp.setW(Integer.parseInt(FileRead()));
						tmp.setH(Integer.parseInt(FileRead()));
						objects.add(tmp);
					} catch (NumberFormatException e) {
						// TODO: handle exception
						System.out.println("[Error]Invalid Object Error");
						throw e;
					}

				}
				break;

			case OBJECT2: // 2개씩 읽음
				n = Integer.parseInt(this.FileRead());
				for (int i = 0; i < n; i++) {
					try {
						TestObject2 tmp = new TestObject2();
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
			case BALL: // ball data 읽음
				try {
					Ball tmp = new Ball();
					tmp.setX(Integer.parseInt(FileRead()));
					tmp.setY(Integer.parseInt(FileRead()));
					objects.add(0, tmp); // 공정보는 제일 앞에 둔다.
				} catch (NumberFormatException e) {
					// TODO: handle exception
					System.out.println("[Error]Invalid Object Error");
					throw e;
				}
				break;
			case ERROR: // 데이터 Error 발생 시 IOException을 던짐
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
