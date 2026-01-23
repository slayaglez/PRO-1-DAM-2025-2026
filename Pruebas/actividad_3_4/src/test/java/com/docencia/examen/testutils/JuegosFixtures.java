package com.docencia.examen.testutils;

import com.docencia.examen.herencia.Arcade;
import com.docencia.examen.herencia.Juego;
import com.docencia.examen.herencia.JuegoMesa;

public class JuegosFixtures {
    public static Juego arcade10() { return new Arcade("A1", "Pac-Man", 10); } // 22
    public static Juego arcade20() { return new Arcade("A2", "Metal Slug", 20); } // 24
    public static Juego mesa0() { return new JuegoMesa("M1", "Catan", 0); } // 35
    public static Juego mesa10() { return new JuegoMesa("M2", "Carcassonne", 10); } // 38.5
    public static Juego arcade0(String id) { return new Arcade(id, "Arcade", 0); }
    public static Juego mesa0(String id) { return new JuegoMesa(id, "Mesa", 0); }
}
