package projeto.model.bo;

import projeto.model.vo.GerenteVO;

public class GerenteBO implements GerenteInterBO{
	
	public GerenteVO[] listar(GerenteVO[] gerente) {
		
	}
	
	public GerenteVO editar(GerenteVO gerente){
	//	Recebe objeto do tipo pessoa que poder� editar cada atributo...
	//	...utilizando tamb�m os m�todos get e set para exibir e enviar no DAO.
	//	Caso a o usu�rio nao escolha nenhum genero, o genero utilizado ser� o Indefinido, declarado j� no construtor;
	//	Retorna um objeto do tipo Pessoa com os atributos editados.
	}
	
	public void excluir(GerenteVO gerente){
	//	Recebe um objeto Pessoa para excluir, vale destacar que excluir� n�o s� apenas um atributo, mas sim o objeto por completo.
	//	N�o retorna nada.
	}
	
	public GerenteVO buscaCPF(GerenteVO gerente){
	//	Ir� receber uma String CPF para retornar o objeto do tipo Pessoa que tem como atributo igual a mesma String CPF
	//	recebida por parametro e poder retornar.
	//	Vale destacar que antes de ir para o m�todo de busca no DAO, a String recebida por parametro ir� passar por uma valida��o
	//	para saber se � de fato um n�mero de CPF;
	}
	
	public GerenteVO buscaNome(GerenteVO gerente){
		//	Ir� receber uma String nome para retornar o objeto do tipo Pessoa que tem como atributo igual a mesma String nome
		//	recebida por parametro e poder retornar a exibi��o dos atributos do objeto.
		//	Vale destacar que antes de ir para o m�todo de busca no DAO, a String recebida por parametro ir� passar por uma valida��o
		//	para saber se � de fato uma String nula e etc.
	}
	
	public GerenteVO cadastrar(GerenteVO gerente){
	//	Recebe um objeto Pessoa para inserir os atributos incluindo os inicializados pelo construtor e envia para o DAO e posteriormente
	//	inserir no banco de dados;
	//	Os atributos que ser�o cadastrados passar�o pela valida��o dos mesmo com os m�todos get e set correspondente a cada um,
	//	como idade, cpf, nome, genero e etc.
	}
}
