package com.sytoss.edu2021.models;

import lombok.Getter;

import java.util.List;

@Getter
public class Cabin {
    private List<Integer> floorsButtons;
    private boolean isDoorsOpen;
    private boolean isOverload;
}
