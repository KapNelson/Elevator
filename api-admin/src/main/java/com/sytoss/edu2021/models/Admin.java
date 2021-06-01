package com.sytoss.edu2021.models;

public class Admin {
    private int[] listOfFloors;
    private Object[] listOfCabins;

    public Admin(){
    }

    public Admin(int numberOfFloors, int numberOfCabins){
        listOfFloors = new int[numberOfFloors];
        listOfCabins = new Object[numberOfCabins];
    }

    private void emergencyStop(){
    }

    private void emergencyOpenDoor(){
    }

    private void emergencyCloseDoor(){
    }
    private String getInfoAboutCabin(Object Cabine){
        return "status";
    }
}
