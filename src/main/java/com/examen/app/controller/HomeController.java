package com.examen.app.controller;

import com.examen.app.model.Escribano;
import com.examen.app.service.EscribanoService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Controller
public class HomeController {

  @Autowired
  private EscribanoService escribanoService;

  @GetMapping(value = "/")
  public String home(Model model) {
    final Escribano escribano = new Escribano();
    model.addAttribute("escribano", escribano);
    return "home";
  }

  @PostMapping(value = "/")
  public String postHome(Escribano escribano, Model model, RedirectAttributes flash) {

    Escribano result = new Escribano();
    if (escribano.getCuil() == null) {
      flash.addFlashAttribute("danger", "Se requiere el Cuil !!");
      return "redirect:/";
    }
    try {
      result = escribanoService.getEscribano(escribano.getCuil());
    } catch (Exception e) {
      result.setCuil(escribano.getCuil());
      log.error("error en el servicio {}", e.getMessage());
    }
    model.addAttribute("escribano", result);
    return "home";
  }


}
