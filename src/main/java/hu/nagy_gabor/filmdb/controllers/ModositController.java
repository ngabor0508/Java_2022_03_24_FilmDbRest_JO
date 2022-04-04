package hu.nagy_gabor.filmdb.controllers;

import hu.nagy_gabor.filmdb.Controller;
import hu.nagy_gabor.filmdb.Termek;
import hu.nagy_gabor.filmdb.TermekApi;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ModositController extends Controller {
    @FXML
    private TextField inputKodszam;
    @FXML
    private TextField inputName;
    @FXML
    private Spinner<Integer> inputPrice;
    @FXML
    private ChoiceBox<Integer> inputQuantity;
    @FXML
    private TextField inputUrl;
    @FXML
    private TextField inputKategoria;
    private Termek modositando;

    @FXML
    public void onModositButtonClick(ActionEvent actionEvent) {
        String kodszam = inputKodszam.getText().trim();
        String name = inputName.getText().trim();
        int price = 0;
        int quantityIndex = inputQuantity.getSelectionModel().getSelectedIndex();
        String url = inputUrl.getText().trim();
        String kategoria = inputKategoria.getText().trim();
        if (kodszam.isEmpty()) {
            alert("Kódszám megadása kötelező!");
            return;
        }
        if (name.isEmpty()) {
            alert("Név megadása kötelező");
            return;
        }
        try {
            price = inputPrice.getValue();
        } catch (NullPointerException ex) {
            alert("Az ár megadása kötelező!");
            return;
        } catch (Exception ex) {
            alert("Az ár csak 1 és 999 közötti szám lehet!");
            return;
        }
        if (price < 1 || price > 999) {
            alert("A hossz csak 1 és 999 közötti szám lehet!");
            return;
        }
        if (quantityIndex == -1) {
            alert("Értékelés kiválasztása kötelező!");
            return;
        }
        int quantity = inputQuantity.getValue();
        if (url.isEmpty()) {
            alert("Url megadása kötelező!");
            return;
        }
        if (kategoria.isEmpty()) {
            alert("Kategória megadása kötelező!");
            return;
        }

        modositando.setKodszam(kodszam);
        modositando.setName(name);
        modositando.setPrice(price);
        modositando.setQuantity(quantity);
        modositando.setUrl(url);
        modositando.setKategoria(kategoria);

        try {
            Termek modositott = TermekApi.termekModositasa(modositando);
            if (modositott != null) {
                alertWait("Sikeres módosítás!");
                this.stage.close();
            } else {
                alert("Sikertelen módosítás!");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Termek getModositando() {
        return modositando;
    }

    public void setModositando(Termek modositando) {
        this.modositando = modositando;
        ertekekBeallitasa();
    }

    private void ertekekBeallitasa() {
        inputKodszam.setText(modositando.getKodszam());
        inputName.setText(modositando.getName());
        inputPrice.getValueFactory().setValue(modositando.getPrice());
        inputQuantity.setValue(modositando.getQuantity());
        inputUrl.setText(modositando.getUrl());
        inputKategoria.setText(modositando.getKategoria());
    }
}
