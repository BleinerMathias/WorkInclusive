package br.edu.ifsp.domain.entities.candidate;

import java.util.Objects;

public class ProgammingLanguage {
    private Integer id;
    private String name;

    public ProgammingLanguage() {
    }

    public ProgammingLanguage(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProgammingLanguage progammingLanguage = (ProgammingLanguage) o;
        return Objects.equals(name, progammingLanguage.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
