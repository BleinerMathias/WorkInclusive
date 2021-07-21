package br.edu.ifsp.domain.entities.candidate;

import java.util.Arrays;

public enum AcademicDegree {

    TECHNOLOSIT("Tecnólogo"),
    BACHELOR_DEGREE("Bacharelado"),
    GRADUATION("Licentiarua"),
    SPECIALIZATION("Especialização"),
    MASTER_DEGREE("Mestrado"),
    DOCTORATE_DEGREE("Doutorado");

    private String label;

    AcademicDegree(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }

    public static AcademicDegree toEnum(String value){
        return Arrays.stream(AcademicDegree.values())
                .filter(c -> value.equals(c.toString()))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }
}
