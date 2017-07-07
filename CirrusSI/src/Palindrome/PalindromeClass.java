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
	TextField lower,higher;
	Label label1,label2,label3,errorMessage,answer;
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Finding Higest Palindrome");
		
		find =new Button("Search");
		clear=new Button("Clear");
		lower=new TextField("Lower Bound");
		higher=new TextField("Upper Bound");
		answer=new Label();
		label1=new Label("Lower");
		label2=new Label("Higher");
		label3=new Label("Result");
		errorMessage=new Label();
		find.setOnAction(e -> {
			answer.setText("");
			errorMessage.setText("");
			try{
				long l=Long.parseLong(lower.getText());                    // enter number between -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
				long h=Long.parseLong(higher.getText());
				if(l==h || l>h){
					errorMessage.setText("INVALID INPUT: Enter a valid range");
				}
				else{
					if(l<0&&h<0){
						String reverse="";
						String toCompare="";
						int flag=0;
						h=-1*h;
						l=-1*l;
						while(h<=l){
							toCompare=Long.toString(h);
							reverse=new StringBuffer(toCompare).reverse().toString();
							if(toCompare.equalsIgnoreCase(reverse)){
								answer.setText(Long.toString(-1*h));
								flag=1;
								break;
							}
							h++;
						}
						if(flag==0){
							errorMessage.setText("No Palindrom in the Range");
						}	
					}
					else{
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
						}
						if(flag==0){
							errorMessage.setText("No Palindrom in the Range");
						}
					}		
				}
				
			}
			catch(NumberFormatException f){
				errorMessage.setText("INPUT INVALID: Enter Number Range");
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
