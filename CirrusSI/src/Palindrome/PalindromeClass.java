package Palindrome;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.*;

public class PalindromeClass extends Application{

	Button find,clear;
	TextField lower,higher,answer;
	Label label1,label2,label3,errorMessage;
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Finding Higest Palindrome");
		find =new Button("Find Palindrome");
		clear=new Button("Clear");
		lower=new TextField("Lower Bound");
		higher=new TextField("Higher Bound");
		answer=new TextField();
		label1=new Label("Lower");
		label2=new Label("Higher");
		label3=new Label("Answer");
		errorMessage=new Label();
		find.setOnAction(e -> {
			answer.setText("");
			errorMessage.setText("");
			long l=Long.parseLong(lower.getText());                    // enter number between -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
			long h=Long.parseLong(higher.getText());
			if(l==h || l>h){
				errorMessage.setText("Enter a valid range");
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
				
			}
			if(flag==0){
				errorMessage.setText("No Palindrom in the Range");
			}
		});
		lower.setOnMouseClicked(e -> {
			lower.setText("");
		});
		higher.setOnMouseClicked(e -> {
			higher.setText("");
		});
		clear.setOnAction(e -> {
			lower.setText("");
			higher.setText("");
			answer.setText("");
			errorMessage.setText("");
		});
		HBox h1=new HBox(10);
		h1.setPadding(new Insets(0, 10, 5, 0)); 
		h1.getChildren().addAll(label1,lower);
		HBox h2=new HBox(10);
		h2.getChildren().addAll(label2,higher);
		h2.setPadding(new Insets(0, 10, 5, 0));
		HBox h3=new HBox(10);
		h3.getChildren().addAll(label3,answer);
		HBox h4=new HBox(10);
		h4.getChildren().addAll(clear,find);
		VBox layout=new VBox(10);
		layout.setPadding(new Insets(0, 20, 10, 20));
		layout.getChildren().addAll(h1,h2,h4,h3,errorMessage);
		
		Scene scene=new Scene(layout,300,250);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	

	
}
