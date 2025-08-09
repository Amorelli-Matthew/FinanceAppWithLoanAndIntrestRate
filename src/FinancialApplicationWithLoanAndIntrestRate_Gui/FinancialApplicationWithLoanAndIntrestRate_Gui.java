/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package FinancialApplicationWithLoanAndIntrestRate_Gui;




/*
Name: Matthew Amorelli

Date: October 16, 2022

Assignment : Financial Application compare loan with intrest rates, GUI Version (Chapter 16, Execise 13)

Description:  a program that calcuates the  total payment between a loan amount and nunber of years 

through various intrest rates between 5% and 8%.
*/

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class FinancialApplicationWithLoanAndIntrestRate_Gui extends Application {

   
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
    
        //create a new borderpane
        BorderPane MainPane = new BorderPane();
        
        //create a new hbox
        HBox hbox = new HBox(5);
        
        
     //set the top of the main pane with the hbox
        MainPane.setTop(hbox);
        
        //create new labels for loan amount and number of years
        Label LblLoanAmount = setFontForLbl("Loan Amount: ");
        
        Label lblNumberOfYears = setFontForLbl( "Number Of Years: " );
        
        
        //create  new textFields for loan amount and number of years
        TextField TFLoanAmount = new TextField();
        
        TextField TFNumberOfYears = new TextField( );
        
        
        //create a new button that displays the table
        Button ShowTableBtn = new Button("Show Table");
        
        
        //add all the tf and lbls  and btn to the hbox
        hbox.getChildren().addAll(LblLoanAmount,  TFLoanAmount , lblNumberOfYears , TFNumberOfYears, ShowTableBtn);

        //create a new scrollbar
        ScrollBar ScrollBar = new ScrollBar();
        
        //create a new text area
         TextArea TA_Table = new TextArea();

         //set the center of the main pane with the Table
         MainPane.setCenter(TA_Table);
         
         //set the bottom of the main pane with a scrollbar
         MainPane.setBottom(ScrollBar);
        
        
        //register the show table button with a anonymus method
        ShowTableBtn.setOnAction( (ActionEvent e) -> {
                  {
                //clear the Table
                 TA_Table.clear();
                 
                // read the loan ammount and store it in a variable
            double loanAmount = Double.parseDouble(TFLoanAmount.getText() );
                
               //read the number of years and store it in a variable
               int numberOfYears = Integer.parseInt( TFNumberOfYears.getText() );

                //variable to hold intrestRate
                  double annualIntrestRate = 5;
                
                  //variable to hold the MonthlyIntrestRate
                double monthlyIntrestRate ;
                
                //variable to hold the monthly payment
                 double monthlyPayment ;

                 //variable to hold the total payment
                  double totalPayment ;
                 
                  //string that holds the intrest Rate
                  String intrestRate;
                
                //string to hold the total monthly payment
                String MonthlyPaymentString;
                    
                //string to hold the total payment string
                 String TotalPaymentString;
               
                //string that holds the entire intrest rate, monthly payment, and total payment
                 String PrintEntire_IR_MP_TP;
               
                 
                  //dispaly labels for Intrest rate and Monthly payment and total payment
              TA_Table.setText("Interest Rate     Monthly Payment    Total Payment\n");
              
              //starting from the annual intrest rate 5% go up to 8% intrest rate by 1/8th increments
              for( double i = annualIntrestRate ; i <= 8;  i += 0.125    )
                {
                   
                    //get the monthly intrest rate
                    monthlyIntrestRate = i / 1200; 

                    //get the monthly payment
                     monthlyPayment = loanAmount * monthlyIntrestRate / 
                       (   1  -  1 /  Math.pow(1+ monthlyIntrestRate, numberOfYears  * 12)  );
                 
                     //get the total payment
                    totalPayment = (monthlyPayment * numberOfYears * 12) ;
                            
                                 
                    //format the intrest rate
               intrestRate =  String.format("%-5.3f                   ",  i);
                
                // format the monthly payment
               MonthlyPaymentString = String.format( "%-5.2f                        " , monthlyPayment);
                    
                //format the total payment and create a new line
               TotalPaymentString = String.format("%-9.2f\n", totalPayment);
               
                
                 //get get the entire intrest rate, monthly payment, and total payment and have it all in one string
               PrintEntire_IR_MP_TP = intrestRate + MonthlyPaymentString + TotalPaymentString;
                 
               //add the existing text with the new string
                 TA_Table.setText(TA_Table.getText() + PrintEntire_IR_MP_TP);
                
                }
         }
           
      }        
  );
        
        
        
        
        
        
        
        
        //create a new scene with the mainPane
        Scene sc = new Scene(MainPane);
        
        //set the stage with the scene
       stage.setScene(sc);
       
       //set the stage title
       stage.setTitle("Exercise16_13");
       
       //display the stage
       stage.show();
       }
   

//method that creates a label with a size and name    
    public Label setFontForLbl(String name){
        
        //create label with name and font and return it
        Label lbl = new Label(name);

        lbl.setFont(new Font(20) );
    
        return lbl;
    
    }
    
}
