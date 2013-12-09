package GameBase;


public class GameManager {

	/*
	 * game start �대┃���ш린��洹몃떎�뚮����ㅽ뻾��
	 */
	// �곸닔 �뺤쓽 怨듦컙
	private final int STAGE_DEFAULT = 1;
	// ------------------------

	private GUI gui;
	private GameKeyListener keyListener;
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
		keyListener = GameKeyListener.getInstance();
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
