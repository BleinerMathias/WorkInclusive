package br.edu.ifsp.domain.entities.company;

public enum Benefits {

    FOOD_VOUCHER("Vale Alimentação"),
    MEAL_VOUCHER("Vale Refeição"),
    LIFE_INSURANCE("Seguro de Vida"),
    MEDICAL_PLAN("Plano Médico");

    private String label;

    Benefits(String label) {
        this.label = label;
    }
}
