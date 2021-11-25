package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;

@Data
public class Country {
    String code;

    String name;

    @JsonProperty("native")
    String nativeName;

    String phone;

    String capital;

    String currency;

    String emoji;

    Continent continent;

    ArrayList<Language> languages;

    ArrayList<State> states;
}
