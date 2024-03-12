import java.io.File;

public class HighScore {

    public HighScore(){
    }
    public int readHighScore(){
        File file=new File("highScore.txt");
        if (!file.exists()){
            this.wrightHighScore(0);
        }
        FileReaderWriter fileReader=new FileReaderWriter("highScore.txt");
        String content=fileReader.read();
        String number=content.substring(29);
        return Integer.parseInt(number);
    }
    public void wrightHighScore(int newHighScore){
        FileReaderWriter fileReader=new FileReaderWriter("highScore.txt");
        fileReader.wright("The highest score so far is: "+newHighScore);
    }
}
