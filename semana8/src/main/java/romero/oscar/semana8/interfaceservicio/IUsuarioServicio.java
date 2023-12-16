package romero.oscar.semana8.interfaceservicio;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import romero.oscar.semana8.modelo.Usuario;

@Service
public interface IUsuarioServicio {
    public List<Usuario>listar();
    public Optional<Usuario>listarId(int id);
    public int save(Usuario u);
    public void delete(int id);
}
