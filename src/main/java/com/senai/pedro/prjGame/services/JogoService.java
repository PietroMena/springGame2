package com.senai.pedro.prjGame.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.pedro.prjGame.entities.Jogo;
import com.senai.pedro.prjGame.repositories.JogoRepository;

import java.util.Optional;


@Service
public class JogoService {

	private final JogoRepository jogoRepository;
	
	@Autowired
	public JogoService(JogoRepository jogoRepository) {
		this.jogoRepository = jogoRepository;
	}
	//preparando as buscas por id
	public Jogo getJogoById(Long id) {
		return jogoRepository.findById(id).orElse(null);
	}
	
		//preparando a busca geral
		public List<Jogo> getAllJogo(){
			return jogoRepository.findAll();
		}
		
		//salvando o jooo
		public Jogo saveJogo(Jogo jogo) {
			return jogoRepository.save(jogo);
		}
		
		//excluindo o jogo
		public void deleteJogo(Long id) {
			jogoRepository.deleteById(id);
		}
		// fazendo o update do jogo com o optional
		public Jogo updateJogo(Long id, Jogo novoJogo) {
	        Optional<Jogo> jogoOptional = jogoRepository.findById(id);
	        if (jogoOptional.isPresent()) {
	        	Jogo jogoExistente = jogoOptional.get();
	           	jogoExistente.setName(novoJogo.getName());
	        	jogoExistente.setPlataform(novoJogo.getPlataform());          
	            return jogoRepository.save(jogoExistente); 
	        } else {
	            return null; 
	        }
	    }
}
