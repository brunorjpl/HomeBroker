package br.edu.infnet.view;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class PrimeiroGrafico extends JFrame{

	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PrimeiroGrafico() {
	      super( "Primeiro Grafico" ); 
	      
	    //Cria um dataSet para inserir os dados que serão passados para a criação do gráfico tipo Pie
	      DefaultCategoryDataset ds = new DefaultCategoryDataset();
	       
	   // cria o conjunto de dados
	    
	      ds.addValue(10.5, "maximo", "dia 1");
	      ds.addValue(28.2, "maximo", "dia 2");
	      ds.addValue(37.3, "maximo", "dia 3");
	      ds.addValue(41.5, "maximo", "dia 4");
	      ds.addValue(35.7, "maximo", "dia 5");
	      ds.addValue(82.5, "maximo", "dia 6");
	       
	      //Cria um objeto JFreeChart passando os seguintes parametros
	      JFreeChart grafico = ChartFactory.createLineChart("Meu Grafico", "Dia", 
	    		    "Valor", ds, PlotOrientation.VERTICAL, true, true, false);
	       
	      this.add( new ChartPanel( grafico ) );
	      
	      this.pack();
	   }
	
	public static void main(String[] args) {
		
		new PrimeiroGrafico().setVisible(true);
		
	}
}
