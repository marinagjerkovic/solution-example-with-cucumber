package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Language {
    String code;

    String name;

    @JsonProperty("native")
    String nativeName;
}
