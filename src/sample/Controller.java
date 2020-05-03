package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private BigDecimal left;
    private String slectedOperator;
    private boolean numberInputting;

    @FXML
    private TextField textField;

    public Controller(){
        this.left = BigDecimal.ZERO;
        this.slectedOperator = "";
        this.numberInputting = false;
    }

    @FXML
    private void operateButton (ActionEvent event){
        Button button = (Button)event.getSource();
        String buttonText = button.getText();

        if (buttonText.equals("C")){
            if (buttonText.equals("C")){
                left = BigDecimal.ZERO;
            }
            slectedOperator = "";
            numberInputting = true;
            textField.clear();
            return;
        }

        if (buttonText.matches("[0-9\\,]")){
            if (!numberInputting){
                numberInputting = true;
                textField.clear();
            }
            textField.appendText(buttonText);
            return;
        }

        if (buttonText.matches("[/+*-]")){
            left = new BigDecimal(textField.getText());
            slectedOperator = buttonText;
            numberInputting = false;
            return;
        }

        if (buttonText.equals("=")){
            final BigDecimal right = numberInputting ? new BigDecimal(textField.getText()) : left;
            left = calculate(slectedOperator, left, right);
            textField.setText(left.toString());
            numberInputting = false;
            return;
        }
    }

    static BigDecimal calculate(String operator, BigDecimal left, BigDecimal right){
        switch (operator){
            case "+":
                return left.add(right);
            case "-":
                return left.subtract(right);
            case "*":
                return left.multiply(right);
            case "/":
                return left.divide(right);
        }
        return right;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


}
