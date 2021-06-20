package br.edu.ifsp.domain.entities.candidate;

public enum AcademicDegree {

    TECHNOLOSIT("Tecnólogo"),
    BACHELOR_DEGREE("Bacharelado"),
    GRADUATION("Licentiarua"),
    SPECIALIZATION("Especialização"),
    MASTER_DEGREE("Mestrado"),
    DOCTORATE_DEGREE("Doutorado");

    private String label;

    AcademicDegree(String label) {
        this.label = label;
    }
}
