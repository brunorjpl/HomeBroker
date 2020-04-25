package br.edu.infnet.model;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class LerCsv {
	
	

	 public static void main(String[] args) throws IOException {

	        Reader reader = Files.newBufferedReader(Paths.get("MGLU3.csv"));
	        CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();

	        List<String[]> valores = csvReader.readAll();
	        for (String[] valor : valores)
	            System.out.println("Date : " + valor[0] +
	                            " - Close : " + valor[4]);

	 }
}
