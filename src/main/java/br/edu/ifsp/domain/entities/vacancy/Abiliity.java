package br.edu.ifsp.domain.entities.vacancy;

public class Abiliity {

    private String name;

    public Abiliity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
