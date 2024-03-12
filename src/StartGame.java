import java.util.List;

public class StartGame implements Task<Void> {
private GameFlow gameFlow;
private List<LevelInformation> listOfLevels;
    public StartGame(GameFlow gameFlow,List<LevelInformation> listOfLevels){
        this.gameFlow=gameFlow;
        this.listOfLevels=listOfLevels;
    }
    @Override
    public Void run() {
        this.gameFlow.runLevels(this.listOfLevels);
        return null;
    }
}
