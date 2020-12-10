package medbay.model.vo;

import java.util.Calendar;

public class ConsultaVO {
	private int id;

    private Calendar data;

    private PacienteVO paciente;
    private MedicoVO medico;

    private String observacao;
    private ProntuarioVO prontuario;

    /*
    prontuario e observa��o marcam uma etapa de valida��o
    caso a observa��o seja null a consulta ainda n�o foi executada
    logo estar� em aberto

    caso a observa��o seja diferente de null e n�o exista prontuario
    quer dizer que foi feita uma consulta e n�o houve a necessidade de
    fazer um exame

    caso exista observa��o e prontuario quer dizer que a a consulta foi feita
    e que os exames foram solicitados

    caso o prontuario conste uma observa��o igual a null indica que o exame n�o foi feito

    caso o prontuario tenha observa��o e n�o tenha laudo temos que o exame foi feito mas
    ainda n�o foi avaliado pelo m�dico

    caso o laudo exista no prontuario teremos uma consulta completamente concluida
    */

    public int getId() {
        return this.id;
    }
    public boolean setId(int id) {
        if(id < 0) return false;
        else this.id = id;
        return true;
    }

    public Calendar getData() {
        return this.data;
    }
    public boolean setData(Calendar data) {
        if(data.getTimeInMillis() < this.data.getTimeInMillis()) return false;
        this.data = data;
        return true;
    }

    public PacienteVO getPaciente() {
        return this.paciente;
    }
    public boolean setPaciente(PacienteVO paciente) {
        if(paciente == null) return false;
        this.paciente = paciente;
        return true;
    }

    public MedicoVO getMedico() {
        return this.medico;
    }
    public boolean setMedico(MedicoVO medico) {
        if(medico == null) return false;
        this.medico = medico;
        return true;
    }

    public String getObservacao() {
        return new String(this.observacao);
    }
    public boolean setObservacao(String observacao) {
        if(observacao == null || observacao.isEmpty()) return false;
        this.observacao = observacao;
        return true;
    }

    public ProntuarioVO getProntuario() {
    	return this.prontuario;
    }
    public void setProntuario(ProntuarioVO prontuario) {
    	this.prontuario = prontuario;
    }
}
