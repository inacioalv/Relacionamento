package br.com.inacio.ManyToOne.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import br.com.inacio.ManyToOne.exception.ResourceNotFoundException;
import br.com.inacio.ManyToOne.model.Imovel;
import br.com.inacio.ManyToOne.model.Proprietario;
import br.com.inacio.ManyToOne.repository.ImovelRepository;
import br.com.inacio.ManyToOne.repository.ProprietarioRepository;

@Service
public class ProprietarioService {

	private ProprietarioRepository proprietarioRepository;
	private ImovelRepository imovelRepository;

	public ProprietarioService(ProprietarioRepository proprietarioRepository, ImovelRepository imovelRepository) {
		super();
		this.proprietarioRepository = proprietarioRepository;
		this.imovelRepository = imovelRepository;
	}

	public Proprietario salvar(Proprietario obj) {
		if (obj.getImoveies() != null) {
			for (Imovel o : obj.getImoveies()) {
				o.setProprietario(obj);
			}
		}
		return proprietarioRepository.save(obj);
	}

	public List<Proprietario> buscarTodos() {
		return proprietarioRepository.findAll();
	}

	public Proprietario buscarPorId(Long id) {
		Optional<Proprietario> findById = proprietarioRepository.findById(id);
		return findById.orElseThrow(() -> new ResourceNotFoundException("Proprietario não encontrado com ID:" + id));
	}

	public Proprietario atualizar(Proprietario obj) {
		verificarSeExiste(obj.getId());
		Set<Imovel> imovelDeletar = new HashSet<>();
		//Recuperar o imovel
		Proprietario objAtualizar = buscarPorId(obj.getId());
		//vincular o imovel com proprietario
		if (obj.getImoveies() != null) {
			for (Imovel o : obj.getImoveies()) {
				o.setProprietario(obj);
			}
			//pecorrer a lista que já está vinculada
			for (Imovel imovelAtualizar : objAtualizar.getImoveies()) {
				boolean isPresent = false;
				//percorrer a lista que veio no objeto
				for (Imovel o : obj.getImoveies()) {
					//verificar se o imovel já existe na lista
					if(imovelAtualizar.getId()!= null && imovelAtualizar.getId().equals(o.getId())) {
						isPresent= true;
					}
				}
				//se o imovel não estiver na lista sera adicionado 
				if(!isPresent) {
					imovelDeletar.add(imovelAtualizar);
				}
			}
			
		}
		//atualizar proprietario
		obj = proprietarioRepository.save(obj);
		//remover a lista de imovel
		imovelRepository.deleteAll(imovelDeletar);
		return obj;
	}

	private Proprietario verificarSeExiste(Long id) throws ResourceNotFoundException {
		return proprietarioRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Proprietario não encontrado com ID:" + id));
	}

}