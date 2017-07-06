package Palindrome;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.*;

public class PalindromeClass extends Application{

	Button find,clear;
	TextField lower,higher;
	Label label1,label2;
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Finding Higest Palindrome");
		find =new Button("Find Palindrome");
		clear=new Button("Clear");
		lower=new TextField("Enter Lower Bound Number");
		higher=new TextField("Enter Higher Bound Number");
		label1=new Label("Lower");
		label2=new Label("Higher");
		/*find.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				
					System.out.println("Find clicked");
				
			}
		});*/
		find.setOnAction(e -> {
			System.out.println("It works");
		});
		clear.setOnAction(e -> {
			lower.setText("");
			higher.setText("");
		});
		HBox h1=new HBox(20);
		h1.getChildren().addAll(label1,lower);
		HBox h2=new HBox(20);
		h2.getChildren().addAll(label2,higher);
		VBox layout=new VBox(20);
		layout.getChildren().addAll(h1,h2,clear,find);
		
		Scene scene=new Scene(layout,300,250);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	

	
}
