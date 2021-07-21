package br.edu.ifsp.domain.entities.vacancy;

import br.edu.ifsp.domain.entities.candidate.AcademicDegree;

import java.util.Arrays;

public enum Accessibility {

    // Fisic deficient
    VISUAL_DEFICIENT("Deficiente visual"),
    FISIC_DEFICIENT("Deficiente físico"),
    HEARING_DEFICIENT("Deficiente auditivo");

    private String label;

    Accessibility(String label) {
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

    public static Accessibility toEnum(String value){
        return Arrays.stream(Accessibility.values())
                .filter(c -> value.equals(c.toString()))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }
}
