package romero.oscar.semana8.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

import romero.oscar.semana8.interfaceservicio.IUsuarioServicio;
import romero.oscar.semana8.modelo.Usuario;

@Controller
@RequestMapping
public class Controlador {
    
    @Autowired
    private IUsuarioServicio servicio;

    @GetMapping("/listar")
    public String listar(Model model){
        List<Usuario>usuario=servicio.listar();
        model.addAttribute("usuario", usuario);
        return "index";
    }
    
    @GetMapping("/new")
    public String registrar(Model model){
        model.addAttribute("usuario", new Usuario());
        return "form";
    }
    
    @PostMapping("/save")
    public String save(@Validated Usuario u, Model model){
        servicio.save(u);
        return "redirect:/listar";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id,  Model model){
        Optional<Usuario>usuario=servicio.listarId(id);
        model.addAttribute("usuario", usuario);
        return "form";
    }

    @GetMapping
    public String delete(Model model, @PathVariable  int id){
        servicio.delete(id);
        return "redirect:/listar";
        

    }
}
