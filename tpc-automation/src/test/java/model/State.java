package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class State {
    String code;

    String name;

    Country country;
}
