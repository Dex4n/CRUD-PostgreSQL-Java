package crud.cesusc.alexandre;

public class Fornecedor {
	
	private String nomeFornecedor;
	
	public Fornecedor(String nomeFornecedor) {
		this.nomeFornecedor = nomeFornecedor;
	}
	
	public Fornecedor() {
		
	}

	public String getNomefornecedor() {
        return nomeFornecedor;
    }
	
	public void setNomefornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }

}
