package com.sytoss.edu2021.repo.dto;

public class Admin {
    private int[] listOfFloors;
    private CabinBOM[] listOfCabins;

    public Admin(){
    }

    public Admin(int numberOfFloors, int numberOfCabins){
        listOfFloors = new int[numberOfFloors];
        listOfCabins = new CabinBOM[numberOfCabins];
    }

    private void emergencyStop(){
    }

    private void emergencyOpenDoor(){
    }

    private void emergencyCloseDoor(){
    }

    private String getInfoAboutCabin(CabinBOM cabin){
        return "status";
    }
}
