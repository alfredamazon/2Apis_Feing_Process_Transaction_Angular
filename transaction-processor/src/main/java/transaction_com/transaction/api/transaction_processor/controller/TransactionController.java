package transaction_com.transaction.api.transaction_processor.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import transaction_com.transaction.api.transaction_processor.dto.TransactionRequest;
import transaction_com.transaction.api.transaction_processor.dto.TransactionResponse;
import transaction_com.transaction.api.transaction_processor.entity.Transaction;
import transaction_com.transaction.api.transaction_processor.service.TransactionService;

@RestController
@RequestMapping("/api/v1/processor")
public class TransactionController {

    private final TransactionService service;

    public TransactionController(TransactionService service) {
        this.service = service;
    }

    // =========================================
    // POST - GUARDAR TRANSACCION
    // =========================================
    @PostMapping
    public ResponseEntity<TransactionResponse> process(
            @Valid @RequestBody TransactionRequest request) {

        TransactionResponse response = service.save(request);

        return ResponseEntity.ok(response);
    }

    // =========================================
    // GET - BUSCAR POR ID
    // =========================================
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Transaction>> getById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                service.findById(id));
    }

    // =========================================
    // GET - BUSCAR POR CLIENTE
    // =========================================
    @GetMapping("/cliente/{cliente}")
    public ResponseEntity<List<Transaction>> getByCliente(
            @PathVariable String cliente) {

        return ResponseEntity.ok(
                service.findByCliente(cliente));
    }

    // =========================================
    // GET - BUSCAR POR ESTATUS
    // =========================================
    @GetMapping("/estatus/{estatus}")
    public ResponseEntity<List<Transaction>> getByEstatus(
            @PathVariable String estatus) {

        return ResponseEntity.ok(
                service.findByEstatus(estatus));
    }

    // =========================================
    // GET - BUSCAR POR OPERACION
    // =========================================
    @GetMapping("/operacion/{operacion}")
    public ResponseEntity<List<Transaction>> getByOperacion(
            @PathVariable String operacion) {

        return ResponseEntity.ok(
                service.findByOperacion(operacion));
    }

    // =========================================
    // GET - BUSCAR POR REFERENCIA
    // =========================================
    @GetMapping("/referencia/{referencia}")
    public ResponseEntity<Optional<Transaction>> getByReferencia(
            @PathVariable String referencia) {

        return ResponseEntity.ok(
                service.findByReferencia(referencia));
    }

    // =========================================
    // GET - BUSCAR POR RANGO DE IMPORTE
    // =========================================
    @GetMapping("/importe")
    public ResponseEntity<List<Transaction>> getByImporteRange(
            @RequestParam BigDecimal min,
            @RequestParam BigDecimal max) {

        return ResponseEntity.ok(
                service.findByImporteRange(min, max));
    }

    // =========================================
    // GET - SEARCH FLEXIBLE
    // =========================================
    @GetMapping("/search/{cliente}")
    public ResponseEntity<List<Transaction>> searchCliente(
            @PathVariable String cliente) {

        return ResponseEntity.ok(
                service.searchCliente(cliente));
    }

    // =========================================
    // GET - PAGINACION
    // =========================================
    @GetMapping("/all")
    public ResponseEntity<Page<Transaction>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy) {

        return ResponseEntity.ok(
                service.getAll(page, size, sortBy));
    }
}