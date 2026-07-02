package interfacemdl;
import model.Paciente;

public interface VideoChamada{
  /**
   * metodo que permite que um psicologo faça uma video chamada com um paciente 
   * @param p paciente que sera atendido
   * @return verdadeiro se foi possivel fazer a video chamada, falso caso contrario
   */
  public boolean fazerVideoChamada(Paciente p);
}
