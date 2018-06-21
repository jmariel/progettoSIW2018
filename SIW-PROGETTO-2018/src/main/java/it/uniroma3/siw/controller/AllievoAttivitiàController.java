package it.uniroma3.siw.controller;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.siw.model.Allievo;
import it.uniroma3.siw.model.Attività;
import it.uniroma3.siw.model.Centro;
import it.uniroma3.siw.model.Responsabile;
import it.uniroma3.siw.service.AllievoService;
import it.uniroma3.siw.service.AttivitàService;
import it.uniroma3.siw.service.ResponsabileService;

@Controller
public class AllievoAttivitiàController {
	
	@Autowired
	AllievoService allService;

	@Autowired
	AttivitàService attService;
	
	@Autowired
	ResponsabileService respService;
	
	@RequestMapping("/associaAllievo")
	public String mostraAssociazioneAllievo (HttpSession session, Model model) {
		return "associaAllievoAttivià";
	}
	
	@GetMapping("selezionaAllievoEsistente")
	public String selezionaAllievoEsistente(@RequestParam("nome") String nome, @RequestParam("cognome") String cognome,
			@RequestParam("dataDiNascita") Date dataDiNascita, @RequestParam("luogoDiNascita") String luogoDiNascita,
			Model model, HttpSession session) {
		Allievo daTrovare = new Allievo();
		daTrovare.setNome(nome);
		daTrovare.setCognome(cognome);
		daTrovare.setDataDiNascita(dataDiNascita);
		daTrovare.setLuogoDiNascita(luogoDiNascita);
		List<Allievo> allievoInLista = allService.findByNomeAndCognomeAndDataDiNascitaAndLuogoDiNascita(daTrovare);
		if(allievoInLista == null){
			model.addAttribute("errSelezionaAllievo", "Nessun Allievo trovato");
			return "associaAllievoAttività";
		}
		if(allievoInLista.size() > 1) {
			model.addAttribute("errTantiAllievi", "sono presenti più allievi con queste informazioni");
			return "associaAllievoAttività";
		}
		Responsabile r = respService.findByUsername((String) session.getAttribute("username"));
		Centro c = r.getCentro();
		
		Allievo trovato = allievoInLista.get(0);
		
		List<Attività> attività = c.getListaAttività();
		
		int postiNonDisponibili = 0;
		for (Attività a: attività)
			postiNonDisponibili = postiNonDisponibili + a.getListaAllievi().size();
		
		if(postiNonDisponibili >= c.getNumMaxAllievi()) {
			model.addAttribute("errMessaggio", "Non ci sono più posti disponibili in questo centro");
			return "error";
		}
		
		model.addAttribute("postiDisponibili", c.getNumMaxAllievi()-postiNonDisponibili);
		model.addAttribute("listaAttività", attività);
		session.setAttribute("allievoSelezionato", trovato);
		return "selezionaAttività";
	}
	
	private boolean giaIscritto(Attività attività, Allievo allievo) {
		return attività.getListaAllievi().contains(allievo);
	}
	
	@RequestMapping("iscrivi/{id}")
	public String iscrivi (@PathVariable Long id, HttpSession session, Model model) {
		Allievo allievo = (Allievo) session.getAttribute("allievoSelezionato");
		session.removeAttribute("allievoSelezionato");
		Attività attività = attService.findById(id);
		if(allievo==null && attività==null) {
			model.addAttribute("error", "Non è possibile fare l'iscrizione all'attività");
			return "error";
		}
		if(giaIscritto(attività, allievo)) {
			model.addAttribute("error", "L'allievo è già iscritto all'attività");
			return "error";
		}
		
		List<Attività> listaAttività = new LinkedList();
		listaAttività.add(attività);
		allievo.setListaAttivitàAllievo(listaAttività);
		
		List<Allievo> listaAllievi = new LinkedList();
		listaAllievi.add(allievo);
		attività.setListaAllievi(listaAllievi);
		
		allService.save(allievo);
		
		return "confermaIscrizione";
		
	}
}
