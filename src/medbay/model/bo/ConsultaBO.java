package medbay.model.bo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import medbay.model.dao.ConsultaDAO;
import medbay.model.vo.ConsultaVO;
import medbay.model.vo.ExameVO;
import medbay.model.vo.MedicoVO;
import medbay.model.vo.PacienteVO;

public class ConsultaBO implements ConsultaInterBO {
	ConsultaDAO<ConsultaVO> dao = new ConsultaDAO<ConsultaVO>();
	
	ExameBO<ExameVO> ebo = new ExameBO<ExameVO>();
	PacienteBO pbo = new PacienteBO();
	MedicoBO<MedicoVO> mbo = new MedicoBO<MedicoVO>();
	
	public boolean cadastrar(ConsultaVO consulta) {
        try {
        	dao.cadastrar(consulta);
        	return true;
        }catch(Exception e){
        	e.printStackTrace();
        	return false;
        }
    }

    public boolean editar(ConsultaVO consulta) {
        try {
        	dao.editar(consulta);
        	return true;
        }
        catch(Exception e) {
        	e.printStackTrace();
        	return false;
        }
    }
	
	public void excluir(ConsultaVO consulta) {
        try {
        	dao.excluir(consulta);
        }catch(Exception e) {
        	e.printStackTrace();
        }
    }

	public List<ConsultaVO> listar() {
		List<ConsultaVO> lista = new ArrayList<ConsultaVO>();
		
		try {
			ResultSet tabela = dao.listar();
			
			while(tabela.next()) {
				ConsultaVO consulta = new ConsultaVO();
				
				consulta.setId(tabela.getInt("ide"));
				
				
				Calendar data = Calendar.getInstance();				
				{
					Date date = tabela.getDate("data_consulta");
					Time time = tabela.getTime("hora_consulta");
					data.setTimeInMillis(date.getTime() + time.getTime());
				}
				consulta.setData(data);
				
				consulta.setExame(ebo.buscaId(tabela.getInt("ide_exame")));
				consulta.setPaciente(pbo.buscaId(tabela.getInt("ide_paciente")));
				consulta.setMedico(mbo.buscaId(tabela.getInt("ide_medico")));
				consulta.setObservacao(tabela.getString("observacao"));
				
				lista.add(consulta);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public List<ConsultaVO> listarIdMedico(MedicoVO medico) {
		List<ConsultaVO> lista = this.listar();
		return this.listarIdMedico(medico, lista);
	}
	
	public List<ConsultaVO> listarIdMedico(MedicoVO medico, List<ConsultaVO> lista) {
		List<ConsultaVO> resultado = new ArrayList<ConsultaVO>();
		
		for(int index = 0; index < lista.size(); index++) {
			if(lista.get(index).getMedico().getId() == medico.getId()) resultado.add(lista.get(index));
		}
		
		return resultado;
	}

	public List<ConsultaVO> listarIdPaciente(PacienteVO paciente) {
		List<ConsultaVO> lista = this.listar();
		return this.listarIdPaciente(paciente, lista);
	}
	
	public List<ConsultaVO> listarIdPaciente(PacienteVO paciente, List<ConsultaVO> lista) {
		List<ConsultaVO> resultado = new ArrayList<ConsultaVO>();
		
		for(int index = 0; index < lista.size(); index++) {
			if(lista.get(index).getPaciente().getId() == paciente.getId()) resultado.add(lista.get(index));
		}
		
		return resultado;
	}
	
	public List<ConsultaVO> listarNomeMedico(String nome) {
		List<ConsultaVO> lista = this.listar();
		return this.listarNomeMedico(nome, lista);
	}
	
	public List<ConsultaVO> listarNomeMedico(String nome, List<ConsultaVO> lista) {
		List<ConsultaVO> resultado = new ArrayList<ConsultaVO>();
		
		for(int index = 0; index < lista.size(); index++) {
			if(lista.get(index).getMedico().getNome().contains(nome)) resultado.add(lista.get(index));
		}
		
		return resultado;
	}
	
	public List<ConsultaVO> listarNomePaciente(String nome) {
		List<ConsultaVO> lista = this.listar();
		return this.listarNomePaciente(nome, lista);
	}
	
	public List<ConsultaVO> listarNomePaciente(String nome, List<ConsultaVO> lista) {
		List<ConsultaVO> resultado = new ArrayList<ConsultaVO>();
		
		for(int index = 0; index < lista.size(); index++) {
			if(lista.get(index).getPaciente().getNome().contains(nome)) resultado.add(lista.get(index));
		}
		
		return resultado;
	}
	
	public List<ConsultaVO> listarNome(String nome) {
		List<ConsultaVO> lista = this.listar();
		return this.listarNome(nome, lista);
	}
	
	public List<ConsultaVO> listarNome(String nome, List<ConsultaVO> lista) {
		List<ConsultaVO> resultado = new ArrayList<ConsultaVO>();
		
		resultado.addAll(this.listarNomeMedico(nome, lista));
		resultado.addAll(this.listarNomePaciente(nome, lista));
		
		return resultado;
	}
	
	public ConsultaVO buscarId(int id) {
		ConsultaVO consulta = new ConsultaVO();
		consulta.setId(id);
		
		ResultSet tabela = dao.buscaID(consulta);
		
		try {
			if(tabela.next()) {
				Calendar data = Calendar.getInstance();				
				{
					Date date = tabela.getDate("data_consulta");
					Time time = tabela.getTime("hora_consulta");
					data.setTimeInMillis(date.getTime() + time.getTime());
				}
				consulta.setData(data);
				
				consulta.setExame(ebo.buscaId(tabela.getInt("ide_exame")));
				consulta.setPaciente(pbo.buscaId(tabela.getInt("ide_paciente")));
				consulta.setMedico(mbo.buscaId(tabela.getInt("ide_medico")));
				
				consulta.setObservacao(tabela.getString("observacao"));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return consulta;
	}
	
	/*
	public List<ConsultaVO> buscarData() {
		
	}
	*/
}
