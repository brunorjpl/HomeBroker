package br.edu.infnet.view;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import br.edu.infnet.model.LerDados;

public class PrimeiroGrafico extends JFrame{

	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PrimeiroGrafico() throws IOException {
	      super( "Projeto de Bloco" ); 
	      
//	    //Cria um dataSet para inserir os dados que serão passados para a criação do gráfico 
//	      DefaultCategoryDataset ds = new DefaultCategoryDataset();
//	       
//	   // cria o conjunto de dados
//	    
//	      ds.addValue(10.5, "maximo", "dia 1");
//	      ds.addValue(28.2, "maximo", "dia 2");
//	      ds.addValue(37.3, "maximo", "dia 3");
//	      ds.addValue(41.5, "maximo", "dia 4");
//	      ds.addValue(35.7, "maximo", "dia 5");
//	      ds.addValue(82.5, "maximo", "dia 6");
//	       
	  	
			DefaultCategoryDataset ds = new DefaultCategoryDataset();
			
		    Reader reader = Files.newBufferedReader(Paths.get("MGLU3.csv"));
	
	        CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();

	        List<String[]> valores = csvReader.readAll();

	        for (String[] valor : valores) {
	            ds.addValue(Double.parseDouble(valor[4]), "fechamento", valor[0]);
	            System.out.println("Date : " + valor[0] +
                        " - Close : " + valor[4]);
	        }
	      
	      //Cria um objeto JFreeChart passando os seguintes parametros
	      JFreeChart grafico = ChartFactory.createLineChart("MGLU3.SA", "Dia", 
	    		    "Valor", ds, PlotOrientation.VERTICAL, true, true, false);
	       
	      this.add( new ChartPanel( grafico ) );
	      
	      this.pack();
	   }
	
	public static void main(String[] args) throws IOException {
		
		new PrimeiroGrafico().setVisible(true);
		
	}
}
