package br.com.luiztictac.minhasFinancas.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.luiztictac.minhasFinancas.exceptions.ErroAutenticacao;
import br.com.luiztictac.minhasFinancas.exceptions.RegraNegocioException;
import br.com.luiztictac.minhasFinancas.model.entity.Usuario;
import br.com.luiztictac.minhasFinancas.model.repository.UsuarioRepository;
import br.com.luiztictac.minhasFinancas.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	private UsuarioRepository repository;

	public UsuarioServiceImpl(UsuarioRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public Usuario autenticar(String email, String senha) {
		Optional<Usuario> usuario =repository.findByEmail(email);
		
		if(!usuario.isPresent()) {
			throw new ErroAutenticacao("Usuário não encontrado!");// não indicar causa real do erro
		}
		
		if(!usuario.get().getSenha().equals(senha)) {
			throw new ErroAutenticacao("Senha ou e-mail inválidos!!"); //não indicar causa real do erro
		}
		return usuario.get();
	}

	@Override
	@Transactional
	public Usuario salvarUsuario(Usuario usuario) {
		validarEmail(usuario.getEmail());
		return repository.save(usuario);
	}

	@Override
	public void validarEmail(String email) {
		boolean existe = repository.existsByEmail(email);
		if (existe) {
			throw new RegraNegocioException("Já existe um usuário cadastrado com esse email!");
		}

	}
	@Override
	public Optional<Usuario>  obterPorId(Long id) {
		return repository.findById(id);
	}

}
