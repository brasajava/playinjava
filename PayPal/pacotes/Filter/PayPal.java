package Filter;

public class PayPal {
	
	public final static String COMPLETO = "Completo";
	public final static String AGUARDANDO = "Aguardando Pagto";
	public final static String APROVADO = "Aprovado";
	public final static String EM_ANALISE = "Em Análise";
	public final static String CANCELADO = "Cancelado"; 
	
	private long id;
	private String transacaoID;
	private String referencia;
	private String anotacao;
	private String dataTransacao;
	private String tipoPagamento;
	private String statusTransacao;
	private double valor;
	private String data;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTransacaoID() {
		return transacaoID;
	}
	public void setTransacaoID(String transacaoID) {
		this.transacaoID = transacaoID;
	}
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public String getAnotacao() {
		return anotacao;
	}
	public void setAnotacao(String anotacao) {
		this.anotacao = anotacao;
	}
	public String getDataTransacao() {
		return dataTransacao;
	}
	public void setDataTransacao(String dataTransacao) {
		this.dataTransacao = dataTransacao;
	}
	public String getTipoPagamento() {
		return tipoPagamento;
	}
	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}
	public String getStatusTransacao() {
		return statusTransacao;
	}
	public void setStatusTransacao(String statusTransacao) {
		this.statusTransacao = statusTransacao;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}

	
	public PayPal(String transacaoID, String referencia, String anotacao,
			String dataTransacao, String tipoPagamento, String statusTransacao,
			double valor){
		super();
		this.transacaoID=transacaoID;
		this.referencia=referencia;
		this.anotacao=anotacao;
		this.dataTransacao=dataTransacao;
		this.tipoPagamento=tipoPagamento;
		this.statusTransacao=statusTransacao;
		this.valor=valor;
	}
}
