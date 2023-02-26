package itau.canais.api.modules.produto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

    @GetMapping
    public ModelAndView exibirProdutos(@RequestParam("tokenJWT") String token) {
        ModelAndView modelAndView = new ModelAndView("produto");
        modelAndView.addObject("token", token);
        return modelAndView;
    }
}