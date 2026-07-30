package transaction_com.transaction.api.transaction_processor.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import transaction_com.transaction.api.transaction_processor.entity.Transaction;

public interface TransactionRepository
        extends JpaRepository<Transaction, Long> {

    // =========================================
    // BUSCAR POR ID
    // =========================================
    Optional<Transaction> findById(Long id);

    // =========================================
    // BUSCAR POR CLIENTE
    // =========================================
    @Query("SELECT t FROM Transaction t WHERE t.cliente = :cliente")
    List<Transaction> findByCliente(
            @Param("cliente") String cliente);

    // =========================================
    // BUSCAR POR ESTATUS
    // =========================================
    @Query("SELECT t FROM Transaction t WHERE t.estatus = :estatus")
    List<Transaction> findByEstatus(
            @Param("estatus") String estatus);

    // =========================================
    // BUSCAR POR OPERACION
    // =========================================
    @Query("SELECT t FROM Transaction t WHERE t.operacion = :operacion")
    List<Transaction> findByOperacion(
            @Param("operacion") String operacion);

    // =========================================
    // BUSCAR POR REFERENCIA
    // =========================================
    @Query("SELECT t FROM Transaction t WHERE t.referencia = :referencia")
    Optional<Transaction> findByReferencia(
            @Param("referencia") String referencia);

    // =========================================
    // BUSCAR POR RANGO DE IMPORTE
    // =========================================
    @Query("SELECT t FROM Transaction t " +
           "WHERE t.importe BETWEEN :min AND :max")
    List<Transaction> findByImporteRange(
            @Param("min") BigDecimal min,
            @Param("max") BigDecimal max);

    // =========================================
    // BUSQUEDA FLEXIBLE CLIENTE
    // =========================================
    @Query("SELECT t FROM Transaction t " +
           "WHERE t.cliente LIKE %:cliente%")
    List<Transaction> searchCliente(
            @Param("cliente") String cliente);

    // =========================================
    // PAGINACION
    // =========================================
    Page<Transaction> findAll(Pageable pageable);

}