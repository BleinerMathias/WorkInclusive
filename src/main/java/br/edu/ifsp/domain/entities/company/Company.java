package br.edu.ifsp.domain.entities.company;
import br.edu.ifsp.domain.entities.user.Accessibility;

import java.util.List;

public class Company {
        private String name;
        private String companyName;
        private String sector;
        private String CNPJ;
        private List<String> email;
        private List<String> phone;
        private String address;
        private String postCode;
        private List<Accessibility> accessibilities;
}
