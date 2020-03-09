package com.livelo.client.backend

import com.livelo.client.core.domain.Cliente
import com.livelo.client.core.domain.Sexo
import com.livelo.client.core.ports.driver.ClienteService
import com.livelo.client.core.validation.BusinessException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.DirtiesContext
import spock.lang.Specification
import spock.lang.Unroll

import java.time.LocalDate
import java.time.Month
import static java.util.Objects.nonNull


@SpringBootTest
@DirtiesContext
class ClientServiceTest extends Specification {

    @Autowired
    protected ClienteService clienteService

    @Unroll
    def "salvar o cliente #nome"() {
        given:
        Cliente cliente = new Cliente()
        cliente.setDataNascimento(LocalDate.of(1997, Month.APRIL, 15))
        cliente.setIdade(idade)
        cliente.setNomeCompleto(nome)
        cliente.setSexo(sexo)

        when:
        def clientePersistido = clienteService.salvar(cliente)

        then:
            cliente.getIdade() >= 18
            nonNull(clientePersistido)
            nonNull(clientePersistido.getId())
        where:
        idade | nome   | sexo
        18    | "Joao" | Sexo.MASCULINO
        19    | "Ana"  | Sexo.FEMININO

    }


    def "salvar com erro usuario menor de idade"() {
        given:
        Cliente cliente = new Cliente()
        cliente.setDataNascimento(LocalDate.of(1997, Month.APRIL, 15))
        cliente.setIdade(15)
        cliente.setNomeCompleto("Joao Paulo Oliveira Santos")
        cliente.setSexo(Sexo.MASCULINO)

        when:
        def clientePersistido = clienteService.salvar(cliente)

        then:
        thrown(BusinessException)
    }
}
