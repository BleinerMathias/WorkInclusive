package br.edu.ifsp.domain.entities.candidate;

public class Ability {

    private String ability;

    public Ability(String ability) {
        this.ability = ability;
    }

    public Ability() {

    }

    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }

    @Override
    public String toString() {
        return ability;
    }
}
