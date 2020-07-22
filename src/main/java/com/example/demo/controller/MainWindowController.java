package com.example.demo.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.demo.service.ThirdPartyApi;
import com.example.demo.service.ThirdPartyApiImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MainWindowController implements Initializable {


    private Logger LOG = LoggerFactory.getLogger(MainWindowController.class);

    private ThirdPartyApi thirdPartyApi;

    @FXML
    private Label label;

    @FXML
    private TextField usernameTextField, passwordTextField;

    public MainWindowController(ThirdPartyApi thirdPartyApi) {
        this.thirdPartyApi = thirdPartyApi;
    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();
        if (username.equals("javafx") && password.equals("letmepass")) {
            label.setText("You shall pass !");
        } else {
            label.setText("You shall NOT pass !");
        }
        String data = thirdPartyApi.getData();
        LOG.info("Here is your data" + data);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
