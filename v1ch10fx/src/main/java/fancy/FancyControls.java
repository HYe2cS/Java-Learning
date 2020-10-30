package fancy;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 @version 1.0 2017-12-29
 @author Cay Horstmann
 */
public class FancyControls extends Application
{
    public void start(Stage stage)
    {
        PieChart chart = new PieChart();
        chart.getData().addAll(
                new PieChart.Data("Asia", 4298723000.0),
                new PieChart.Data("North America", 355361000.0),
                new PieChart.Data("South America", 616644000.0),
                new PieChart.Data("Europe", 742452000.0),
                new PieChart.Data("Africa", 1110635000.0),
                new PieChart.Data("Oceania", 38304000.0));
        chart.setTitle("Population of the Continents");

        String location = "http://horstmann.com";
        WebView browser = new WebView();
        WebEngine engine = browser.getEngine();
        engine.load(location);

//"fancy/moonlanding.mp4
        Path path = Paths.get("moonlanding.mp4");
//        System.out.println(path.toString());
        Media media = new Media(path.toUri().toString());
        MediaPlayer player = new MediaPlayer(media);
        player.setAutoPlay(true);
        MediaView video = new MediaView(player);
        video.setOnError(ex -> System.out.println(ex));

        stage.setWidth(500);
        stage.setHeight(500);
        stage.setScene(new Scene(browser));
        stage.show();

        Stage stage2 = new Stage();
        stage2.setWidth(500);
        stage2.setHeight(500);
        stage2.setX(stage.getX() + stage.getWidth());
        stage2.setY(stage.getY());
        stage2.setScene(new Scene(chart));
        stage2.show();

        HBox box = new HBox(video);
        box.setAlignment(Pos.CENTER);
        Stage stage3 = new Stage();
        stage3.setWidth(500);
        stage3.setHeight(500);
        stage3.setX(stage.getX());
        stage3.setY(stage.getY() + stage.getHeight());
        stage3.setScene(new Scene(box));
        stage3.show();
    }
}
