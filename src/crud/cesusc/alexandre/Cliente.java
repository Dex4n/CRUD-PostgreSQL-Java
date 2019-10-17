package crud.cesusc.alexandre;

public class Cliente {
	
	private String nomeCliente;
	private String cpfCliente;
	
	public Cliente(String nomeCliente, String cpfCliente) {
		this.nomeCliente = nomeCliente;
		this.cpfCliente = cpfCliente;
	}

	public Cliente() {

	}

	public String getNome() {
        return nomeCliente;
    }
	
	public void setNome(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
	
	public String getCpf() {
        return cpfCliente;
    }
	
	public void setCpf(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

}
