package br.edu.ifsp.domain.entities.vacancy;

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
}
