package itau.canais.api.modules.produto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller("produto")
public class ProdutoController {

//    @GetMapping("/produtos")
//    public ModelAndView exibirProdutos(@RequestParam("tokenJWT") String token) {
//        ModelAndView modelAndView = new ModelAndView("produto");
//        modelAndView.addObject("token", token);
//        return modelAndView;
//    }}


//    @RequestMapping(value = "/crud", method = RequestMethod.GET)
//    public ModelAndView crud() {
//    ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("produto");
//        return modelAndView;
//    }


    @GetMapping("/crud")
    public String produto(){
        return "produto";
    }}






//    @RequestMapping("/crud")
//    public String index() {
//        return "produto.html";
//    }

