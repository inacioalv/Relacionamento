package br.com.inacio.ManyToMany.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.inacio.ManyToMany.model.Venda;
import br.com.inacio.ManyToMany.service.VendaService;

@RestController
@RequestMapping(value = "/venda" )
public class VendaResource {
	
	private VendaService clienteService;

	public VendaResource(VendaService clienteService) {
		super();
		this.clienteService = clienteService;
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Venda salvarCliente(@RequestBody Venda cliente) {
		return clienteService.salvarCliente(cliente);
	}
	
	@GetMapping
	public ResponseEntity<List<Venda>>  buscarTodosClientes(){
		List<Venda> buscarTodosClientes = clienteService.buscarTodosClientes();
		return new ResponseEntity<>(buscarTodosClientes,HttpStatus.OK);
	}

}
