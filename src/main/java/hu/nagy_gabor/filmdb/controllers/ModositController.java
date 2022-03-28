package hu.nagy_gabor.filmdb.controllers;

import hu.nagy_gabor.filmdb.Controller;
import hu.nagy_gabor.filmdb.Film;
import hu.nagy_gabor.filmdb.FilmApi;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ModositController extends Controller {
    @FXML
    private TextField inputCim;
    @FXML
    private TextField inputKategoria;
    @FXML
    private Spinner<Integer> inputHossz;
    @FXML
    private ChoiceBox<Integer> inputErtekeles;
    private Film modositando;

    @FXML
    public void onModositButtonClick(ActionEvent actionEvent) {
        String cim = inputCim.getText().trim();
        String kategoria = inputKategoria.getText().trim();
        int hossz = 0;
        int ertekelesIndex = inputErtekeles.getSelectionModel().getSelectedIndex();
        if(cim.isEmpty()){
            alert("Cím megadása kötelező!");
            return;
        }
        if(kategoria.isEmpty()){
            alert("Kategória megadása kötelező");
            return;
        }
        try {
            hossz = inputHossz.getValue();
        } catch (NullPointerException ex){
            alert("A hossz megadása kötelező!");
            return;
        } catch (Exception ex){
            alert("A hossz csak 1 és 999 közötti szám lehet!");
            return;
        }
        if(hossz < 1 || hossz > 999){
            alert("A hossz csak 1 és 999 közötti szám lehet!");
            return;
        }
        if(ertekelesIndex == -1){
            alert("Értékelés kiválasztása kötelező!");
            return;
        }
        int ertekeles = inputErtekeles.getValue();

        modositando.setCim(cim);
        modositando.setKategoria(kategoria);
        modositando.setErtekeles(ertekeles);
        modositando.setHossz(hossz);

        try {
            Film modositott = FilmApi.filmModositasa(modositando);
            if (modositott != null){
                alertWait("Sikeres módosítás!");
                this.stage.close();
            } else {
                alert("Sikertelen módosítás!");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Film getModositando() {
        return modositando;
    }

    public void setModositando(Film modositando) {
        this.modositando = modositando;
        ertekekBeallitasa();
    }

    private void ertekekBeallitasa(){
        inputCim.setText(modositando.getCim());
        inputKategoria.setText(modositando.getKategoria());
        inputHossz.getValueFactory().setValue(modositando.getHossz());
        inputErtekeles.setValue(modositando.getErtekeles());
    }
}
