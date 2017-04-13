package com.arifian.udacity.geographicquiz.entities;

import java.io.Serializable;

/**
 * Created by faqih on 13/04/17.
 */

public class Question implements Serializable {
    int type;
    String answer;
    String[] options;
    Province province;

    public Question(int type, String answer, String[] options, Province province) {
        this.type = type;
        this.answer = answer;
        this.options = options;
        this.province = province;
    }

    public int getType() {
        return type;
    }

    public String getAnswer() {
        return answer;
    }

    public String[] getOptions() {
        return options;
    }

    public Province getProvince() {
        return province;
    }
}
