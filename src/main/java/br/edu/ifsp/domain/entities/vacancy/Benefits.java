package br.edu.ifsp.domain.entities.vacancy;

import br.edu.ifsp.domain.entities.candidate.AcademicDegree;

import java.util.Arrays;

public enum Benefits {

    NONE("Nenhum"),
    FOOD_VOUCHER("Vale Alimentação"),
    MEAL_VOUCHER("Vale Refeição"),
    LIFE_INSURANCE("Seguro de Vida"),
    MEDICAL_PLAN("Plano Médico");

    private String label;

    Benefits(String label) {
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

    public static Benefits toEnum(String value){
        return Arrays.stream(Benefits.values())
                .filter(c -> value.equals(c.toString()))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }
}
