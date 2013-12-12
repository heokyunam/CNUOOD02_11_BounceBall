package GameBase;


public class GameManager {

	/*
	 * game start �대┃���ш린��洹몃떎�뚮����ㅽ뻾��
	 */
	// �곸닔 �뺤쓽 怨듦컙
	// ------------------------

	private GUI gui;
	private GameThread gameThread = new GameThread();
	private ResourceManager manager = ResourceManager.getInstance();
	private static int CurrStage = 1;
	private static GameManager instance;
	private GameManager() {

	}

	public static GameManager getInstance() {
		if(instance == null)
			return instance = new GameManager();
		return instance;
	}

	public void start() {
		init();
	}
	private void init() { // 泥섏쓬 �쒕쾲 珥덇린�붿슜
		gui = GUI.getInstance();
	}
	public void first() {
		CurrStage = 1;
		manager.allClear();
		manager.StageParsing(CurrStage);
		manager.allClear();
	}
	public void next() {
		CurrStage++;
		manager.allClear();
		manager.StageParsing(CurrStage);
		manager.allClear();
	}

	public void GameRun() { // game start button click
		// parsing
		first();
		// thread run
		gameThread.ThreadStart();
	}
}
