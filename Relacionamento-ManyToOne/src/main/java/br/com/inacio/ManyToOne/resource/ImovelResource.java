package br.com.inacio.ManyToOne.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.inacio.ManyToOne.model.Imovel;
import br.com.inacio.ManyToOne.service.ImovelService;

@RestController
@RequestMapping(value = "/imovel")
public class ImovelResource {
	
	private ImovelService imovelService;

	public ImovelResource(ImovelService imovelService) {
		super();
		this.imovelService = imovelService;
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Imovel salvar(@RequestBody Imovel imovel) {
		return imovelService.salvar(imovel);
	}
	
	@GetMapping
	public ResponseEntity<List<Imovel>> buscarTodos(){
		List<Imovel> buscarTodos = imovelService.buscarTodos();
		return new ResponseEntity<>(buscarTodos,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public Optional<Imovel> buscarPorId(@PathVariable Long id) {
		return imovelService.buscarPorId(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Imovel> atualizar(@RequestBody Imovel imovel,@PathVariable Long id) {
		imovel.setId(id);
		imovelService.atualizar(imovel);
		return ResponseEntity.noContent().build();
	}

}
