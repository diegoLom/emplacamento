package org.emplacamento.services;


import java.util.Optional;


import org.springframework.stereotype.Service;


@Service
public  abstract interface BaseService<T, I> {
	
	
	public Optional<T> pegar(I i);
	
	public T pegarT(I id);
	
	public void deletarT(I id);
	
	public T createT( T t);
	
	public T atualizarT( T t,  I id);
	
	public Boolean deletar(I i);

}
