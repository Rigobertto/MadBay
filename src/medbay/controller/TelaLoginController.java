package medbay.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import medbay.model.bo.UsuarioBO;
import medbay.model.vo.AtendenteVO;
import medbay.model.vo.GerenteVO;
import medbay.model.vo.UsuarioVO;
import medbay.exception.AutException;
public class TelaLoginController {
	private TextField login;
	private TextField senha;
	private Label erroAut;
	
	UsuarioBO usuBO = new UsuarioBO();
	public void autenticar(ActionEvent event) {
		UsuarioVO vo = new UsuarioVO();
		vo.setLogin(login.getText());
		vo.setSenha(senha.getText());
		try {
			UsuarioVO autenticado = usuBO.autenticar(vo);
			if(autenticado instanceof GerenteVO) {
				//abrir janela principal de Gerente
			}else if(autenticado instanceof AtendenteVO){
				//abrir janela principal de Atendente
			}else {
				//abrir janela principal de Medico
			}
		}catch(Exception e){
			erroAut.setText("Usu�rio ou Senha Inv�lido!");
			erroAut.setVisible(true);
		}
	}
}
