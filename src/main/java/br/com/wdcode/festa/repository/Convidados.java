package br.com.wdcode.festa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.wdcode.festa.model.Convidado;

public interface Convidados extends JpaRepository<Convidado, Long> {

}
