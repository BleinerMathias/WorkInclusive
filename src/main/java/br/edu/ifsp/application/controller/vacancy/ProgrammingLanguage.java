package br.edu.ifsp.application.controller.vacancy;

public class ProgrammingLanguage {
    private String name;

    public ProgrammingLanguage(String name) {
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
