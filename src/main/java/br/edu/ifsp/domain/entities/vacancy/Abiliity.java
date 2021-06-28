package br.edu.ifsp.domain.entities.vacancy;

public enum Abiliity {


    UI_UX("UI/UX"),
    MYSQL("Mysql"),
    MONGO_DB("MongoDB"),
    ORACLE_SQL("OracleDb"),
    SQL_SERVER("SQL server"),
    POSTGRE_SQL("PostgreSQL"),
    PYTHON("Python"),
    FLASK("Flask"),
    JAVA("Java"),
    C_PLUS_PLUS("C++"),
    CSHARP("C#"),
    PHP("PHP"),
    DOTNET(".NET"),
    LARAVEL("Laravel"),
    REDIS("Redis"),
    JAVASCRIPT("Javascript"),
    ANGULARJS("AngularJS"),
    NODEJS("NodeJS"),
    REACTJS("ReactJS"),
    VUEJS("VueJS"),
    BOOTSTRAP("Bootstrap"),
    ANDROID("Android"),
    FLUTTER("Fltter"),
    SWIFT("Swift"),
    IONIC("Ionic"),
    GOLANG("GoLang"),
    ARC_SISTEMAS("Aquitetura de sistemas"),
    AWS("AWS"),
    AZURE("Azure");

    private String label;

    Abiliity(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}
