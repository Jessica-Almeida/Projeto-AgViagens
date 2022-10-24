package br.com.jntour.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.jntour.models.Cliente;
import br.com.jntour.models.UserDetailsImpl;
import br.com.jntour.repositories.ClienteRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private ClienteRepository clienteRepository;

	 @Override
	    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	        Cliente cliente = clienteRepository.findByEmail(email)
	            .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

	        return new UserDetailsImpl(cliente);
		}

	}
