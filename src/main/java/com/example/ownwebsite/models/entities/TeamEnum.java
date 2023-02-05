package com.example.ownwebsite.models.entities;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum TeamEnum {

    Warriors, Lakers, Mavericks, Hawks,Bucks, Sixers, Knicks;

    private static final Map<String, TeamEnum> nameToValueMap =
            new HashMap<>();

    static {
        for (TeamEnum value : EnumSet.allOf(TeamEnum.class)) {
            nameToValueMap.put(value.name(), value);
        }
    }

    public static boolean containsTeam(String name) {
        return nameToValueMap.containsKey(name);
    }

}
