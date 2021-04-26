package estruturas;

public class Aresta {
	private String idA;
	private String idB;
	private int tamanho;
	private int corA, corB;
	
	public Aresta(String idA, String idB, int tamanho) {
		super();
		this.idA = idA;
		this.idB = idB;
		this.tamanho = tamanho;
		this.corA = 0;
		this.corB = 0;
	}
	
	public String getIdA() {
		return idA;
	}
	public void setIdA(String idA) {
		this.idA = idA;
	}
	public String getIdB() {
		return idB;
	}
	public void setIdB(String idB) {
		this.idB = idB;
	}
	public int getTamanho() {
		return tamanho;
	}
	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	public int getCorA() {
		return corA;
	}

	public void setCorA(int corA) {
		this.corA = corA;
	}

	public int getCorB() {
		return corB;
	}

	public void setCorB(int corB) {
		this.corB = corB;
	}
	
}
