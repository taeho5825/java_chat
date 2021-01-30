package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		BorderPane root = new BorderPane();
		root.setPadding(new Insets(10));
		
		TextArea textarea = new TextArea();
		textarea.setWrapText(true);
		textarea.setEditable(false);
		textarea.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		
		GridPane panel = new GridPane();
		panel.setHgap(15);
		TextField textfield = new TextField();
		textfield.setPrefColumnCount(40);
		Button btn = new Button("Submit");
		panel.add(textfield, 0, 0, 2, 1);
		panel.add(btn,       2, 0, 1, 1);
		
		root.setCenter(textarea);
		BorderPane.setMargin(panel, new Insets(10, 0, 0, 0));
		root.setBottom(panel);
		
		EventHandler<ActionEvent> actionHandler = new 
				EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event)
			{
				textarea.appendText(textfield.getText() + "\n");
				textarea.selectPositionCaret(textarea.getLength());
				textfield.clear();
			}
		};
		textfield.addEventHandler(ActionEvent.ACTION, actionHandler);
		btn.addEventHandler(ActionEvent.ACTION, actionHandler);
		
		Scene scene = new Scene(root, 300, 250);
		primaryStage.setTitle("UI Control Example");
		primaryStage.setScene(scene);
		primaryStage.show();
		textfield.requestFocus();
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}
}
