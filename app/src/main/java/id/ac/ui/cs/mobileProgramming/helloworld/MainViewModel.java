package id.ac.ui.cs.mobileProgramming.helloworld;

import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    private int stateIndex = 0;
    private boolean running = true;
    private final String[] helloWorlds = {"Hello World!", "Halo Dunia!", "Hallo Wereld!", "a!", "b", "c", "d", "e", "f"};

    public String[] getHelloWorlds() {
        return helloWorlds;
    }

    public int getStateIndex() {
        return stateIndex;
    }

    public void setStateIndex(int stateIndex) {
        this.stateIndex = stateIndex;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public boolean getRunning() {
        return running;
    }
}
