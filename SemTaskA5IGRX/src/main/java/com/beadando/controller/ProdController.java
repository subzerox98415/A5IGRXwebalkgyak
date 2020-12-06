package com.beadando.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.beadando.model.Prod;
import com.beadando.service.ProdService;

@Controller
public class ProdController {

	@Autowired
	private ProdService prodService;

	// listázás oldal
	@GetMapping("/index")
	public String viewHomePage(Model model) {
		return findPaginated(1, "termnev", "asc", model);
	}

	// új termék felvitele
	@GetMapping("/showNewProdForm")
	public String showNewProdForm(Model model) {

		model.addAttribute("prod", new Prod());
		return "new_prod.html";// resources/new_prod.html-el tér vissza
	}

	// termék elmentése
	@PostMapping("/saveProd")
	public String saveProd(@ModelAttribute("prod") Prod prod) {

		prodService.saveProd(prod);

		return "redirect:/index";// mentés után vissza tér a listához
	}

	// termék update ami a resources/update_prod függvénnyel tér majd vissza
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
		Prod prod = prodService.getProdById(id);
		model.addAttribute("prod", prod);
		return "update_prod";
	}

	// listázás oldal
	@GetMapping("/Listing/{id}")
	public String Listing(@PathVariable(value = "id") long id, Model model) {
		Prod prod = prodService.getProdById(id);

		model.addAttribute("prod", prod);
		return "Listing";
	}

	// termék törlés id alapján ami a sorban lévő termék ID-ja
	@GetMapping("/deleteProd/{id}")
	public String deleteProd(@PathVariable(value = "id") long id) {

		this.prodService.deleteProdById(id);
		return "redirect:/index";
	}
	// listázás, ez a függvény határozza meg, hogy mennyi termék lehet egy oldalon
	// és tudja abc rendbe sorolni

	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable(value = "pageNo") int pageNo, @RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir, Model model) {
		int pageSize = 10;

		Page<Prod> page = prodService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Prod> listProd = page.getContent();

		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());

		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

		model.addAttribute("listProd", listProd);
		return "index";
	}
}
