package ristinolla;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class RistinollaSovellus extends Application {
    
    Ristinolla ristinolla = new Ristinolla();
    
    @Override
    public void start(Stage ikkuna) {
        BorderPane asettelu = new BorderPane();
        Label vuoro = new Label("Vuoro: X");
        vuoro.setFont(Font.font("Monospaced", 40));
        ArrayList<String> vuorot = new ArrayList<>();
        vuorot.add("X");
        ristinolla.alusta();
        
        GridPane keskustaNapit = new GridPane();
        
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y <3; y++) {
                Button nappi = new Button(" ");
                nappi.setFont(Font.font("Monospaced", 40));
                keskustaNapit.add(nappi, x, y);
                int xNyt = x;
                int yNyt = y;        
                
                nappi.setOnAction((event) -> {
                    String nytVuoro = vuorot.get(vuorot.size()-1);
                    if (!ristinolla.onkoPelattu(xNyt, yNyt)) {
                        String talteen = pelaaVuoro(nytVuoro, nappi, xNyt, yNyt);
                    
                        vuorot.add(talteen); 
                        asetaArvo(xNyt, yNyt, nappi);

                        vuoro.setText("Vuoro: " + talteen);
                    
                    }
                    
                    if (vuorot.size()> 5) {
                        if (ristinolla.onkoVoitto()) {
                            vuoro.setText("Loppu!");
                            int vuorojenMaara = 9-vuorot.size();
                            while (vuorojenMaara > 0) {
                                vuorot.add("Y");
                                vuorojenMaara--;
                            }
                        }
                    }
                    if (vuorot.size()> 9) {
                        vuoro.setText("Loppu!");
                    }
                });   

            }
        }
        
        asettelu.setTop(vuoro);
        asettelu.setCenter(keskustaNapit);
        
        Scene nakyma = new Scene(asettelu);
        ikkuna.setScene(nakyma);
        ikkuna.show();
    }
    
    public String pelaaVuoro(String edVuoro, Button nappi, int x, int y) {                    
        if (edVuoro.equals("X")) {
            nappi.setText("X");
            return "O";
        } else {
            nappi.setText("O");
            return "X";
        }
    }
    
    public boolean asetaArvo(int x, int y, Button nappi) {
        int arvo = 0;
        if (nappi.getText().contains("X")) {
            arvo = 1;
        }
        if (nappi.getText().contains("O")) {
            arvo = 2;
        }

        if (ristinolla.asetaArvo(x, y, arvo)) {
            return true;
        }
        return false;
        
    }
    
    public static void main(String[] args) {
        launch(RistinollaSovellus.class);
    }

}
