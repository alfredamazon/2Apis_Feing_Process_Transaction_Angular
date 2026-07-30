package transaction_com.transaction.api.transaction_processor.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import transaction_com.transaction.api.transaction_processor.dto.TransactionRequest;
import transaction_com.transaction.api.transaction_processor.dto.TransactionResponse;
import transaction_com.transaction.api.transaction_processor.entity.Transaction;
import transaction_com.transaction.api.transaction_processor.repository.TransactionRepository;

@Service
public class TransactionService {

    private final TransactionRepository repository;

    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    // =========================================
    // GUARDAR TRANSACCION
    // =========================================
    public TransactionResponse save(TransactionRequest req) {

        Transaction tx = new Transaction();

        tx.setOperacion(req.getOperacion());
        tx.setImporte(req.getImporte());
        tx.setCliente(req.getCliente());

        // DATO DESCIFRADO DESDE GATEWAY
        tx.setSecreto(req.getSecreto());

        // DATOS AUTOMATICOS
        tx.setEstatus("Aprobada");
        tx.setReferencia(generateReference());

        // SAVE
        Transaction saved = repository.save(tx);

        return buildResponse(saved);
    }

    // =========================================
    // BUSCAR POR ID
    // =========================================
    public Optional<Transaction> findById(Long id) {

        return repository.findById(id);
    }

    // =========================================
    // BUSCAR POR CLIENTE
    // =========================================
    public List<Transaction> findByCliente(String cliente) {

        return repository.findByCliente(cliente);
    }

    // =========================================
    // BUSCAR POR ESTATUS
    // =========================================
    public List<Transaction> findByEstatus(String estatus) {

        return repository.findByEstatus(estatus);
    }

    // =========================================
    // BUSCAR POR OPERACION
    // =========================================
    public List<Transaction> findByOperacion(String operacion) {

        return repository.findByOperacion(operacion);
    }

    // =========================================
    // BUSCAR POR REFERENCIA
    // =========================================
    public Optional<Transaction> findByReferencia(String referencia) {

        return repository.findByReferencia(referencia);
    }

    // =========================================
    // BUSCAR POR RANGO DE IMPORTE
    // =========================================
    public List<Transaction> findByImporteRange(
            BigDecimal min,
            BigDecimal max) {

        return repository.findByImporteRange(min, max);
    }

    // =========================================
    // BUSQUEDA FLEXIBLE CLIENTE
    // =========================================
    public List<Transaction> searchCliente(String cliente) {

        return repository.searchCliente(cliente);
    }

    // =========================================
    // PAGINACION
    // =========================================
    public Page<Transaction> getAll(
            int page,
            int size,
            String sortBy) {

        Pageable pageable = PageRequest.of(
                page,
                size,
                Sort.by(sortBy).descending());

        return repository.findAll(pageable);
    }

    // =========================================
    // GENERAR REFERENCIA
    // =========================================
    private String generateReference() {

        int number = new Random()
                .nextInt(900000) + 100000;

        return String.valueOf(number);
    }

    // =========================================
    // BUILD RESPONSE
    // =========================================
    private TransactionResponse buildResponse(
            Transaction tx) {

        return new TransactionResponse(
                tx.getId().toString(),
                tx.getEstatus(),
                tx.getReferencia(),
                tx.getOperacion()
        );
    }
}