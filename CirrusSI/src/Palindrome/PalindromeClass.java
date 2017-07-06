package Palindrome;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.*;

public class PalindromeClass extends Application{

	

	Button find;
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Finding Higest Palindrome");
		find =new Button();
		find.setText("Find Palindrome");
		find.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				if(event.getSource()==find){
					System.out.println("Find clicked");
				}
			}
		});
		StackPane layout=new StackPane();
		layout.getChildren().add(find);
		
		Scene scene=new Scene(layout,300,250);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	

	
}
