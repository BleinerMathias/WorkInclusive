package br.edu.ifsp.domain.entities.vacancy;

public enum StatusVacancy {
    AVAILABLE("Disponivel"),
    UNAVAILABLE("Indisponivel");

    private String label;

    StatusVacancy(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}