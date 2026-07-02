package interfacemdl;

public interface Autenticavel {
   /**
    * metodo que faz a autenticacao de um objeto
    * @param senha que sera digitada para a comparacao com a senha verdadeira do objeto
    * @return verdadeiro se a senha que foi digitada é igual ao do objeto, falso caso contrario
    */
   public boolean autenticar(String senha);
}  
