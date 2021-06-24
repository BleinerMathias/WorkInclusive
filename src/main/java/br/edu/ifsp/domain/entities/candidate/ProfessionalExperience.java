package br.edu.ifsp.domain.entities.candidate;

import java.time.LocalDate;

public class ProfessionalExperience {
        private String companyName;
        private Date admissionDate;
        private Date resignationDate;
        private String office;
        private String carriedActivities;

        public ProfessionalExperience() {
        }

        public ProfessionalExperience(String companyName, Date admissionDate, String office, String carriedActivities) {
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

        public Date getAdmissionDate() {
                return admissionDate;
        }

        public void setAdmissionDate(Date admissionDate) {
                this.admissionDate = admissionDate;
        }

        public Date getResignationDate() {
                return resignationDate;
        }

        public void setResignationDate(Date resignationDate) {
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
