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
	TextField lower,higher,answer;
	Label label1,label2,label3;
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
		answer=new TextField();
		label1=new Label("Lower");
		label2=new Label("Higher");
		label3=new Label("Answer");
		/*find.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				
					System.out.println("Find clicked");
				
			}
		});*/
		find.setOnAction(e -> {
			long l=Long.parseLong(lower.getText());                    // enter number between -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
			long h=Long.parseLong(higher.getText());
			if(l==h || l>h){
				System.out.println("Enter a valid range");
			}
			String reverse="";
			String toCompare="";
			int flag=0;
			while(h>=l){
				toCompare=Long.toString(h);
				reverse=new StringBuffer(toCompare).reverse().toString();
				if(toCompare.equalsIgnoreCase(reverse)){
					answer.setText(Long.toString(h));
					flag=1;
					break;
				}
				h--;
				System.out.println(h);
				if(flag==0){
					answer.setText("No Palindrom in the Range");
				}
			}
		});
		
		clear.setOnAction(e -> {
			lower.setText("");
			higher.setText("");
			answer.setText("");
		});
		HBox h1=new HBox(10);
		h1.getChildren().addAll(label1,lower);
		HBox h2=new HBox(10);
		h2.getChildren().addAll(label2,higher);
		HBox h3=new HBox(10);
		h3.getChildren().addAll(label3,answer);
		VBox layout=new VBox(10);
		layout.getChildren().addAll(h1,h2,clear,find,h3);
		
		Scene scene=new Scene(layout,300,250);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	

	
}
