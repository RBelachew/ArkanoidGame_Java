
import java.util.ArrayList;
import java.util.List;

/**
 * Ass6game class contains main function which creates a game object, initializes and runs it.
 */
public class Ass6Game {

    /**
     * Creates a game object, initializes and runs it.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        AnimationRunner animationRunner = new AnimationRunner();
        List<LevelInformation> levelInformations = new ArrayList<>();
        //Checks if there are arguments in the command line and runs the levels according to user choices.
        if (args.length > 0) {
            //Loop which goes over the arguments
            for (int i = 0; i < args.length; i++) {
                if (args[i].equals("1")) {
                    levelInformations.add(new Level1());
                } else if (args[i].equals("2")) {
                    levelInformations.add(new Level2());
                } else if (args[i].equals("3")) {
                    levelInformations.add(new Level3());
                } else if (args[i].equals("4")) {
                    levelInformations.add(new Level4());
                }
            }
        } else {
            //If there are not arguments in the command line it runs the levels in the order
            levelInformations.add(new Level1());
            levelInformations.add(new Level2());
            levelInformations.add(new Level3());
            levelInformations.add(new Level4());
        }

        GameFlow gameFlow = new GameFlow(animationRunner);
        Task<Void> task=new StartGame(gameFlow,levelInformations);
        MenuAnimation<Task<Void>> menuAnimation=new MenuAnimation<>(animationRunner.getKeyboardSensor());
        ShowHiScoresTask showHiScoresTask=new ShowHiScoresTask(animationRunner);
        menuAnimation.addSelection("s","press s",task);
        menuAnimation.addSelection("h","press h",showHiScoresTask);
        final Counter stop=new Counter(0);
        menuAnimation.addSelection("q", "press q", new Task<Void>() {
            @Override
            public Void run() {
                stop.increase(1);
                return null;
            }
        });
        while (stop.getValue()==0){
            animationRunner.run(menuAnimation);
            menuAnimation.getStatus().run();
        }
        animationRunner.getGUI().close();


    }

}
