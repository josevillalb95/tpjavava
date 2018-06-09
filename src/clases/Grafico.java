package clases;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.DateTickUnit;
import org.jfree.chart.axis.DateTickUnitType;
import org.jfree.chart.axis.LogAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.axis.SegmentedTimeline;
import org.jfree.chart.axis.TickUnits;
import org.jfree.chart.block.BlockFrame;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYAreaRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.util.DefaultShadowGenerator;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.RectangleInsets;

public class Grafico {

public void graf(){
    XYSeries series = new XYSeries("Producto A");
    XYPlot plot=new XYPlot();
    // Introduccion de datos

    series.add(1, 1);
    series.add(2, 6);
    series.add(3, 3);
    series.add(4, 10);
    //XYPlotCollection dataset=new XYPlotCollection();
    XYSeriesCollection dataset = new XYSeriesCollection();
    dataset.addSeries(series);
    
    

   JFreeChart chart = ChartFactory.createXYLineChart(

            "Ventas 2014", // Título
            "Tiempo (x)", // Etiqueta Coordenada X
            "Cantidad", // Etiqueta Coordenada Y
            dataset, // Datos
            PlotOrientation.VERTICAL,
            true, // Muestra la leyenda de los productos (Producto A)
            false,
            false
    );
    
    // Mostramos la grafica en pantalla
    ChartFrame frame = new ChartFrame("Ejemplo Grafica Lineal", chart);
    frame.pack();
    frame.setVisible(true);
	}

    
}
	
	

