package br.edu.ifsp.domain.entities.candidate;

import java.time.LocalDate;

public class ProfessionalExperience {
        private String companyName;
        private LocalDate admissionDate;
        private LocalDate resignationDate;
        private String office;
        private String carriedActivities;

        public ProfessionalExperience() {
        }

        public ProfessionalExperience(String companyName, LocalDate admissionDate, String office, String carriedActivities) {
               this(companyName,admissionDate,null, office,carriedActivities);
        }

        public ProfessionalExperience(String companyName, LocalDate admissionDate, LocalDate resignationDate, String office, String carriedActivities) {
                this.companyName = companyName;
                this.admissionDate = admissionDate;
                this.resignationDate = resignationDate;
                this.office = office;
                this.carriedActivities = carriedActivities;
        }

        public String getCompanyName() {
                return companyName;
        }

        public void setCompanyName(String companyName) {
                this.companyName = companyName;
        }

        public LocalDate getAdmissionDate() {
                return admissionDate;
        }

        public void setAdmissionDate(LocalDate admissionDate) {
                this.admissionDate = admissionDate;
        }

        public LocalDate getResignationDate() {
                return resignationDate;
        }

        public void setResignationDate(LocalDate resignationDate) {
                this.resignationDate = resignationDate;
        }

        public String getOffice() {
                return office;
        }

        public void setOffice(String office) {
                this.office = office;
        }

        public String getCarriedActivities() {
                return carriedActivities;
        }

        public void setCarriedActivities(String carriedActivities) {
                this.carriedActivities = carriedActivities;
        }

        @Override
        public String toString() {
                return "ProfessionalExperience{" +
                        "companyName='" + companyName + '\'' +
                        ", admissionDate=" + admissionDate +
                        ", resignationDate=" + resignationDate +
                        ", office='" + office + '\'' +
                        ", carriedActivities='" + carriedActivities + '\'' +
                        '}';
        }
}
