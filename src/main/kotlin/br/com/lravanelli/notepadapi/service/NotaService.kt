package br.com.lravanelli.notepadapi.service

import br.com.lravanelli.notepadapi.model.Nota
import br.com.lravanelli.notepadapi.repository.NotaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class NotaService{
    @Autowired
    lateinit var notaRespository: NotaRepository

    fun salvar(nota: Nota) {
        val aux = notaRespository.findByTitulo(nota.titulo)
        if(aux != null){
            nota.id = aux.id
        }
        notaRespository.save(nota)
    }

    fun buscarTodas(): List<Nota> {
        return  notaRespository.findAll()
    }

    fun buscar(titulo: String): Nota {
        return notaRespository.findByTitulo(titulo)
    }
}