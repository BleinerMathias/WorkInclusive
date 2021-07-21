package br.edu.ifsp.domain.entities.vacancy;

import br.edu.ifsp.domain.entities.candidate.AcademicDegree;

import java.util.Arrays;

public enum StatusVacancy {
    AVAILABLE("Disponivel"),
    UNAVAILABLE("Indisponivel");

    private String label;

    StatusVacancy(String label) {
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

    public static StatusVacancy toEnum(String value){
        return Arrays.stream(StatusVacancy.values())
                .filter(c -> value.equals(c.toString()))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }
}
