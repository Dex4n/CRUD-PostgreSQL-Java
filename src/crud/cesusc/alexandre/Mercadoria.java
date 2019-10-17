package crud.cesusc.alexandre;

public class Mercadoria {
	
	private String nomeMercadoria;
	private String pesoMercadoria;
	
	public Mercadoria(String nomeMercadoria, String pesoMercadoria) {
		this.nomeMercadoria = nomeMercadoria;
		this.pesoMercadoria = pesoMercadoria;
	}
	
	public Mercadoria() {

	}

	public String getNomemercadoria() {
        return nomeMercadoria;
    }
	
	public void setNomemercadoria(String nomeMercadoria) {
        this.nomeMercadoria = nomeMercadoria;
    }

	public String getPeso() {
        return pesoMercadoria;
    }
	
	public void setPeso(String pesoMercadoria) {
        this.pesoMercadoria = pesoMercadoria;
    }
}
