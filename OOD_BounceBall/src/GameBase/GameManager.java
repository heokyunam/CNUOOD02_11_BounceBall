package GameBase;


public class GameManager {

	/*
	 * game start 클릭시 여기서 그다음부터 실행됨
	 */
	// 상수 정의 공간
	private final int STAGE_DEFAULT = 1;
	// ------------------------

	private GUI gui;
	private KeyListener keyListener;
	private GameThread gameThread = new GameThread();
	private ResourceManager manager = new ResourceManager();
	private static int CurrStage;
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

	private void init() { // 처음 한번 초기화용
		keyListener = KeyListener.getInstance();
		CurrStage = STAGE_DEFAULT;
		gui = GUI.getInstance();
	}

	private void StageParsing() {
		manager.StageParsing(CurrStage);
		CurrStage++;
		
	}

	public void GameRun() { // game start button click
		// parsing
		StageParsing();
		// thread run
		gameThread.ThreadStart();
	}
}
