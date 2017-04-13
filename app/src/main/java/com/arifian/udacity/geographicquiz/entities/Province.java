package com.arifian.udacity.geographicquiz.entities;

import java.io.Serializable;

/**
 * Created by faqih on 12/04/17.
 */

public class Province implements Serializable {
    String provinceName, capitalName, islandName;
    int image;

    public Province(String provinceName, String capitalName, String islandName, int image) {
        this.provinceName = provinceName;
        this.capitalName = capitalName;
        this.islandName = islandName;
        this.image = image;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public String getCapitalName() {
        return capitalName;
    }

    public String getIslandName() {
        return islandName;
    }

    public int getImage() {
        return image;
    }
}
