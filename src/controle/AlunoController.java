package controle;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class AlunoController implements Initializable {

    @FXML
    private Button btnSalvar;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtIdade;

    @FXML
    void incluirAluno(ActionEvent event) {
//    		Alert alert;
//    		alert = new Alert(AlertType.INFORMATION,"Você clicou no botão salvar!", ButtonType.OK);
//    		alert.setTitle("Atenção!");
//    		alert.setHeaderText("Informação:");
//    		alert.show();
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		//1a forma
//		btnSalvar.setOnAction((event)->{
//    		Alert alert;
//    		alert = new Alert(AlertType.INFORMATION,"Você clicou no botão salvar, via lambda!", ButtonType.OK);
//    		alert.setTitle("Atenção! via Lambda");
//    		alert.setHeaderText("Informação via lambda:");
//    		alert.show();
//		});
		
		//2a forma
//		btnSalvar.setOnAction(new EventHandler<ActionEvent>() {
//			@Override
//			public void handle(ActionEvent event) {
//	    		Alert alert;
//	    		alert = new Alert(AlertType.INFORMATION,"Você clicou no botão salvar, via evento!", ButtonType.OK);
//	    		alert.setTitle("Atenção, via evento!");
//	    		alert.setHeaderText("Informação via evento:");
//	    		alert.show();
//			}
//		});
		
		//3a forma
		btnSalvar.setOnAction(this::handleButtonAction);
		
		txtNome.focusedProperty().addListener(this::changedNome);
		txtIdade.textProperty().addListener(this::changedIdade);
	}
	
	private void handleButtonAction(ActionEvent event) {
		Alert alert;
		alert = new Alert(AlertType.INFORMATION,"Você clicou no botão salvar, via handle!", ButtonType.OK);
		alert.setTitle("Atenção via handle!");
		alert.setHeaderText("Informação via handle:");
		alert.show();

	}
	
	public void changedNome(ObservableValue<? extends Boolean> arg0, Boolean velhoValor, Boolean novoValor) {
		if(!novoValor) {
    		System.out.println("Desfocou!");
		}
		else {
    		System.out.println("Focou!");
		}
	}
	
	public void changedIdade(ObservableValue<? extends String> observable, String oldValue, String newValue) {
		if (!newValue.matches("\\d{0,9}?") || newValue.length() > 2) {
    		txtIdade.setText(oldValue);
        }
    }

	@FXML
	void cancelarOnAction(ActionEvent event) {
		Alert alert;
		alert = new Alert(AlertType.INFORMATION,"Você clicou no botão cancelar!", ButtonType.OK);
		alert.setTitle("Atenção via handle!");
		alert.setHeaderText("Informação via handle:");
		alert.show();

	}



}