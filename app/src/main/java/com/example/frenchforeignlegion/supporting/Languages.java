package com.example.frenchforeignlegion.supporting;

/**
 * @author Belitski Marat
 * @date 04.07.2023
 */
public class Languages {
    String nameLanguage;
    int imageLanguage;

    public Languages(String nameLanguage, int imageLanguage) {
        this.nameLanguage = nameLanguage;
        this.imageLanguage = imageLanguage;
    }

    public String getNameLanguage() {
        return nameLanguage;
    }

    public int getImageLanguage() {
        return imageLanguage;
    }
}
