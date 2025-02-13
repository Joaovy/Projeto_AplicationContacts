package com.joaovzy.aplication_contatos;

import org.springframework.beans.propertyeditors.UUIDEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.UUID;

@Controller
public class ContatosControle {

    private static final ArrayList<Contato> LISTA_CONTATOS = new ArrayList<>();
    // melhor metodo pois o arrayList não pede o tamanho!!

    static {
        LISTA_CONTATOS.add(new Contato("João Antonio", "34 99775679", "23"));
        LISTA_CONTATOS.add(new Contato("Maria", "34 99775679", "7"));
        LISTA_CONTATOS.add(new Contato("José", "34 92342539", "10"));
        LISTA_CONTATOS.add(new Contato("Carlos", "34 9232329", "6"));
        LISTA_CONTATOS.add(new Contato("André", "34 99775679", "00"));
        /* recomendavel utilizar o banco de dados para tal
        uso de informações, neste caso o ArrayList esta guardando nossa instancia
         */
    }

    //private static  final Contato[] LISTA_CONTATOS_2 = new Contato[10];
    // metodo tradicional explicado nas aulas,

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/contatos")
    public ModelAndView listar() {
        ModelAndView modelAndView = new ModelAndView("listar");

        modelAndView.addObject("contatos", LISTA_CONTATOS);

        return modelAndView;
    }

    @GetMapping("/contatos/novo")
    public ModelAndView novo() {
        ModelAndView modelAndView = new ModelAndView("formulario");

        modelAndView.addObject("contato", new Contato());

        return modelAndView;
    }

    @PostMapping("/contatos")
    public String cadastrar(Contato contato) {
        String id = UUID.randomUUID().toString();

        contato.setId(id);

        LISTA_CONTATOS.add(contato);

        return "redirect:/contatos";
    }

    @GetMapping("contatos/{id}/editar")
    public ModelAndView editar(@PathVariable String id) {

        ModelAndView modelAndView = new ModelAndView("formulario");

        Contato contato = procurarContato(id);

        modelAndView.addObject("contato", contato);

        return modelAndView;


    }

    @PutMapping("/contatos/{id}")
    public String atualizar (Contato contato){

        int indice = procurarIndiceContato(contato.getId());

        Contato contatoVelho = LISTA_CONTATOS.get(indice);

        LISTA_CONTATOS.remove("contatoVelho");

        LISTA_CONTATOS.add(indice, contato);

        return "redirect:/contatos";
    }

// -------------------- Metodos Auxiliares--------------------
    private Contato procurarContato(String id) {
        for (int i = 0; i < LISTA_CONTATOS.size(); i++) {
            Contato contato = LISTA_CONTATOS.get(i);
            if (contato.getId().equals(id)) {
                return contato;

            }
        }
        return null;
    }

    private Integer procurarIndiceContato(String id) {
        for (int i = 0; i < LISTA_CONTATOS.size(); i++) {
            Contato contato = LISTA_CONTATOS.get(i);

            if (contato.getId().equals(id)) {
                return i;
            }
        }

        return null;
    }













    }

