package hu.nagy_gabor.filmdb.controllers;

import hu.nagy_gabor.filmdb.Controller;
import hu.nagy_gabor.filmdb.Termek;
import hu.nagy_gabor.filmdb.TermekApi;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HozzaadController extends Controller {
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

    @FXML
    public void onHozzaadButtonClick(ActionEvent actionEvent) {
        String kodszam = inputKodszam.getText().trim();
        String name = inputName.getText().trim();
        int price = 0;
        int quantityIndex = inputQuantity.getSelectionModel().getSelectedIndex();
        String url = inputUrl.getText().trim();
        String kategoria = inputKategoria.getText().trim();
        if(kodszam.isEmpty()){
            alert("Kódszám megadása kötelező!");
            return;
        }
        if(name.isEmpty()){
            alert("Név megadása kötelező");
            return;
        }
        try {
            price = inputPrice.getValue();
        } catch (NullPointerException ex){
            alert("Az ár megadása kötelező!");
            return;
        } catch (Exception ex){
            alert("Az ár csak 1 és 999 közötti szám lehet!");
            return;
        }
        if(price < 1 || price > 999){
            alert("A hossz csak 1 és 999 közötti szám lehet!");
            return;
        }
        if(quantityIndex == -1){
            alert("Mennyiség kiválasztása kötelező!");
            return;
        }
        int quantity = inputQuantity.getValue();
        if(url.isEmpty()){
            alert("Url megadása kötelező!");
            return;
        }
        if(kategoria.isEmpty()){
            alert("Kategória megadása kötelező!");
            return;
        }


        try {
            Termek ujTermek = new Termek(0,kodszam, name, price, quantity, url, kategoria);
            Termek letrehozott = TermekApi.termekHozzaadasa(ujTermek);
            if(letrehozott != null){
                alert("Termék hozzáadása sikeres!");
            }
            else {
                alert("Termék hozzáadása sikertelen!");
            }
        } catch (Exception e) {
            hibaKiir(e);
        }
    }

}
