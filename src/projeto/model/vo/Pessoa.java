package projeto.model.vo;

public class Pessoa {
	private String nome;
	private int idade;
	private String cpf;
	private char genero;
	
	public String getNome() {
		if(nome == null) {
			nome = "";
			return nome;
		}
		else
			return nome;
	}
	
	public void setNome(String nome) {			//****Lembrando que a fun��o isEmpty retorna verdadeiro se o .legth() == 0
		if(nome != null && !(nome.isEmpty()))	//caso os valores sejam verdadeiros ser� atribuido, mas antes da atribui��o
			this.nome = nome.toUpperCase();		// tudo � convertido em mai�sculo.
		else
			System.out.println("Nome inv�lido ou vazio");
	}
	
	public int getIdade() {
		if(idade > 0)
			return idade;
		else
			return idade = 0; // Ou seja, se caso aparecer uma idade == 0, significa que a idade anteriormente 
	}							// era uma idade <= 0;
	
	public void setIdade(int idade) {
		if(idade > 0)
			this.idade = idade;
		else
			System.out.println("Idade inv�lida!");
	}
	
	public String getCpf(){
		if(cpf == null) {
			cpf = "";
			return cpf;
		}
		else
			return cpf;
	}
	
	public void setCpf(String cpf) {
		if(cpf.length() == 11 && cpf != null && !(cpf.isEmpty()))	// Por enquanto a valida��o do cpf est� assim
			this.cpf = cpf;											// mas � necess�rio refinar essa valida��o
		else											//// *******AINDA NAO FINALIZADO*****
			System.out.println("CPF inv�lido!");
	}
	
	public char getGenero() {
		if(genero == 'M' || genero == 'F' || genero == 'f' || genero == 'm' || genero == 'i' || genero == 'I'){
			return genero;
		}
		else{
			genero = 'I';	//Caso o genero retornado seja diferete de M ou F,
			return genero; 	// independete do caractere ser� colocado como Indefinido (I/i);
		}
	}
	
	public void setGenero(char genero){
		if(genero == 'M' || genero == 'F' || genero == 'f' || genero == 'm' || genero == 'i' || genero == 'I')
			this.genero = genero;
		else
			System.out.println("Genero inv�lido!");
	}
}
