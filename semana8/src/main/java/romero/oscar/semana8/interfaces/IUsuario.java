package romero.oscar.semana8.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import romero.oscar.semana8.modelo.Usuario;

@Repository
public interface IUsuario  extends CrudRepository<Usuario, Integer>{
    
}
