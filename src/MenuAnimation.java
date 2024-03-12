import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.util.*;

public class MenuAnimation<T> implements Menu<T> {
private Map<String,String> messages=new HashMap<>();
private Dictionary<String,T> returnValues=new Hashtable<>();
private KeyboardSensor keyboardSensor;
private boolean stop=false;
private T status=null;

    public MenuAnimation(KeyboardSensor keyboardSensor){
    this.keyboardSensor=keyboardSensor;
    }
    @Override
    public void addSelection(String key, String message, T returnVal) {
        this.messages.put(key,message);
        this.returnValues.put(key,returnVal);
    }

    @Override
    public T getStatus() {
        this.stop=false;
        return this.status;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        int x=100;
        int y=100;
        for (String key:this.messages.keySet()){
            String message=messages.get(key);
            d.drawText(x,y,message,20);
            if (this.keyboardSensor.isPressed(key)){
                this.stop=true;
                this.status=this.returnValues.get(key);
            }
            y+=50;
        }
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
