package com.example.frenchforeignlegion.supporting;
import androidx.annotation.NonNull;
import com.example.frenchforeignlegion.R;

/**
 * @author Belitski Marat
 * @date 17.05.2023
 */
public class Regiments {
    private final int nameID;
    private final int descriptionID;
    private final int imageID;
    private final int imageHeader;

    public Regiments(int nameID, int descriptionID, int imageID, int imageHeader) {

        this.nameID = nameID;
        this.descriptionID = descriptionID;
        this.imageID = imageID;
        this.imageHeader = imageHeader;
    }

    public int getNameID() {
        return nameID;
    }
    public int getDescriptionID() {
        return descriptionID;
    }
    public int getImageID() {
        return imageID;
    }

    public int getImageHeader() {
        return imageHeader;
    }

    @NonNull
    @Override
    public String toString() {
        return String.valueOf(this.nameID);
    }
    public static final Regiments[] regiments = {
            new Regiments(R.string.name_regiment_0, R.string.name_description_0, R.drawable.logo_1re,R.drawable.header_1re),
            new Regiments(R.string.name_regiment_1, R.string.name_description_1, R.drawable.logo_1rec,R.drawable.header_1rec),
            new Regiments(R.string.name_regiment_2, R.string.name_description_2, R.drawable.logo_1reg,R.drawable.header_1reg),
            new Regiments(R.string.name_regiment_3, R.string.name_description_3, R.drawable.logo_2reg,R.drawable.header_2reg),
            new Regiments(R.string.name_regiment_4, R.string.name_description_4, R.drawable.logo_2rei,R.drawable.header_2rei),
            new Regiments(R.string.name_regiment_5, R.string.name_description_5, R.drawable.logo_2rep,R.drawable.header_2rep ),
            new Regiments(R.string.name_regiment_6, R.string.name_description_6, R.drawable.logo_3rei,R.drawable.header_3rei),
            new Regiments(R.string.name_regiment_7, R.string.name_description_7, R.drawable.logo_4re,R.drawable.header_4re),
            new Regiments(R.string.name_regiment_8, R.string.name_description_8, R.drawable.logo_13dble,R.drawable.header_13dble),
            new Regiments(R.string.name_regiment_9, R.string.name_description_9, R.drawable.logo_dlem,R.drawable.header_dlem),
            new Regiments(R.string.name_regiment_10, R.string.name_description_10, R.drawable.logo_grle,R.drawable.header_grle),
    };
}
