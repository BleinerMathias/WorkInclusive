package br.edu.ifsp.domain.entities.vacancy;

import br.edu.ifsp.domain.entities.candidate.AcademicDegree;

import java.util.Arrays;

public enum Hierarchy {
    TRAINEE("Estagiário"),
    JUNIOR("Junior"),
    ENGINEER("Pleno"),
    SENIOR("Senior");

    private String label;

    Hierarchy(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }

    public static Hierarchy toEnum(String value){
        return Arrays.stream(Hierarchy.values())
                .filter(c -> value.equals(c.toString()))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }
}
