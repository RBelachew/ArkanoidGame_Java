import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileReaderWriter {
    private String path;
    public FileReaderWriter(String path){
        this.path=path;
    }
    public String read(){
        try {
            FileInputStream fileInputStream=new FileInputStream(this.path);
            int i=0;
            StringBuilder stringBuilder=new StringBuilder();
            while ((i=fileInputStream.read())!=-1){
                stringBuilder.append((char)i);
            }
            fileInputStream.close();
            return stringBuilder.toString();
        }catch (Exception e){
            System.out.println("Faild to read!");
            return null;
        }
    }


    public void wright(String content){
        try {
            FileOutputStream fileOutputStream=new FileOutputStream(this.path);
            fileOutputStream.write(content.getBytes());
            fileOutputStream.close();
        }catch (Exception e){
            System.out.println("Faild to wright!");
        }
    }

}
