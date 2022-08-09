package com.example.dsa2assignment1;

import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import java.util.Stack;

class StackImplementation extends GridPane
{
     private Label resultLabel;
     private Text resultText;
     private Button pushButton;
     private Button popButton;
     private TextField inputText;
     private Stack<Object> stack = new Stack<Object>();

     public StackImplementation()
     {
         Font font = new Font(12);

         /* Creating the nodes to be positioned on the grid */
         Label inputLabel = new Label("Enter the element: ");
         inputText = new TextField();
         resultLabel = new Label("Content(s) of Stack");
         resultText = new Text("Empty");
         pushButton = new Button("PUSH");
         popButton = new Button("POP");

         /* Adding the nodes to the grid,
            specifying their position and span
            ie. (column, row, columnspan, rowspan)
         */
         add(inputLabel, 0, 0, 1, 1);
         add(inputText, 1, 0, 2, 1);
         add(resultLabel, 1, 1,1,1);
         add(resultText, 0,2, 3, 1);
         add(pushButton, 0, 3, 1,1);
         add(popButton, 2, 3, 1, 1);

         /* Setting gaps between rows and columns */
         setHgap(20);
         setVgap(10);

         /* Setting grid padding */
         setPadding(new Insets(20, 20, 20, 20));

         /* Set constraints on columns */
         ColumnConstraints column1 = new ColumnConstraints();
         ColumnConstraints column2 = new ColumnConstraints();
         ColumnConstraints column3 = new ColumnConstraints();

         getColumnConstraints().add(column1);
         getColumnConstraints().add(column1);
         getColumnConstraints().add(column3);

         column1.setPercentWidth(40);
         column2.setPercentWidth(30.0);
         column3.setPercentWidth(30.0);

         /* Horizontal alignments of nodes in grid */
         setHalignment(inputLabel, HPos.RIGHT);
         setHalignment(pushButton, HPos.CENTER);
         setHalignment(popButton, HPos.LEFT);
         setHalignment(resultLabel, HPos.CENTER);

         /* Setting font on all nodes */
         inputLabel.setFont(font);
         inputText.setFont(font);
         resultLabel.setFont(font);
         resultText.setFont(font);
         pushButton.setFont(font);
         popButton.setFont(font);

         /* Making buttons create events */
         pushButton.setOnAction(this::stackOperation);
         popButton.setOnAction(this::stackOperation);
     }

     /* Implementing the event handler for buttons */
     public void stackOperation(ActionEvent event)
     {
         String outputString = "";
         if (event.getSource() == pushButton)
             stack.push((Object) inputText.getText());
         else {
             if (stack.isEmpty())
                 return;
             stack.pop();
         }

         for (Object obj : stack)
             outputString += (String) obj + " ";
         resultText.setText(outputString);
     }
}