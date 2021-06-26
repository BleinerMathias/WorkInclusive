package br.edu.ifsp.domain.entities.vacancy;

public enum Abiliity {


    UI_UX("UI/UX"),
    Mysql("Mysql"),
    MongoDB("MongoDB"),
    OracleDB("OracleDb"),
    SQL_server("SQL server"),
    PostgreSQL("PostgreSQL"),
    Python("Python"),
    Flask("Flask"),
    Java("Java"),
    Cplus_plus("C++"),
    CSharp("C#"),
    PHP("PHP"),
    DOTNET(".NET"),
    Laravel("Laravel"),
    Redis("Redis"),
    Javasript("Javascript"),
    AngularJS("AngularJS"),
    NodeJS("NodeJS"),
    ReactJS("ReactJS"),
    VueJS("VueJS"),
    Bootstrap("Bootstrap"),
    Android("Android"),
    flutter("Fltter"),
    Swift("Swift"),
    Ionic("Ionic"),
    GoLang("GoLang"),
    Arquitetura_sistemas("Aquitetura de sistemas"),
    AWS("AWS"),
    Azure("Azure");

    private String label;

    Abiliity(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}
