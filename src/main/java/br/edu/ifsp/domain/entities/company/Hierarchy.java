package br.edu.ifsp.domain.entities.company;

public enum Hierarchy {
    TRAINEE("Estagiário"),
    JUNIOR("Junior"),
    ENGINEER("Pleno"),
    SENIO("Senior");

    private String label;

    Hierarchy(String label) {
        this.label = label;
    }
}
