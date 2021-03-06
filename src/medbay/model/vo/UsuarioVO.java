package medbay.model.vo;

public class UsuarioVO extends PessoaVO {
	    private String login;
	    private String senha;
	    private int tabela;
	    
	    public int getTabela() {
	    	return this.tabela;
	    }
	    public void setTabela(int tabela) {
	    	this.tabela = tabela;
	    }
	    public void Usuario(String nome, String senha){ // Pq desse m�todo?
	        this.setNome(nome);
	        this.setSenha(senha);
	    }

	    //public int getId() { // validar idade
	  //      return this.id;
	   // }

	    //public boolean setId(int id) {
	     //   if(id < 0x00) return false; // adicionar método no pacote "util" que verifica se o ID j�, existe
	     //   this.id = id;
	    //    return true;
	   // }

	    public String getLogin() {
	        return this.login;
	    }

	    public boolean setLogin(String login) {
	        if(login == null || login.isEmpty()) return false;
	        this.login = login;
	        return true;
	    }

	    public String getSenha() {
	        return new String(this.senha);
	    }

	    public boolean setSenha(String senha) {
	        if(senha == null || senha.isEmpty()) return false;
	        this.senha = senha;
	        return true;
	    }

		// usado para validação, pode estar no BO
	    public boolean verificarSenha(String senha) {
	        if(this.getSenha().equals(senha)) return true;
	        return false;
	    }

	    public boolean trocarSenha(String senha_atual, String senha_nova) {
	        if(this.verificarSenha(senha_atual)) {
	            return this.setSenha(senha_nova);
	        }else{
	        return false;
	        }
	    }
}
