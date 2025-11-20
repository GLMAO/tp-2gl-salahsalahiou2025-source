package com.polytech.tp;

public class CoursMagistral extends CoursDecorator {
    public CoursMagistral(ICours cours) {
        super(cours);
    }

    @Override
    public String getDescription() {
        return coursDecorated.getDescription() + " (Cours magistral)";
    }

    @Override
    public double getDuree() {
        return coursDecorated.getDuree() + 0.5; // Cours magistral dure 0.5h de plus
    }
}