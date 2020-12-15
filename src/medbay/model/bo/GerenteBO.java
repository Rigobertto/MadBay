package medbay.model.bo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javafx.stage.FileChooser.ExtensionFilter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import medbay.model.vo.ConsultaVO;
import javafx.stage.Stage;

public class GerenteBO implements GerenteInterBO{
	
	//private final static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	
	public static void gerarPDF(ConsultaVO consulta) {
		
		Document document = new Document();
		FileChooser f = new FileChooser();
		f.getExtensionFilters().add(new ExtensionFilter("PDF","*.pdf"));
		java.io.File file = f.showSaveDialog(new Stage());
		
		 if (file != null) {
			try {
				PdfWriter.getInstance(document, new FileOutputStream(file.getAbsolutePath()));
				
				document.open();
				Paragraph paragraph = new Paragraph();
				
				paragraph.add("Consulta em MedBay: \n\n");		
				{
					paragraph.add("\nNome do Paciente: " + consulta.getPaciente().getNome() + "\nCPF: " + consulta.getPaciente().getCpf() +
					"\nG�nero: " + consulta.getPaciente().getGenero() + "\nIdade: " + consulta.getPaciente().getIdade() +
					"\nAltura: " + consulta.getPaciente().getAltura() + "\nPeso: " + consulta.getPaciente().getPeso()
					+ "\nTipo Sangu�neo: " + consulta.getPaciente().getTipoSangue()  
					+ "\nExame: " +  consulta.getExame().getNome() + "\nValor R$: " + consulta.getExame().getValor()
					+ "\nData: " + consulta.getDataString() + " �s " + consulta.getHoraString()  
					+ "\nCom o m�dico: " + consulta.getMedico().getNome() + "\nCRM: " + consulta.getMedico().getCrm()
					+ "\nCom Observa��o: " + consulta.getObservacao() + "\n\n");
				}
				document.add(paragraph);
				Alert a = new Alert(AlertType.INFORMATION);
				a.setHeaderText("Documento de consulta realizada com sucesso!");
				a.show();
			}catch (FileNotFoundException e) {
				Alert a = new Alert(AlertType.ERROR);
				a.setHeaderText(e.getMessage());
				a.show();
			} catch (DocumentException e) {
				Alert a = new Alert(AlertType.ERROR);
				a.setHeaderText("N�o foi poss�vel gerar os dados da consulta");
				a.show();
			} finally {
				document.close();
			}
		}
	}			 
}

