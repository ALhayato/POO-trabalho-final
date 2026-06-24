class Aviso{
  private int id;
  private String titulo;
  private String conteudo;
  private String dataExpiracao;
  
    public Aviso(String conteudo, String dataExpiracao, int id, String titulo) {
        this.conteudo = conteudo;
        this.dataExpiracao = dataExpiracao;
        this.id = id;
        this.titulo = titulo;
    }
    
  public boolean estaValido(){
    return true; //falta implementar
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getConteudo() {
    return conteudo;
  }

  public void setConteudo(String conteudo) {
    this.conteudo = conteudo;
  }

  public String getDataExpiracao() {
    return dataExpiracao;
  }

  public void setDataExpiracao(String dataExpiracao) {
    this.dataExpiracao = dataExpiracao;
  }
}