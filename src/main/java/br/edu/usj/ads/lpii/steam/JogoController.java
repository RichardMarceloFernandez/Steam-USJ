package br.edu.usj.ads.lpii.steam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;










@Controller
public class JogoController {

    @Autowired
    jogoRepository jogoRepository;
    @Autowired
    devsResopitory devsResopitory;
    
   
    @GetMapping(value="/")
    public ModelAndView getInicial() {
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }
    
    @GetMapping(value="/jogos")
    public ModelAndView getListaTodosJog() {
        List<Jogo> lista01 = jogoRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("jogos");
        modelAndView.addObject("lista01", lista01);
        return modelAndView;
    }

    @GetMapping(value="/devs")
    public ModelAndView getListaTodosDevs() {
        List<Devs> lista02 = devsResopitory.findAll();
        ModelAndView modelAndView = new ModelAndView("devs");
        modelAndView.addObject("lista02", lista02);
        return modelAndView;
    }
    

    @GetMapping(value="/desenvolvedoras")
    public ModelAndView getListaTodasDev() {
        ModelAndView modelAndView = new ModelAndView("desenvolvedoras");
        return modelAndView;
    }
    

    @GetMapping(value="/cadastroJogos")
    public ModelAndView getCadastroJogos() {
        Jogo jogo = new Jogo();
        ModelAndView modelAndView = new ModelAndView("cadastroJogos");
        modelAndView.addObject("jogo", jogo);
        return modelAndView;
    }

    @GetMapping(value="/cadastroDevs")
    public ModelAndView getCadastroDevs() {
        Devs devs = new Devs();
        ModelAndView modelAndView = new ModelAndView("cadastroDevs");
        modelAndView.addObject("devs", devs);
        return modelAndView;
    }
    
    
    @GetMapping(value="/detalhesJogos/{id}")
    public ModelAndView getDetalhesJogos(@PathVariable Long id) {
        Jogo jogo = jogoRepository.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("detalhesJogos");
        modelAndView.addObject("jogo", jogo);
        return modelAndView;
    }

    @GetMapping(value="/detalhesDevs/{id}")
    public ModelAndView getDetalhesDevs(@PathVariable Long id) {
        Devs devs = devsResopitory.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("detalhesDevs");
        modelAndView.addObject("devs", devs);
        return modelAndView;
    }
    

    @GetMapping(value="/deletarJogo/{id}")
    public String getDeletarJogo(@PathVariable Long id) {
        jogoRepository.deleteById(id);
        return "redirect:/jogos";
    }

    @GetMapping(value="/deletarDevs/{id}")
    public String getDeletarDevs(@PathVariable Long id) {
        devsResopitory.deleteById(id);
        return "redirect:/devs";
    }
    
    
    @GetMapping(value="/editarJogo/{id}")
    public ModelAndView getEditarJogo(@PathVariable Long id) {
        Jogo jogo = jogoRepository.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("cadastroJogos");
        modelAndView.addObject("jogo", jogo);
        return modelAndView;
   }
    
   @GetMapping(value="/editarDevs/{id}")
   public ModelAndView getEditarDevs(@PathVariable Long id) {
       Devs devs = devsResopitory.findById(id).get();
       ModelAndView modelAndView = new ModelAndView("cadastroDevs");
       modelAndView.addObject("devs", devs);
       return modelAndView;
   }
   


    @PostMapping(value="/adicionarJogos")
    public String postAdicionarJogo(Jogo jogo) {
        jogoRepository.save(jogo);
        return "redirect:/jogos";
    }
    

    @PostMapping(value="/adicionarDevs")
    public String postAdicionarDevs( Devs devs) {
        devsResopitory.save(devs);
        return "redirect:/devs";
    }
    
}

