package interfacemdl;

import model.*;

public interface Clinico{
  /**
   * permite que um profissional da saude adcione uma evolucao ao paciente
   * @param p o objeto paciente que recebera o atendimento 
   * @param anotacao texto contendo as observaçoes do profissional
   */
  public void evoluirProntuario(Paciente p, String anotacao);
}
