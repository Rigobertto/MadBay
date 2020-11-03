package projeto.model.vo;

public class Paciente {
	private int id_paciente;
	private float peso;
	private float altura;
	private String tipo_sangue;
	
	public int getId_paciente() {
		return id_paciente;
	}
	public void setId_paciente(int id_paciente) {
		this.id_paciente = id_paciente;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		if(peso > 0.0f)
			this.peso = peso;
		else
			System.out.println("Peso inv�lido!");
	}
	public float getAltura() {
		return altura;
	}
	public void setAltura(float altura) {
		if(altura > 0.0f)
			this.altura = altura;
		else
			System.out.println("Altura inv�lida!");
	}
	public String getTipoSangue() {
		return tipo_sangue;
	}
	public void setTipoSangue(String tipo_sangue) {
		tipo_sangue = tipo_sangue.toUpperCase();
		String tipos[] = {"A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"};
		boolean teste = false;
		for(int i = 0; i < 8; i++) {
			if(tipos[i].equals(tipo_sangue)) {
				this.tipo_sangue = tipo_sangue;
				teste = true;
				break;
			}
		}
		if(teste == false)
			System.out.println("Tipo sanguineo inv�lido!");
	}
	
	
}
