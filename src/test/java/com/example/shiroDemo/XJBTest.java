package com.example.shiroDemo;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class XJBTest {
    @Test
    public void test1() {
        String[] atp = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka",
                "David Ferrer", "Roger Federer",
                "Andy Murray", "Tomas Berdych",
                "Juan Martin Del Potro"};
        List<String> players = Arrays.asList(atp);
        players.forEach(p -> {
            System.out.println(p);
        });
    }

}
