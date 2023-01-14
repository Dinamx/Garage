package model;

public class NiveauEtude {
    String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public NiveauEtude(String description) {
        setDescription(description);
    }

    public NiveauEtude() {
    }
}
