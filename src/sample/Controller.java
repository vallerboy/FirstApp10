package sample;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.*;

public class Controller implements Initializable{

    @FXML
    private Button buttonHello;

    @FXML
    private Label labelWords;

    @FXML
    private TextField fieldSentence;

    @FXML
    private Button buttonAdd;

    private List<String> words;
    private List<String> randedWords = new ArrayList<>();

    private Random random;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        words = new ArrayList<>();
        words.add("Zycie jest piekne");
        words.add("Hehhehe");

        random = new Random();

        Utils.createDialog("Witaj!", "Nie zapomnij o koncie premium :>", "...");

        buttonHello.setOnMouseClicked(event -> handleRandomSentence(event));

       buttonAdd.setOnMouseClicked(event -> handleButtonAdd(event));

       fieldSentence.setOnKeyPressed(event -> handleKeyPressed(event));
    }

    private void handleKeyPressed(KeyEvent e) {
        if(e.getCode() == KeyCode.ENTER){
            words.add(fieldSentence.getText());
            fieldSentence.clear();
        }
    }

    private void handleButtonAdd(MouseEvent e){
        words.add(fieldSentence.getText());
        fieldSentence.clear();
    }

    private void handleRandomSentence(MouseEvent e){
        String randedWord = words.get(random.nextInt(words.size()));

        while(randedWords.contains(randedWord)){
            randedWord = words.get(random.nextInt(words.size()));

            if(randedWords.size() == words.size()){
                Utils.createDialog("Błąd", "", "Koniec sentencji :(");
                return;
            }
        }

        labelWords.setText(randedWord);
        randedWords.add(randedWord);
    }


}
