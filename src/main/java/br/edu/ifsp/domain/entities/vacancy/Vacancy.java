package br.edu.ifsp.domain.entities.vacancy;

import br.edu.ifsp.domain.entities.user.Abiliity;
import br.edu.ifsp.domain.entities.user.Accessibility;

public class Vacancy {
    private String name;
    private String description;
    private Hierarchy hierarchy;
    // compatibilidade ?
    private Double Salary;
    private Benefits benefits;
    private Accessibility accessibility;
    private Abiliity abiliity;

}
