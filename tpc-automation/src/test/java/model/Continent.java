package model;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Continent {
    String code;

    String name;

    ArrayList<Country> countries;
}
