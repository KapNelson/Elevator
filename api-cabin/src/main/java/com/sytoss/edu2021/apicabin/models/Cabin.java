package com.sytoss.edu2021.apicabin.models;


//import com.sytoss.edu2021.apiengine.models.Engine;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;


@Getter
@ToString()
public class Cabin {

    private int[] floorButtons;
    @Setter
    private boolean isDoorOpened;
    @Setter
    private boolean isOverloaded;
    //Engine engine;
    List<Integer> queueOfFloors;


    public void addFloorToStop(int floorNumber)
    {
        if(floorNumber < floorButtons[0] || floorNumber > floorButtons[floorButtons.length - 1] || queueOfFloors.contains(floorNumber))
        {
            return;
        }
        else
        {
            queueOfFloors.add(floorNumber);

        }

    }

    private void setFloors(int startFloor,int endFloor) {

        int floorsNumber = endFloor - startFloor + 1;
        floorButtons = new int[floorsNumber];

        int curfloor = startFloor;
        for (int i = 0; i < floorsNumber; i++) {
            floorButtons[i] = curfloor;
            ++curfloor;
        }
    }

    public Cabin(int startFloor,int endFloor) {
        setFloors( startFloor, endFloor);


    }
}



